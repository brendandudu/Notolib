package org.miage.dao;

import org.miage.model.Acquirer;
import org.miage.model.Lodging;
import org.miage.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@ApplicationScoped
public class LodgingDAOImpl implements LodgingDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Lodging getLodgingById(Integer lodgingId) {
        return em.find(Lodging.class, lodgingId);
    }

    @Override
    public void createLodging(Person acquirer, String title, String description, Double price, String picture) {
        Lodging l = new Lodging(acquirer, title, description, price, picture);
        em.persist(l);
    }

    @Override
    public void deleteLodging(Integer lodgingId) {
        Lodging l = (Lodging) em.find(Lodging.class, lodgingId);
        em.remove(l);
    }

    @Override
    public void setLodgingAcquirer(Integer lodgingId, Integer acquirerId) {
        Lodging l = (Lodging) em.find(Lodging.class, lodgingId);
        Acquirer a = (Acquirer) em.find(Acquirer.class, acquirerId);
        l.setAcquirer(a);
    }

    @Override
    public Collection<Lodging> getAllLodgings() {
        return em.createNamedQuery("getAllLodgings").getResultList();
    }

    @Override
    public Collection<Lodging> getAllLodgingsByPriceInfTo(double price) {
        return em.createQuery("select l from Lodging  l where l.price <= :price").setParameter("price", price).getResultList();
    }
}
