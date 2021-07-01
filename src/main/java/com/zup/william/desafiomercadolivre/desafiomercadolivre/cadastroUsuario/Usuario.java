package com.william.mercadolivre.mercadolivre.cadastroUsuario;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;


    @NotBlank
    @Email
    private String login;

    @NotBlank
    @Length(min = 6)
    private String senha;
    private Instant momentoCadastro = Instant.now();

    public Usuario(String nome, String login, String senha ) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }
}
