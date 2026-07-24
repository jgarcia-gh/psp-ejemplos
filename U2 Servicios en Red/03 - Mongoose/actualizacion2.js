const { Alumno } = require('./modelo.js'); // CommonJS

async function actualizarNotaMatricula(emailAlumno, asignaturaId, nuevaNota) {
  try {
    // Buscar todos los alumnos con ese email
    const alumnos = await Alumno.find({ email: emailAlumno });

    if (alumnos.length === 0) {
      console.log('No se encontraron alumnos con ese email');
      return;
    }

    // Recorrer cada alumno encontrado
    for (const alumno of alumnos) {
      // Buscar las matrículas específicas dentro del array
      const matriculasCoincidentes = alumno.matriculas.filter(
        m => m.asignatura.toString() === asignaturaId
      );

      
      // Actualizar la nota
      matriculasCoincidentes.forEach(m => m.nota = nuevaNota);
      
      // Guardar cambios
      await alumno.save();

      console.log(`Alumno actualizado: ${alumno.nombre}`);
      console.log(JSON.stringify(alumno, null, 2));
    }

  } catch (error) {
    console.error('Error al actualizar la matrícula:', error);
  }
}

// Ejemplo de uso
actualizarNotaMatricula(
  'carlos@instituto.es',          // email del alumno
  '64f2b1a123456789abcdef02',     // _id de la asignatura
  8                               // nueva nota
);