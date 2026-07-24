const { Alumno } = require('./modelo.js'); // importar modelos

async function obtenerAlumnos(email) {
  try {
    // Buscar todos los alumnos
    const alumnos = await Alumno.find({'email': email});

    console.log('Todos los alumnos:');
    console.log(JSON.stringify(alumnos, null, 2));
  } catch (error) {
    console.error('Error al obtener alumnos:', error);
  }
}

//obtenerAlumnos('carlos@instituto.es');

async function obtenerSuspendidos() {
  try {
    // Buscar todos los alumnos
    const alumnos = await Alumno.find( {'matriculas.nota': { $lt: 5 } });

    console.log('Todos los alumnos:');
    console.log(JSON.stringify(alumnos, null, 2));
  } catch (error) {
    console.error('Error al obtener alumnos:', error);
  }
}

//obtenerSuspendidos();

async function obtenerAlumnosConAsignaturas() {
  try {
    // Buscar todos los alumnos y "poblar" las asignaturas de sus matrículas
    const alumnos = await Alumno.find()
      .populate('matriculas.asignatura', 'nombre curso horas'); 
      // 'nombre curso horas' indica los campos que queremos traer de la asignatura

    console.log('Alumnos con asignaturas pobladas:');
    console.log(JSON.stringify(alumnos, null, 2)); // impresión legible
  } catch (error) {
    console.error('Error al obtener alumnos:', error);
  }
}

obtenerAlumnosConAsignaturas();

