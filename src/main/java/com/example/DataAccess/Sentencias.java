/*
package com.example.DataAccess;

import com.example.Model.Clients;
import com.example.Model.Comptes;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class Sentencias {

    public static void main(String[] args) {
        getClients().forEach(clientsEntity -> {
            System.out.println(clientsEntity);
        });
        putClients();
    }
    private static List<Clients> getClients(){
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String jpql = "SELECT c FROM Clients c JOIN FETCH c.comptes";
        laSesion.beginTransaction();
        Query<Clients> query = laSesion.createQuery(jpql, Clients.class);
        List<Clients> clients = query.getResultList();

        return clients;
    }
    private static void putClients(){
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Clients clients = new Clients("XD", "españa@129.com", "Barcelona");
        clients.setClient(new Comptes("xd", new BigDecimal(15), 12));
        laSesion.persist(clients);
        laSesion.getTransaction().commit();

    }
}
*/
