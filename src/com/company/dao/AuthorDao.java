package com.company.dao;


import com.company.model.Author;
import com.company.utils.HibernateUtils;
import org.hibernate.Session;

public class AuthorDao {
    public void update(Author author) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.update(author);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public void save(Author author) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.save(author);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public void delete(Author author) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.delete(author);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public Author getById(Long id) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Author author = currentSession.get(Author.class, id);
        currentSession.getTransaction().commit();
        currentSession.close();
        return author;
    }


}
