package org.example.controller;

import org.example.data.AcademicaDao;

import java.sql.SQLException;
import java.util.List;
import org.example.domain.Academica;

public class AcademicaController {
    private AcademicaDao academicaDao;

    public AcademicaController() {
        academicaDao = new AcademicaDao();
    }

    public List<Academica> listarAcademica() throws SQLException {
        return academicaDao.getAllAcademicas();
    }
}