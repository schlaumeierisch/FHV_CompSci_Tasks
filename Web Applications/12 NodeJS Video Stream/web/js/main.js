document.addEventListener('DOMContentLoaded', function() {
    const videoName = document.getElementById('videoName');
    const submitButton = document.getElementById('searchVideo');
    const videoPlayer = document.getElementById('videoPlayer');

    submitButton.addEventListener('click', () => {
        fetch('http://localhost:8080/getVideo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                video: videoName.value
            })
        })
            .then(res => res.json())
            .then(data => {
                if (data.exists) {
                    videoPlayer.src = 'http://localhost:8080/videos/' + videoName.value;
                    videoPlayer.hidden = false;
                    videoPlayer.autoplay = true;
                } else {
                    alert('Video not found.');
                }
            })
            .catch(() => console.log('Error!'));
    });
});