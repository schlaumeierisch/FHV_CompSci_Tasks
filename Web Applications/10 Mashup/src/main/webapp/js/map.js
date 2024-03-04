const map = L.map('map').setView([50, 15], 5);
let eventMarkers = [];
let eventMarkerCoordinates = [];

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1Ijoic2NobGF1bWVpZXJpc2NoIiwiYSI6ImNreDA4dWhrbTE1ZzIzMHVyMnVlM3p0NG0ifQ.OLN8J7uHTQPagYPbog9Dog'
}).addTo(map);


$.get('https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.festivalticker.de%2Frss-festivalfeed%2Ffestivalkalender1-60.xml', function (response) {
    $.each(response.items, function (index, item) {
        // filter event date and title
        const eventDate = /[^a-zA-Z]*/.exec(item.title);
        const eventTitle = item.title.replace(eventDate, "");

        // filter event location
        const eventLocation = /Ort: \d+ ([\wäöüßÄÖÜ\- ]*)<br>Land: ([\wäöüßÄÖÜ\- ]*)/gm.exec(item.description);

        // add new table row (title, date, description)
        const event = $('<tr style="cursor: pointer">');
        event.html(`<td>` + eventTitle + `</td><td>` + eventDate + `</td><td>${item.description}</td></tr>`);

        if (eventLocation) {
            event.attr('event', index);
            event.on('click', function () {
                if (typeof eventMarkerCoordinates[index] === 'undefined') {
                    addEventMarker(index, eventTitle, eventDate, `${eventLocation[1]} ${eventLocation[2]}`);
                } else {
                    eventMarkers[index].openPopup();
                    map.flyTo(eventMarkerCoordinates[index], 10);
                    document.getElementById("map").scrollIntoView();
                }
            });
        }

        $('#events').append(event);
    });
});

function addEventMarker(eventId, eventTitle, eventDate, location) {
    $.get(`https://nominatim.openstreetmap.org/search?q=${location}&limit=1&format=json&addressdetails=1`, function (response) {
        const latitude = response[0].lat;
        const longitude = response[0].lon;

        const eventMarker = L.marker([latitude, longitude]).addTo(map);

        eventMarker.bindPopup(`<b>` + eventTitle + `</b><br>` + eventDate).openPopup();
        map.flyTo([latitude, longitude], 10);
        document.getElementById("map").scrollIntoView();

        eventMarkers[eventId] = eventMarker;
        eventMarkerCoordinates[eventId] = [latitude, longitude];
    });
}