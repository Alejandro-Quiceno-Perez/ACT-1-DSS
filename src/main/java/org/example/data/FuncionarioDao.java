package org.example.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.domain.Funcionario;
import org.example.util.ConnectionUtil;

public class FuncionarioDao {
    private static final String GET_FUNCIONARIOS = "select * from funcionario";
    private static final String CREATE_FUNCIONARIO = "INSERT INTO Funcionario (tipoIdentificacion, numeroIdentificacion, nombres, apellidos, estadoCivil, sexo, direccion, telefono, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionario WHERE id = ?";
    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionario set tipoIdentificacion = ?,  nombres = ?,  apellidos = ?,  estadoCivil = ?,  sexo = ?,  direccion = ?,  telefono = ?,  fechaNacimiento = ? WHERE id = ?";
    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionario WHERE id = ?";

    public List<Funcionario> getAllFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipoIdentificacion"));
                funcionario.setNumeroIdentificacion(resultSet.getInt("numeroIdentificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadoCivil(resultSet.getString("estadoCivil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
                funcionarios.add(funcionario);
            }
            return funcionarios;

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            
        }
    }

    public void createFuncionario(Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setInt(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstadoCivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setDate(9, new java.sql.Date(funcionario.getFechaNacimiento().getTime()));
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionario getFuncionarioById(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = new Funcionario();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipoIdentificacion"));
                funcionario.setNumeroIdentificacion(resultSet.getInt("numeroIdentificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadoCivil(resultSet.getString("estadoCivil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
            }
            return funcionario;

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void updateFuncionario(Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setString(2, funcionario.getNombres());
            preparedStatement.setString(3, funcionario.getApellidos());
            preparedStatement.setString(4, funcionario.getEstadoCivil());
            preparedStatement.setString(5, funcionario.getSexo());
            preparedStatement.setString(6, funcionario.getDireccion());
            preparedStatement.setString(7, funcionario.getTelefono());
            preparedStatement.setDate(8, new java.sql.Date(funcionario.getFechaNacimiento().getTime()));
            preparedStatement.setInt(9, funcionario.getId());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
