package com.company.dao;


import com.company.model.Roles;
import com.company.utils.HibernateUtils;
import org.hibernate.Session;

public class RoleDao {
    public void update(Roles role) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.update(role);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public void save(Roles role) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.save(role);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public void delete(Roles role) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.delete(role);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public Roles getById(Integer id) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Roles role = currentSession.get(Roles.class, id);
        currentSession.getTransaction().commit();
        currentSession.close();
        return role;
    }


}
