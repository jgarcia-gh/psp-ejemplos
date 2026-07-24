app.post('/alumnos', (req, res) => {
  let {nombre, email, matriculas} = req.body;
  console.log("Nombre: " + nombre);
  console.log("Email: " + email);
  console.log("Matriculas: " + JSON.stringify(matriculas, null, 2);
  res.send();
});