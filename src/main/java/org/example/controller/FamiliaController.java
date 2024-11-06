package org.example.controller;

import org.example.data.FamiliaDao;

import java.sql.SQLException;
import java.util.List;
import org.example.domain.Familia;

public class FamiliaController {
    private final FamiliaDao familiaDao;

    public FamiliaController() {
        familiaDao = new FamiliaDao();
    }

    public List<Familia> listarAcademica() throws SQLException {
        return familiaDao.getAllFamilias();
    }
}