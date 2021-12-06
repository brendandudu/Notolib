package org.miage.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.dao.LodgingDAO;
import org.miage.model.Lodging;
import org.miage.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class LodgingServiceImpl implements LodgingService{

    @Inject
    LodgingDAO lodgingDAO;

    @ConfigProperty(name = "org.miage.acquirerId")
    Integer acquirerId;

    @Override
    public void createLodging(Lodging lodging) {
        lodgingDAO.createLodging(lodging.getAcquirer(), lodging.getTitle(), lodging.getDescription(), lodging.getPrice(), lodging.getPicture());
    }

    @Override
    public void createLodging(Person acquirer, String title, String description, Double price, String picture) {
        lodgingDAO.createLodging(acquirer, title, description, price, picture);
    }

    @Override
    public void deleteLodging(Integer lodgingId) {
        lodgingDAO.deleteLodging(lodgingId);
    }

    @Override
    public void setLodgingAcquirer(Integer lodgingId, Integer acquirerId) {
        acquirerId = this.acquirerId;
        lodgingDAO.setLodgingAcquirer(lodgingId, acquirerId);
    }

    @Override
    public Collection<Lodging> getAllLodgings() {
        return lodgingDAO.getAllLodgings();
    }

    @Override
    public Collection<Lodging> getAllLodgingsByPriceInfTo(double price) {
        return lodgingDAO.getAllLodgingsByPriceInfTo(price);
    }
}
