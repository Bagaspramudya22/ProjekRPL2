package com.mycompany.todo.service;

import com.mycompany.todo.dao.TugasDao;
import org.springframework.transaction.annotation.Transactional;

public class TugasService {

    private TugasDao tugasDao;

    public void setTugasDao(TugasDao tugasDao) {
        this.tugasDao = tugasDao;
    }

    @Transactional
    public boolean hapusTugas(int id) {
        return tugasDao.hapus(id);
    }
}