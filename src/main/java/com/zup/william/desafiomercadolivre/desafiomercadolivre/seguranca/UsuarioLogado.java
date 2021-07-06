package com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import io.jsonwebtoken.lang.Assert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

public class UsuarioLogado implements UserDetails {

    private Usuario usuario;
    private User springUserDetails;

    public UsuarioLogado(@NotNull @Valid Usuario usuario) {
        this.usuario = usuario;
        springUserDetails = new User(usuario.getLogin(), usuario.getSenha(), List.of());
    }


    public Collection<GrantedAuthority> getAuthorities() {
        return springUserDetails.getAuthorities();
    }


    public String getPassword() {
        return springUserDetails.getPassword();
    }


    public String getUsername() {
        return springUserDetails.getUsername();
    }


    public boolean isEnabled() {
        return springUserDetails.isEnabled();
    }


    public boolean isAccountNonExpired() {
        return springUserDetails.isAccountNonExpired();
    }


    public boolean isAccountNonLocked() {
        return springUserDetails.isAccountNonLocked();
    }


    public boolean isCredentialsNonExpired() {
        return springUserDetails.isCredentialsNonExpired();
    }


    public Usuario get() {
        return usuario;
    }


    /**
     * Nova função criada para facilitar a extração do ID do usuario Logado
     * @param manager
     * @return ID DO USUARIO
     */
    public Long getIdUsuarioLogado(EntityManager manager) {
        Query query = manager.createQuery("from Usuario where login = :pLogin");
        query.setParameter("pLogin", getUsername());
        List<Usuario> resultList = query.getResultList();
        Assert.state(resultList.size() <= 1, "Houve um bug no sistema e existe mais de um usuario com o mesmo Login");
        Usuario usuario = resultList.get(0);
        return usuario.getId();

    }


}