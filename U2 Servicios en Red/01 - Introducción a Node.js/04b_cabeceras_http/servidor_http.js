const http = require("http");

const server = http.createServer((request, response) => {
    console.log("Se ha producido una petición")
    console.log("URL: " + request.url)
    console.log("Método: " + request.method)
    console.log("Algunos campos de la cabecera:")
    console.log("Host: " + request.headers['host'])
    console.log("User-Agent: " + request.headers['user-agent'])
    console.log("Accept-Language: " + request.headers['accept-language'])

});

server.listen(8080);