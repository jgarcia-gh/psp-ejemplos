const http = require("http");

const server = http.createServer((request, response) => {
    console.log("Se ha producido una petición")
});

server.listen(8080);