package org.example;

import org.example.controller.FuncionarioController;
import org.example.controller.AcademicaController;
import org.example.domain.Funcionario;
import org.example.domain.Academica;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DateFormat;

public class Main extends JFrame {

    private final FuncionarioController funcionarioController;
    private final AcademicaController academicaController;
    private final static String[] FUNCIONARIO_COLUMNS = {"ID", "TIPO IDENTIFICACION", "NUMERO IDENTIFICACION", "NOMBRES", "APELLIDOS", "ESTADO CIVIL", "SEXO", "DIRECCION", "TELEFONO", "FECHA NACIMIENTO"};
    private final static String[] ACADEMICA_COLUMNS = {"ID", "NUMERO IDENTIFICACION", "UNIVERSIDAD", "NIVEL ESTUDIO", "TITULO"};
    private final static String SELECCIONE = "--SELECCIONE--";

    private JLabel jLabel1;
    private JPanel jPFuncionario;
    private JTextField txtTipoIdentificacion;
    private JTextField txtNumeroIdentificacion;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtEstadoCivil;
    private JTextField txtSexo;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JFormattedTextField txtFechaNacimiento;
    private JButton btnSave;
    private JTable tblFuncionarios;
    private JComboBox<Funcionario> cbxFuncionarios;
    private JTextField txtFuncionarioId;
    private JTextField txtTipoIdentificacionEdit;
    private JTextField txtNumeroIdentificacionEdit;
    private JTextField txtNombresEdit;
    private JTextField txtApellidosEdit;
    private JTextField txtEstadoCivilEdit;
    private JTextField txtSexoEdit;
    private JTextField txtDireccionEdit;
    private JTextField txtTelefonoEdit;
    private JFormattedTextField txtFechaNacimientoEdit;
    private JButton btnUpdate;
    private JButton btnDelete;

    public Main() {
        funcionarioController = new FuncionarioController();
        academicaController = new AcademicaController();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton btnFuncionarios = new JButton("Ver Funcionarios");
        JButton btnAcademica = new JButton("Ver Información Académica");
        JButton btnSalir = new JButton("Salir");

        btnFuncionarios.addActionListener(e -> mostrarFuncionarios());
        btnAcademica.addActionListener(e -> mostrarAcademica());
        btnSalir.addActionListener(e -> System.exit(0));

        mainPanel.add(btnFuncionarios);
        mainPanel.add(btnAcademica);
        mainPanel.add(btnSalir);

        add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Centrar la ventana
    }

    private void mostrarFuncionarios() {
        JFrame frame = new JFrame("Gestión de Funcionarios");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        jLabel1 = new JLabel("GESTIÓN DE FUNCIONARIOS");
        jPFuncionario = new JPanel();
        txtTipoIdentificacion = new JTextField(15);
        txtNumeroIdentificacion = new JTextField(15);
        txtNombres = new JTextField(15);
        txtApellidos = new JTextField(15);
        txtEstadoCivil = new JTextField(15);
        txtSexo = new JTextField(15);
        txtDireccion = new JTextField(15);
        txtTelefono = new JTextField(15);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        txtFechaNacimiento = new JFormattedTextField(dateFormat);
        txtFechaNacimiento.setColumns(15);

        btnSave = new JButton("GUARDAR");
        tblFuncionarios = new JTable();
        cbxFuncionarios = new JComboBox<>();
        txtFuncionarioId = new JTextField(15);
        txtTipoIdentificacionEdit = new JTextField(15);
        txtNumeroIdentificacionEdit = new JTextField(15);
        txtNombresEdit = new JTextField(15);
        txtApellidosEdit = new JTextField(15);
        txtEstadoCivilEdit = new JTextField(15);
        txtSexoEdit = new JTextField(15);
        txtDireccionEdit = new JTextField(15);
        txtTelefonoEdit = new JTextField(15);
        txtFechaNacimientoEdit = new JFormattedTextField(dateFormat);
        txtFechaNacimientoEdit.setColumns(15);

        btnUpdate = new JButton("ACTUALIZAR");
        btnDelete = new JButton("ELIMINAR");

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(jLabel1);
        frame.add(topPanel, BorderLayout.NORTH);

        jPFuncionario.setBorder(BorderFactory.createTitledBorder("Digite los siguientes campos"));
        jPFuncionario.setLayout(new GridLayout(11, 2, 5, 5));
        jPFuncionario.add(new JLabel("TIPO IDENTIFICACION"));
        jPFuncionario.add(txtTipoIdentificacion);
        jPFuncionario.add(new JLabel("NUMERO IDENTIFICACION"));
        jPFuncionario.add(txtNumeroIdentificacion);
        jPFuncionario.add(new JLabel("NOMBRES"));
        jPFuncionario.add(txtNombres);
        jPFuncionario.add(new JLabel("APELLIDOS"));
        jPFuncionario.add(txtApellidos);
        jPFuncionario.add(new JLabel("ESTADO CIVIL"));
        jPFuncionario.add(txtEstadoCivil);
        jPFuncionario.add(new JLabel("SEXO"));
        jPFuncionario.add(txtSexo);
        jPFuncionario.add(new JLabel("DIRECCION"));
        jPFuncionario.add(txtDireccion);
        jPFuncionario.add(new JLabel("TELEFONO"));
        jPFuncionario.add(txtTelefono);
        jPFuncionario.add(new JLabel("FECHA NACIMIENTO"));
        jPFuncionario.add(txtFechaNacimiento);
        jPFuncionario.add(btnSave);
        frame.add(jPFuncionario, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Lista de Funcionarios"));
        bottomPanel.add(new JScrollPane(tblFuncionarios), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        JPanel editPanel = new JPanel(new GridLayout(11, 2, 5, 5));
        editPanel.setBorder(BorderFactory.createTitledBorder("Editar Funcionario"));
        editPanel.add(new JLabel("ID"));
        editPanel.add(txtFuncionarioId);
        editPanel.add(new JLabel("TIPO IDENTIFICACION"));
        editPanel.add(txtTipoIdentificacionEdit);
        editPanel.add(new JLabel("NUMERO IDENTIFICACION"));
        editPanel.add(txtNumeroIdentificacionEdit);
        editPanel.add(new JLabel("NOMBRES"));
        editPanel.add(txtNombresEdit);
        editPanel.add(new JLabel("APELLIDOS"));
        editPanel.add(txtApellidosEdit);
        editPanel.add(new JLabel("ESTADO CIVIL"));
        editPanel.add(txtEstadoCivilEdit);
        editPanel.add(new JLabel("SEXO"));
        editPanel.add(txtSexoEdit);
        editPanel.add(new JLabel("DIRECCION"));
        editPanel.add(txtDireccionEdit);
        editPanel.add(new JLabel("TELEFONO"));
        editPanel.add(txtTelefonoEdit);
        editPanel.add(new JLabel("FECHA NACIMIENTO"));
        editPanel.add(txtFechaNacimientoEdit);
        editPanel.add(btnUpdate);
        editPanel.add(btnDelete);
        frame.add(editPanel, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);

        listarFuncionarios();
        addListener();
    }

    private void mostrarAcademica() {
        JFrame frame = new JFrame("Información Académica");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel jLabel2 = new JLabel("INFORMACIÓN ACADÉMICA");
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(jLabel2);
        frame.add(topPanel, BorderLayout.NORTH);

        JTable tblAcademica = new JTable();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : ACADEMICA_COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }
        tblAcademica.setModel(defaultTableModel);

        try {
            List<Academica> academicas = academicaController.listarAcademica();
            if (academicas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay información académica registrada");
            } else {
                academicas.forEach(academica -> {
                    Object[] row = new Object[5];
                    row[0] = academica.getId_educacion();
                    row[1] = academica.getFuncionario().getNombres();
                    row[2] = academica.getUniversidad();
                    row[3] = academica.getNivel_estudio();
                    row[4] = academica.getTitulo();
                    defaultTableModel.addRow(row);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Lista de Información Académica"));
        bottomPanel.add(new JScrollPane(tblAcademica), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar la ventana
        frame.setVisible(true);
    }

    private void listarFuncionarios() {
        cbxFuncionarios.removeAllItems();
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNombres(SELECCIONE);
        cbxFuncionarios.addItem(funcionario1);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : FUNCIONARIO_COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblFuncionarios.setModel(defaultTableModel);

        try {
            List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
            if (funcionarios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay funcionarios registrados");
            } else {
                funcionarios.forEach(funcionario -> {
                    Object[] row = new Object[10];
                    row[0] = funcionario.getId();
                    row[1] = funcionario.getTipoIdentificacion();
                    row[2] = funcionario.getNumeroIdentificacion();
                    row[3] = funcionario.getNombres();
                    row[4] = funcionario.getApellidos();
                    row[5] = funcionario.getEstadoCivil();
                    row[6] = funcionario.getSexo();
                    row[7] = funcionario.getDireccion();
                    row[8] = funcionario.getTelefono();
                    row[9] = new SimpleDateFormat("yyyy-MM-dd").format(funcionario.getFechaNacimiento());
                    defaultTableModel.addRow(row);
                    cbxFuncionarios.addItem(funcionario);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addListener() {
        cbxFuncionarios.addItemListener(event -> {
            Funcionario funcionario = (Funcionario) event.getItem();
            if (funcionario.getId() != 0) {
                txtFuncionarioId.setText(String.valueOf(funcionario.getId()));
                txtTipoIdentificacionEdit.setText(funcionario.getTipoIdentificacion());
                txtNumeroIdentificacionEdit.setText(String.valueOf(funcionario.getNumeroIdentificacion()));
                txtNombresEdit.setText(funcionario.getNombres());
                txtApellidosEdit.setText(funcionario.getApellidos());
                txtEstadoCivilEdit.setText(funcionario.getEstadoCivil());
                txtSexoEdit.setText(funcionario.getSexo());
                txtDireccionEdit.setText(funcionario.getDireccion());
                txtTelefonoEdit.setText(funcionario.getTelefono());
                txtFechaNacimientoEdit.setText(new SimpleDateFormat("yyyy-MM-dd").format(funcionario.getFechaNacimiento()));
            } else {
                txtFuncionarioId.setText("");
                txtTipoIdentificacionEdit.setText("");
                txtNumeroIdentificacionEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
            }
        });

        btnSave.addActionListener(evt -> btnSaveActionPerformed(evt));
        btnUpdate.addActionListener(evt -> btnUpdateActionPerformed(evt));
        btnDelete.addActionListener(evt -> btnDeleteActionPerformed(evt));
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtTipoIdentificacion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el tipo de identificación");
            txtTipoIdentificacion.requestFocus();
            return;
        }

        if (txtNumeroIdentificacion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el número de identificación");
            txtNumeroIdentificacion.requestFocus();
            return;
        }

        if (txtNombres.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite los nombres");
            txtNombres.requestFocus();
            return;
        }

        if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite los apellidos");
            txtApellidos.requestFocus();
            return;
        }

        if (txtEstadoCivil.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el estado civil");
            txtEstadoCivil.requestFocus();
            return;
        }

        if (txtSexo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el sexo");
            txtSexo.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la dirección");
            txtDireccion.requestFocus();
            return;
        }

        if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el teléfono");
            txtTelefono.requestFocus();
            return;
        }

        if (txtFechaNacimiento.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la fecha de nacimiento");
            txtFechaNacimiento.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setTipoIdentificacion(txtTipoIdentificacion.getText().trim());
        funcionario.setNumeroIdentificacion(Integer.parseInt(txtNumeroIdentificacion.getText().trim()));
        funcionario.setNombres(txtNombres.getText().trim());
        funcionario.setApellidos(txtApellidos.getText().trim());
        funcionario.setEstadoCivil(txtEstadoCivil.getText().trim());
        funcionario.setSexo(txtSexo.getText().trim());
        funcionario.setDireccion(txtDireccion.getText().trim());
        funcionario.setTelefono(txtTelefono.getText().trim());
        try {
            funcionario.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaNacimiento.getText().trim()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd");
            txtFechaNacimiento.requestFocus();
            return;
        }

        try {
            funcionarioController.crearFuncionario(funcionario);
            txtTipoIdentificacion.setText("");
            txtNumeroIdentificacion.setText("");
            txtNombres.setText("");
            txtApellidos.setText("");
            txtEstadoCivil.setText("");
            txtSexo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtFechaNacimiento.setText("");
            listarFuncionarios();
            JOptionPane.showMessageDialog(null, "Funcionario creado con éxito");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No fue posible crear el funcionario");
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtFuncionarioId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtFuncionarioId.requestFocus();
            return;
        }

        if (txtTipoIdentificacionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el tipo de identificación");
            txtTipoIdentificacionEdit.requestFocus();
            return;
        }

        if (txtNumeroIdentificacionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el número de identificación");
            txtNumeroIdentificacionEdit.requestFocus();
            return;
        }

        if (txtNombresEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite los nombres");
            txtNombresEdit.requestFocus();
            return;
        }

        if (txtApellidosEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite los apellidos");
            txtApellidosEdit.requestFocus();
            return;
        }

        if (txtEstadoCivilEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el estado civil");
            txtEstadoCivilEdit.requestFocus();
            return;
        }

        if (txtSexoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el sexo");
            txtSexoEdit.requestFocus();
            return;
        }

        if (txtDireccionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la dirección");
            txtDireccionEdit.requestFocus();
            return;
        }

        if (txtTelefonoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el teléfono");
            txtTelefonoEdit.requestFocus();
            return;
        }

        if (txtFechaNacimientoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la fecha de nacimiento");
            txtFechaNacimientoEdit.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setId(Integer.parseInt(txtFuncionarioId.getText().trim()));
        funcionario.setTipoIdentificacion(txtTipoIdentificacionEdit.getText().trim());
        funcionario.setNumeroIdentificacion(Integer.parseInt(txtNumeroIdentificacionEdit.getText().trim()));
        funcionario.setNombres(txtNombresEdit.getText().trim());
        funcionario.setApellidos(txtApellidosEdit.getText().trim());
        funcionario.setEstadoCivil(txtEstadoCivilEdit.getText().trim());
        funcionario.setSexo(txtSexoEdit.getText().trim());
        funcionario.setDireccion(txtDireccionEdit.getText().trim());
        funcionario.setTelefono(txtTelefonoEdit.getText().trim());
        try {
            funcionario.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaNacimientoEdit.getText().trim()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use yyyy-MM-dd");
            txtFechaNacimientoEdit.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el funcionario?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {
            try {
                funcionarioController.actualizarFuncionario(funcionario);
                txtTipoIdentificacionEdit.setText("");
                txtNumeroIdentificacionEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                listarFuncionarios();
                JOptionPane.showMessageDialog(null, "Funcionario actualizado con éxito");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fue posible actualizar el funcionario");
            }
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if (txtFuncionarioId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario de la lista");
            txtFuncionarioId.requestFocus();
            return;
        }

        int opt = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el funcionario?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {
            try {
                funcionarioController.eliminarFuncionario(Integer.parseInt(txtFuncionarioId.getText()));
                txtTipoIdentificacionEdit.setText("");
                txtNumeroIdentificacionEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                listarFuncionarios();
                JOptionPane.showMessageDialog(null, "Funcionario eliminado con éxito");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fue posible eliminar el funcionario");
            }
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}