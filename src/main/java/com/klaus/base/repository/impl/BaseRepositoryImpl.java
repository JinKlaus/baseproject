package com.klaus.base.repository.impl;

import com.klaus.base.repository.BaseRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@EnableAutoConfiguration
@ComponentScan
public class BaseRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {
    private EntityManager entityManager;
    public BaseRepositoryImpl(JpaEntityInformation entityInformation,
                              EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public List<T> find(String hql){
        return entityManager.createQuery(hql).getResultList();
    }

    public <S extends T> S save(S entity) {
        S s = super.save(entity);
        flush();
        return s;
    }

}
