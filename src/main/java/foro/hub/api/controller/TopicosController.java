package foro.hub.api.controller;

import foro.hub.api.topico.DatosRegistroTopico;
import foro.hub.api.topico.Topico;
import foro.hub.api.topico.TopicosRepository;
import foro.hub.api.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    private TopicosRepository topicosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    public void registrar(@RequestBody DatosRegistroTopico datos){
        var usuario = usuarioRepository.findById(datos.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var topico = new Topico(usuario, datos);
        topicosRepository.save(topico);
    }
}
