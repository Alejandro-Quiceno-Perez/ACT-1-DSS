package org.example.controller;

import org.example.data.FuncionarioDao;
import org.example.domain.Funcionario;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    private FuncionarioDao funcionarioDao;
    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        return funcionarioDao.getAllFuncionarios();
    }


}
