package com.example.LandingPageCoracaoAlgodao.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.LandingPageCoracaoAlgodao.Entity.Comentario;
import com.example.LandingPageCoracaoAlgodao.Entity.DTO.ComentarioDTO;
import com.example.LandingPageCoracaoAlgodao.Repositories.ComentarioRepository;

@Controller
@RequestMapping("/comentarios")
public class ComentarioController {
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    @PostMapping
    public ResponseEntity<Comentario> criarComentario(@RequestBody ComentarioDTO data){
        Comentario comentario = new Comentario(data.email(), data.nota(), data.comentario());
        comentarioRepository.save(comentario);
        return ResponseEntity.ok(comentario);
    }

}
