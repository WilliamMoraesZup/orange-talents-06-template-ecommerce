package com.zup.william.desafiomercadolivre.desafiomercadolivre.seguranca;

import org.springframework.security.core.userdetails.UserDetails;


public interface UserDetailsMapper {
    UserDetails map(Object shouldBeASystemUser);
}
