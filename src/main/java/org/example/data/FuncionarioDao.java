package org.example.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.domain.Funcionario;

public class FuncionarioDao {
    private static final String GET_FUNCIONARIOS = "select * from funcionario";
    private static final String CREATE_FUNCIONARIO = "INSERT INTO Funcionario (tipoIdentificacion, numeroIdentificacion, nombres, apellidos, estadoCivil, sexo, direccion, telefono, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionario WHERE id = ?";
    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionario SET tipoIdentificacion = ?, SET " +
            "numeroIdentificacion = ?, SET nombres = ?, SET apellidos = ?, SET estadoCivil = ?, SET sexo = ?, SET " +
            "direccion = ?, SET telefono = ?, SET fechaNacimiento = ? WHERE id = ?";
    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionario WHERE id = ?";

    public List<Funcionario> getAllFuncionarios() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
        } finally {
            // TODO: handle exception
        }
    }
}
