package com.mycompany.todo.controller;

import com.mycompany.todo.model.Tugas;
import com.mycompany.todo.util.hibernateutil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TugasController {

    public boolean tambahTugas(String namaTugas) {
        Transaction tx = null;
        try (Session session = hibernateutil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(new Tugas(namaTugas));
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public List<Tugas> ambilSemuaTugas() {
        try (Session session = hibernateutil.getSessionFactory().openSession()) {
            return session.createQuery("from Tugas order by id", Tugas.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
        public boolean tandaiSelesai(int id) {
        Transaction tx = null;
        try (Session session = hibernateutil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Tugas t = session.get(Tugas.class, id);
            if (t != null) {
                t.setTandaSelesai("Selesai");
                session.update(t);
            }
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}