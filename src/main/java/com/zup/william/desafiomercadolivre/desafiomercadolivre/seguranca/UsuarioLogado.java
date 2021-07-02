package com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

public class UsuarioLogado implements UserDetails {

    private Usuario usuario;
    private User springUserDetails;

    public UsuarioLogado(@NotNull @Valid Usuario user) {
        this.usuario = user;
        System.out.println(user);
        System.out.println("USURAIO LOGADO");
        springUserDetails = new User(usuario.getLogin(), usuario.getSenha(), List.of());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return springUserDetails.getAuthorities();
    }

    @Override
    public String getPassword() {
        return springUserDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return springUserDetails.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
