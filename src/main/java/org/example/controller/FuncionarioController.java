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

    public void crearFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioDao.createFuncionario(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(int id) throws SQLException {
        return funcionarioDao.getFuncionarioById(id);
    }

    public void actualizarFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioDao.updateFuncionario(funcionario);
    }

    public void eliminarFuncionario(int id) throws SQLException {
        funcionarioDao.deleteFuncionario(id);
    }

    public Funcionario getFuncionarioById(int string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFuncionarioById'");
    }
}
