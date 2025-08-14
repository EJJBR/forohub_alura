package foro.hub.api.topico;

import foro.hub.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


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

    public Topico(Usuario usuario,DatosRegistroTopico datos) {
        this.id=null;
        this.usuario=usuario;
        this.mensaje= datos.mensaje();
        this.nombreCurso=datos.nombreCurso();
        this.titulo=datos.titulo();
    }
}
