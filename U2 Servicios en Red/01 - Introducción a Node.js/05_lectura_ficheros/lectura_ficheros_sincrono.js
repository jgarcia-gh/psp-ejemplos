const fs = require('fs');
const path = require('path');

// Método síncrono
const rutaArchivo = path.join(__dirname, 'prueba.txt');

try {
  const data = fs.readFileSync(rutaArchivo, 'utf8');
  console.log(data);
} catch (err) {
  console.error(err);
}