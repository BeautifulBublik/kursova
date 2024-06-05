package com.example.Dao;

import com.example.model.ApartmentParameters;
import com.example.model.Apartments;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class InMemoryDao implements Dao{
    TreeMap<Integer,Apartments> apartments=new TreeMap<>();
    @Override
    public void create(Apartments apart) {
        int newId= apartments.isEmpty()? 1:apartments.lastKey()+1;
        apart.setId(newId);
        apartments.put(newId,apart);
    }

    @Override
    public void delete(Integer id) {
        apartments.remove(id);

    }

    @Override
    public void update(Apartments newApart) {
       apartments.put(newApart.getId(), newApart);
    }

    @Override
    public Collection<Apartments> findByParameters(ApartmentParameters parameters) {
        return apartments.values().stream().filter(apartment ->
                apartment.getNumberOfRooms() >= parameters.getMinRooms() &&
                        apartment.getNumberOfRooms() <= parameters.getMaxRooms() &&
                        apartment.getArea() >= parameters.getMinArea() &&
                        apartment.getArea() <= parameters.getMaxArea() &&
                        apartment.getRentPrice() >= parameters.getMinRentPrice() &&
                        apartment.getRentPrice() <= parameters.getMaxRentPrice()
        ).collect(Collectors.toList());

    }

    @Override
    public Collection<Apartments> findAll() {
        return apartments.values();
    }

    @Override
    public Apartments findById(Integer id) {
        return apartments.get(id);
    }

    @Override
    public Collection<Apartments> findByAdress(String address) {
        return apartments.values().stream()
                .filter(apartments1 ->apartments1.getAddress().equals(address)).collect(Collectors.toList());
    }


    @Override
    public Collection<Apartments> sortByPrice() {
        return apartments.values().stream()
                .sorted(Comparator.comparing(Apartments::getRentPrice))
                .collect(Collectors.toList());

    }

    @Override
    public Collection<Apartments> sortByArea() {
        return  apartments.values().stream()
                .sorted(Comparator.comparing(Apartments::getArea))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Apartments> sortByNumberOfRooms() {
        return  apartments.values().stream()
                .sorted(Comparator.comparing(Apartments::getNumberOfRooms))
                .collect(Collectors.toList());
    }
}
