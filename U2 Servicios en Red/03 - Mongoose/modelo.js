const mongoose = require('mongoose');

mongoose.connect('mongodb://127.0.0.1:27017/ejemplo');

const asignaturaSchema = new mongoose.Schema({
  nombre: { type: String, required: true },
  curso: { type: String, required: true }, // 1º DAM, 2º DAM
  horas: Number
});

const Asignatura = mongoose.model('Asignatura', asignaturaSchema);

const matriculaSchema = new mongoose.Schema({
  asignatura: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'Asignatura',
    required: true
  },
  nota: {
    type: Number,
    min: 0,
    max: 10
  },
  convocatoria: {
    type: String,
    enum: ['ordinaria', 'extraordinaria'],
    default: 'ordinaria'
  }
});

const alumnoSchema = new mongoose.Schema({
  nombre: String,
  email: String,
  matriculas: [matriculaSchema]
});


const Alumno = mongoose.model('Alumno', alumnoSchema);

module.exports = { Asignatura, Alumno };
