let http = require('http');

http.createServer(function (req, res) {
    // add headers to allow CORS requests
    // website(s)
    res.setHeader('Access-Control-Allow-Origin', '*');

    // request method
    res.setHeader('Access-Control-Request-Method', '*');

    // method(s)
    res.setHeader('Access-Control-Allow-Methods', 'POST, OPTIONS');

    // header(s)
    res.setHeader('Access-Control-Allow-Headers', '*');


    // handle preflight (CORS) requests
    if (req.method === 'OPTIONS') {
        res.writeHead(200);
        res.end();
    }

    // post character count
    else if (req.method === 'POST') {
        res.writeHead(200, {
            'Content-Type': 'application/json'
        });

        let body = '';

        req.on('data', function (chunk) {
            body = chunk;
        });

        req.on('end', function () {
            let len = JSON.stringify({
                charCount: JSON.parse(body).string.length
            });

            res.end(len);
        });
    } else {
        res.statusCode = 405;
        res.end();
    }
}).listen(8080);

console.debug('Node.js web server at port 8080 is running..');