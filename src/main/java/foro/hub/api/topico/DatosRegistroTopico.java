package foro.hub.api.topico;

public record DatosRegistroTopico(
        Long idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
