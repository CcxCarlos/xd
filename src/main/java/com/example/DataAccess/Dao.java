package com.example.DataAccess;

import com.example.Model.Clients;
import com.example.Model.Comptes;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public abstract class Dao {
    protected static Session session;
    protected static boolean xd = false;

    static {
        if (!xd) newSession();
        xd = true;
    }

    public Query executeQuery(String query, Class<?> clase) {
        return session.createQuery(query, clase);
    }

    public Query executeQuery(String query, String parameter, String parameterValue, Class<?> clase) {
        Query q = session.createQuery(query, clase);
        q.setParameter(parameter, parameterValue);
        return q;
    }
    public List<Clients> getValues(Query q) {
        return q.getResultList();
    }
    protected void persistObject(Object o) {
        session.persist(o);
        session.getTransaction().commit();
    }
    protected void deleteObject(Object o){
        session.remove(o);
        session.getTransaction().commit();
    }
    public void addObject(Object o) {
        persistObject(o);
    }
    public void removeObject(Object o) {
        deleteObject(o);
    }
    public Boolean objectExists(Object o){
        if (o instanceof Clients) return !getValues(executeQuery(Querys.CLIENTS_BY_ID_FISCAL, Querys.getParameter(Querys.CLIENTS_BY_ID_FISCAL), String.valueOf(((Clients) o).getIdFiscal()), Clients.class)).isEmpty();
        else return !getValues(executeQuery(Querys.CUENTA, Querys.getParameter(Querys.CUENTA), ((Comptes)o).getnCuenta(), Comptes.class)).isEmpty();
    }
    protected void refreshSession(){
        session.refresh(Clients.class);
    }
    public void closeSession(){
        session.close();
    }

    public static void newSession(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
    }
}
