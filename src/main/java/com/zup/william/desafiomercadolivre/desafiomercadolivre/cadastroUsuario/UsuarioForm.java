package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.compartilhado.DeveSerUnico;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioForm {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @DeveSerUnico(value = "login", classe = Usuario.class)
    private String login;

    @NotBlank
    @Length(min = 6)
    private String senha;

    public UsuarioForm(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario toModel() {
        Assert.hasLength(senha, "senha não pode ser em branco");
        Assert.isTrue(senha.length() >= 6, "Senha tem que ser no minimo 6 caracteres");

        return new Usuario(nome, login, senha = criptografa(senha));
    }


    private String criptografa(String senha) {

        return new BCryptPasswordEncoder().encode(senha);
    }

}


/* senha antiga
  MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();
        return senhahex;
 */