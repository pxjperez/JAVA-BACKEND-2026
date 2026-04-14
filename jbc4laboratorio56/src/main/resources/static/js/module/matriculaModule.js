$(document).ready(function() {
    ocultarError();
    listarMatricula();
});

function mostrarError(mensajeError) {
    $('#mensajeError').text(mensajeError);
    $('#divMensajeError').show();
}

function ocultarError() {
    $('#divMensajeError').hide();
}

function formatearFechaIso(fechaIso) {
    if (!fechaIso) return '';
    var fecha = new Date(fechaIso);
    if (isNaN(fecha.getTime())) return '';
    return fecha.toLocaleDateString('es-PE', {
        day: '2-digit',
        month: '2-digit',
        year: 'numeric'
    });
}

function listarMatricula() {
    $.ajax({
        url: '/api/matriculas',
        method: 'GET',
        success: function(data) {
            var tabla = $('#tabla-matriculas');
            tabla.empty(); // Limpiar la tabla antes de agregar los nuevos datos

            data.forEach(function(matricula) {
                var fila = '<tr>' +
                    '<td>' + matricula.idMatricula + '</td>' +
                    '<td>' + formatearFechaIso(matricula.fechaMatricula) + '</td>' +
                    '<td>' + matricula.usuario.nombreCompleto + '</td>' +
                    '<td>' + matricula.curso.nombreCurso + '</td>' +
                    '<td>' + matricula.estadoString + '</td>' +
                    '</tr>';
                tabla.append(fila);
            });
        },
        error: function(error) {
            var mensajeError = 'Error al cargar las matrículas:'+error;                            
            mostrarError(mensajeError   );
        }
    });
}