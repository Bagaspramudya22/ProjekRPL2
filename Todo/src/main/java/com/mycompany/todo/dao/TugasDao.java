package com.mycompany.todo.dao;

import com.mycompany.todo.model.Tugas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TugasDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean hapus(int id) {
        Session session = sessionFactory.getCurrentSession();
        Tugas tugas = session.get(Tugas.class, id);
        if (tugas == null) {
            return false;
        }
        session.delete(tugas);
        return true;
    }
}