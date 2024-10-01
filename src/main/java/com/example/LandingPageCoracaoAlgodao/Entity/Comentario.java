package com.example.LandingPageCoracaoAlgodao.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comentarios")
@Getter
@Setter
@NoArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "notaProjeto", nullable = false)
    private int notaProjeto;

    @Column(name = "sugestao", nullable = false)
    private String sugestao;

    public Comentario(String email, int notaProjeto, String sugestao) {
        this.email = email;
        this.notaProjeto = notaProjeto;
        this.sugestao = sugestao;
    }

}
