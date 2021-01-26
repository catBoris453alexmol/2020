package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.Dao;
import ru.sapteh.dao.impl.DaoImpl;
import ru.sapteh.model.Hotel;
import ru.sapteh.model.Putevka;
import ru.sapteh.model.TourOperator;
import ru.sapteh.model.Tourist;

public class Main {
    public static void main(String[] args) {

        Putevka putevka = new Putevka();
        Tourist tourist = new Tourist();
        TourOperator tourOperator = new TourOperator();
        Hotel hotel = new Hotel();

        SessionFactory factory = null;

        try {
            factory = new Configuration().configure().buildSessionFactory();
            Dao<Putevka, Integer> dao = new DaoImpl(factory);
            putevka.setNumber(11212);
            putevka.setSending("20.12.2020");

            putevka.setReturn_date("20.01.2021");
            tourist.setFirstName("Grebov");
            tourist.setName("gleb");
            tourist.setPatronomic("fgfg");
            tourist.setPasseries(1212);
            tourist.setNumbseries(121243);
            putevka.setTourist(tourist);
            tourOperator.setName("Alex-sis");
            putevka.setTourOperator(tourOperator);
            hotel.setName("Anuta");
            hotel.setMaintenance("Super");
            putevka.setHotel(hotel);
            dao.create(putevka);
            System.out.println(dao.read(1));



        } finally {
            if(factory != null)
                factory.close();
        }



    }
}
