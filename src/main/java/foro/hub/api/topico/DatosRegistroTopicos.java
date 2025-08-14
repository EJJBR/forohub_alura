package foro.hub.api.topico;

public record DatosRegistroTopicos(
        Long idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
