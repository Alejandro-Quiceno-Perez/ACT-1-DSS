package org.example.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.example.domain.Academica;
import org.example.domain.Funcionario;
import org.example.util.ConnectionUtil;

public class AcademicaDao {
    private static final String GET_ACADEMICA = "select * from InformacionAcademica;";

    public List<Academica> getAllAcademicas() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Academica> academicaList = new ArrayList<>();
        List<Funcionario> funcionarioList = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ACADEMICA);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Academica academica = new Academica();
                academica.setId_educacion(resultSet.getInt("id_educacion"));
                academica.setId(new Funcionario(resultSet.getInt("id")));
                academica.setNumeroIdentificacion(resultSet.getInt("numeroIdentificacion"));
                academica.setUniversidad(resultSet.getString("universidad"));
                academica.setNivel_estudio(resultSet.getString("nivel_estudio"));
                academica.setTitulo(resultSet.getString("titulo"));

                academicaList.add(academica);
            }

            return academicaList;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}