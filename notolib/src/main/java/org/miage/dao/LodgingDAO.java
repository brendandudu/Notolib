package org.miage.dao;

import org.miage.model.Lodging;
import org.miage.model.Person;

import java.util.Collection;

public interface LodgingDAO {

    Lodging getLodgingById(Integer lodgingId);
    void createLodging(Person acquirer, String title, String description, Double price, String picture);
    void deleteLodging(Integer lodgingId);
    void setLodgingAcquirer(Integer lodgingId, Integer acquirerId);
    Collection<Lodging> getAllLodgings();
    Collection<Lodging> getAllLodgingsByPriceInfTo(double price);
}
