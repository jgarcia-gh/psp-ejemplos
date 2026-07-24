const { Alumno } = require('./modelo.js'); 

async function modificarAlumno() {
  try {
    // Buscar alumno por email
    const alumno = await Alumno.findOne({ email: 'carlos@instituto.es' });

    if (!alumno) {
      console.log('Alumno no encontrado');
      return;
    }

    // Modificar campos
    alumno.email = 'carlos@ies.es';
    alumno.nombre = 'Carlos Pérez Martínez';

    // Guardar cambios
    const alumnoActualizado = await alumno.save();

    // Mostrar resultado legible
    console.log(JSON.stringify(alumnoActualizado, null, 2));

  } catch (error) {
    console.error('Error al modificar alumno:', error);
  }
}

modificarAlumno();
