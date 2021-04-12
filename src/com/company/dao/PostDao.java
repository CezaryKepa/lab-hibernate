package com.company.dao;


import com.company.model.Post;
import com.company.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class PostDao {
    public void update(Post post) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.update(post);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public void save(Post post) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.save(post);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public void delete(Post post) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        currentSession.delete(post);
        currentSession.getTransaction().commit();
        currentSession.close();
    }
    public Post getById(Long id) {
        Session currentSession = HibernateUtils.getSessionFactory().getCurrentSession();
        currentSession.beginTransaction();
        Post post = currentSession.get(Post.class, id);
        currentSession.getTransaction().commit();
        currentSession.close();
        return post;
    }
    public List<Post> getAll() {
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createNamedQuery("Post.findAll", Post.class)
                    .getResultList();

        }
    }

}
