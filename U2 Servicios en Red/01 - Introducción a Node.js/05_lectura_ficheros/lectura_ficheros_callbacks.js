const fs = require('fs');
const path = require('path');

// Método con uso de callbacks
const rutaArchivo = path.join(__dirname, 'prueba.txt');
fs.readFile(rutaArchivo, 'utf8', (err, data) => {
    if (err) {
        console.error(err);
        return;
    }
    console.log(data);
});
console.log("Hola mundo!");