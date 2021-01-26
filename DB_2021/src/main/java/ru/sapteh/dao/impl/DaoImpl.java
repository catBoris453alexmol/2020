package ru.sapteh.dao.impl;

import com.sun.istack.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Putevka;


public class DaoImpl implements Dao<Putevka, Integer> {

    final SessionFactory factory;

    public DaoImpl (SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Putevka putevka) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(putevka);
            session.getTransaction().commit();
        }
    }

    @Override
    public Putevka read(@NotNull final Integer id) {
        try(Session session = factory.openSession()){
            final Putevka result = session.get(Putevka.class, id);
            if(result != null)
                Hibernate.initialize(result.getTourist());
                Hibernate.initialize(result.getHotel());
                Hibernate.initialize(result.getTourOperator());
            return result;
        }
    }

    @Override
    public void update(Putevka putevka) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(putevka);
            session.getTransaction();
        }
    }

    @Override
    public void delete(Putevka putevka) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(putevka);
            session.getTransaction();
        }
    }
}