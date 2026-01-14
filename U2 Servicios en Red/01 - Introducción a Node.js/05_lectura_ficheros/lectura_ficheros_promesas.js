const fs = require('fs/promises');
const path = require('path');


async function leerArchivo (){
  try {
    const rutaArchivo = path.join(__dirname, 'prueba.txt');
    const data = await fs.readFile(rutaArchivo, 'utf8');
    console.log(data);
  } catch (err) {
    console.error(err);
  }
}

leerArchivo();
console.log("¡Hola mundo!");


