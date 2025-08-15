package foro.hub.api.controller;

import foro.hub.api.topico.*;
import foro.hub.api.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    private TopicosRepository topicosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos){
        var usuario = usuarioRepository.findById(datos.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var topico = new Topico(usuario, datos);
        topicosRepository.save(topico);
    }
    @GetMapping
    public List<DatosListaTopicos> listar() {
        return topicosRepository.findAll()
                .stream()
                .map(t -> new DatosListaTopicos(
                        t.getId(),
                        t.getTitulo(),
                        t.getMensaje(),
                        t.getFecha(),
                        t.getUsuario().getEmail(),
                        t.getNombreCurso()
                ))
                .toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detallar(@PathVariable Long id) {
        Topico topico = topicosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        DatosDetalleTopico detalle = new DatosDetalleTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getUsuario().getEmail(),
                topico.getNombreCurso()
        );

        return ResponseEntity.ok(detalle);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleTopico> actualizar(@PathVariable Long id,
                                                         @RequestBody DatosActualizarTopico datos) {
        Topico topico = topicosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        topico.actualizarInformaciones(datos);

        return ResponseEntity.ok(new DatosDetalleTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getUsuario().getEmail(),
                topico.getNombreCurso()
        ));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (!topicosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        topicosRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
