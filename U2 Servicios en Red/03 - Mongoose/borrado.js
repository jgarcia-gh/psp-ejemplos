const { Alumno } = require('./modelo.js'); // CommonJS

async function borrarAlumnoPorId(alumnoId) {
  try {
    // Buscar y borrar alumno por _id
    const eliminado = await Alumno.findByIdAndDelete(alumnoId);

    if (!eliminado) {
      console.log('No se encontró ningún alumno con ese _id');
      return;
    }

    console.log('Alumno eliminado:');
    console.log(JSON.stringify(eliminado, null, 2));

  } catch (error) {
    console.error('Error al borrar el alumno:', error);
  }
}

// Ejemplo de uso
borrarAlumnoPorId('64f2b1a123456789abcdef01');
