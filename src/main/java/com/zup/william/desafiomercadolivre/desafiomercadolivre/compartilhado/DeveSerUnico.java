package com.zup.william.desafiomercadolivre.desafiomercadolivre.compartilhado;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {CampoDeveSerUnicoValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface DeveSerUnico {

    String value();

    Class classe();

    String message() default "O registro já se encontra cadastrado no banco";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
