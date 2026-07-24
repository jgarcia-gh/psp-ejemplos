const {Asignatura, Alumno} = require('./modelo.js');

async function insertarDatos() {
  try {
    // 1. Crear una asignatura
    const asignatura = await Asignatura.create({
      nombre: 'Programación',
      curso: '1º DAM',
      horas: 256
    });

    // 2. Crear un alumno con dos matrículas a la misma asignatura
    const alumno = await Alumno.create({
      nombre: 'Carlos Pérez',
      email: 'carlos@instituto.es',
      matriculas: [
        {
          asignatura: asignatura._id,
          nota: 6.5,
          convocatoria: 'ordinaria'
        },
        {
          asignatura: asignatura._id,
          nota: 8,
          convocatoria: 'extraordinaria'
        }
      ]
    });

    console.log('Alumno insertado:', alumno);
  } catch (error) {
    console.error(error);
  }
}

insertarDatos();
