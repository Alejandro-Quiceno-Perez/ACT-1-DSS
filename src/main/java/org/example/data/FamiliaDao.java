package org.example.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.domain.Familia;
import org.example.domain.Funcionario;
import org.example.util.ConnectionUtil;

public class FamiliaDao {
    private static final String GET_FAMILIA = "select * from GrupoFamiliar inner join Funcionario on funcionario.id = GrupoFamiliar.id_funcionario";

    public List<Familia> getAllFamilias() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Familia> familiaList = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FAMILIA);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Familia familia = new Familia();
                familia.setId_familiar(resultSet.getInt("id_familiar"));
                
                familia.setNombre_familiar(resultSet.getString("nombre_familiar"));
                familia.setRelacion(resultSet.getString("relacion"));
                familia.setTelefono_familiar(resultSet.getString("telefono_familiar"));
                
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setNombres(resultSet.getString("nombres"));
                
                familia.setFuncionario(funcionario);

                familiaList.add(familia);
            }

            return familiaList;
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