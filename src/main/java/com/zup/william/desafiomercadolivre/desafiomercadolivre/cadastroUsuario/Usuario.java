package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String login;

    @NotBlank
    @Length(min = 6)
    private String senha;

    @NotNull
    @PastOrPresent
    private Instant momentoCadastro = Instant.now();

    public Usuario(String nome, String login, String senha) {
        Assert.isTrue(StringUtils.hasLength(login),"login não pode ser em branco");

        this.senha =   new BCryptPasswordEncoder().encode(senha);

        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario() {
    }


    public String getNome() {
        return nome;
    }
}
