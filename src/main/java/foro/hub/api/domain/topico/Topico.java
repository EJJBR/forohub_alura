package foro.hub.api.domain.topico;

import foro.hub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private String mensaje;
    private String nombreCurso;
    private String titulo;
    private LocalDateTime fecha;

    public Topico(Usuario usuario,DatosRegistroTopico datos) {
        this.id=null;
        this.usuario=usuario;
        this.mensaje= datos.mensaje();
        this.nombreCurso=datos.nombreCurso();
        this.titulo=datos.titulo();
        this.fecha=LocalDateTime.now();
    }
    public void actualizarInformaciones(DatosActualizarTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.nombreCurso() != null) {
            this.nombreCurso = datos.nombreCurso();
        }
    }
}
