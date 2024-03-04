const app = require('./index');
const http = require('http');

app.set('port', 8080);

const server = http.createServer(app);
server.listen(8080);

server.on('listening', () => {
    console.log('Node.js web server at port 8080 is running..');
});

server.on('error', () => {
    console.log('Error');
});