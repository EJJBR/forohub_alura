package foro.hub.api.controller;

import foro.hub.api.topico.DatosRegistroTopicos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @PostMapping
    public void registrar(@RequestBody DatosRegistroTopicos datos){
        System.out.println(datos);
    }
}
