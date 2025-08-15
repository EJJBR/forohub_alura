package foro.hub.api.topico;

import java.time.LocalDateTime;

public record DatosListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        String autor,
        String curso
) {
}
