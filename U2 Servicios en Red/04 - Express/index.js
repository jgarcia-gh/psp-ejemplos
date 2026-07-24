const express = require("express");
const url = require("url");

const { Alumno } = require('./modelo.js'); 

const app = express();
app.use(express.json());

const port = 3000;

// Ejemplo más sencillo de endpoint get
app.get('/', (req, res) => {
  res.send('¡Hola, mundo!');
});

async function obtenerAlumnos() {
  try {
    return await Alumno.find();
  } catch (error) {
    console.error('Error al obtener alumnos:', error);
  }
}

// Endpoint que devuelve todos los alumnos
/*app.get('/alumnos', async (req, res) => {
  const alumnos = await obtenerAlumnos();
  res.status(200).json(alumnos);
});*/

// Busca un alumno por id. El id se pasa por query params.

app.get('/alumnos', (req, res) => {
    const url_parts = url.parse(req.url, true);
    res.send("Id recibido: " + url_parts.query.id);
});


// En este caso el id se pasa como route params
app.get('/alumnos/:id', (req, res) => {
    res.send("Id recibido: "+ req.params.id);
});

// Endpoint con el método Post
/*app.post('/alumnos', (req, res) => {
    console.log(req.body);
    res.send();
});*/


// Endpoint con el método Post, mostrando campos
app.post('/alumnos', (req, res) => {
  let {nombre, email, matriculas} = req.body;
  console.log("Nombre: " + nombre);
  console.log("Email: " + email);
  console.log("Matriculas: " + JSON.stringify(matriculas, null, 2));
  res.send();
});

// Iniciar el servidor
app.listen(port, () => {
  console.log(`Servidor escuchando en http://localhost:${port}`);
});


