package com.example.Dao;

import com.example.model.ApartmentParameters;
import com.example.model.Apartments;

import java.util.Collection;

public interface Dao {
     void create(Apartments apart);
     void delete(Integer id);
     void update (Apartments newApart);
     Collection<Apartments> findByParameters (ApartmentParameters parameters);
     Collection<Apartments> findByAdress (String address);
     Apartments findById(Integer id);
     Collection<Apartments> findAll();
     Collection<Apartments> sortByPrice();
     Collection<Apartments> sortByArea();
     Collection<Apartments> sortByNumberOfRooms();

}
