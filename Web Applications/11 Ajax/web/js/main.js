let input = document.getElementById('input');
let inputCounter = document.getElementById('inputCounter');
const url = 'http://localhost:8080';

input.addEventListener('input', function () {
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            string: input.value
        })
    })
        .then(res => res.json())
        .then(data => inputCounter.innerHTML = data.charCount)
        .catch(err => console.log(err));
});