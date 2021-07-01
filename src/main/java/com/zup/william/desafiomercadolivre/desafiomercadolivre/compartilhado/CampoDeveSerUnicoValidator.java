package com.zup.william.desafiomercadolivre.desafiomercadolivre.compartilhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoDeveSerUnicoValidator implements ConstraintValidator<DeveSerUnico, String> {

    private String nomeCampo;
    private Class<?> entidade;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(DeveSerUnico constraintAnnotation) {
        nomeCampo = constraintAnnotation.value();
        entidade = constraintAnnotation.classe();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("from " + entidade.getName() + " where " + nomeCampo + " = :pValue");

        query.setParameter("pValue", value);
        List resultList = query.getResultList();
        return resultList.size() > 0 ? false : true;
    }
}
