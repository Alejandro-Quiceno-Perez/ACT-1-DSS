// package org.example;

// // import java.sql.Date;
// // import java.util.List;
// // import java.util.Scanner;

// import javax.swing.BorderFactory;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTextField;
// import javax.swing.SwingUtilities;

// // import org.example.controller.AcademicaController;
// // import org.example.controller.FuncionarioController;
// // import org.example.domain.Academica;
// // import org.example.domain.Funcionario;

// import javax.swing.*;
// import java.awt.*;

// public class ExceptionTest extends JFrame {
//        // public static void getAllFuncionarios(FuncionarioController funcionarioController) {
//        //        try {
//        //               List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
//        //               if (funcionarios.isEmpty()) {
//        //                      System.out.println("No hay funcionarios registrados");
//        //               } else {
//        //                      funcionarios.forEach(funcionario -> {
//        //                             System.out.println("id: " + funcionario.getId());
//        //                             System.out.println("tipo de identificacion: " + funcionario.getTipoIdentificacion());
//        //                             System.out.println("Numero: : " + funcionario.getNumeroIdentificacion());
//        //                             System.out.println("Nombres: " + funcionario.getNombres());
//        //                             System.out.println("Apellidos: " + funcionario.getApellidos());
//        //                             System.out.println("Estado Civil: " + funcionario.getEstadoCivil());
//        //                             System.out.println("Sexo: " + funcionario.getSexo());
//        //                             System.out.println("Direccion: " + funcionario.getDireccion());
//        //                             System.out.println("Telefono: " + funcionario.getTelefono());
//        //                             System.out.println("Fecha Nacimiento: " + funcionario.getFechaNacimiento());
//        //                             System.out.println("-------------------------------------------------");
//        //                             System.out.println("-------------------------------------------------");
//        //                             System.out.println("-------------------------------------------------");
//        //                      });
//        //               }
//        //        } catch (Exception e) {
//        //               e.printStackTrace();
//        //        }
//        // }

//        // public static void getAllAcademicas(AcademicaController academicaController) {
//        //        try {
//        //               List<Academica> academicas = academicaController.listarAcademica();
//        //               if (academicas.isEmpty()) {
//        //                      System.out.println("No hay academicas registrados");
//        //               } else {
//        //                      academicas.forEach(academica -> {
//        //                             System.out.println("id: " + academica.getId_educacion());
//        //                             System.out.println("id: " + academica.getId());
//        //                             System.out.println("Numero: : " + academica.getNumeroIdentificacion());
//        //                             System.out.println("Universidad: " + academica.getUniversidad());
//        //                             System.out.println("Nivel de Estudio: " + academica.getNivel_estudio());
//        //                             System.out.println("Titulo: " + academica.getTitulo());
//        //                             System.out.println("-------------------------------------------------");
//        //                             System.out.println("-------------------------------------------------");
//        //                             System.out.println("-------------------------------------------------");
//        //                      });
//        //               }
//        //        } catch (Exception e) {
//        //               e.printStackTrace();
//        //        }
//        // }

//        // public static void crearFuncionario(FuncionarioController funcionarioController) {
//        //        try {
//        //               Scanner sc = new Scanner(System.in);
//        //               System.out.println("Ingrese el tipo de identificacion: ");
//        //               String tipoIdentificacion = sc.nextLine();
//        //               System.out.println("-------------------------------------------------");
//        //               System.out.println("Ingrese el numero de identificacion: ");
//        //               int numeroIdentificacion = sc.nextInt();
//        //               System.out.println("-------------------------------------------------");
//        //               sc.nextLine();
//        //               System.out.println("Ingrese los nombres: ");
//        //               String nombres = sc.nextLine();
//        //               System.out.println("-------------------------------------------------");
//        //               System.out.println("Ingrese los apellidos: ");
//        //               String apellidos = sc.nextLine();
//        //               System.out.println("-------------------------------------------------");
//        //               System.out.println("Ingrese el estado civil: ");
//        //               String estadoCivil = sc.nextLine();
//        //               System.out.println("-------------------------------------------------");
//        //               System.out.println("Ingrese el sexo: ");
//        //               String sexo = sc.nextLine();
//        //               System.out.println("-------------------------------------------------");
//        //               System.out.println("Ingrese la direccion: ");
//        //               String direccion = sc.nextLine();
//        //               System.out.println("-------------------------------------------------");
//        //               System.out.println("Ingrese el telefono: ");
//        //               String telefono = sc.nextLine();
//        //               System.out.println("-------------------------------------------------");
//        //               System.out.println("Ingrese la fecha de nacimiento: ");
//        //               Date fechaNacimiento = Date.valueOf(sc.nextLine());
//        //               System.out.println("-------------------------------------------------");

//        //               Funcionario funcionario = new Funcionario();
//        //               funcionario.setTipoIdentificacion(tipoIdentificacion);
//        //               funcionario.setNumeroIdentificacion(numeroIdentificacion);
//        //               funcionario.setNombres(nombres);
//        //               funcionario.setApellidos(apellidos);
//        //               funcionario.setEstadoCivil(estadoCivil);
//        //               funcionario.setSexo(sexo);
//        //               funcionario.setDireccion(direccion);
//        //               funcionario.setTelefono(telefono);
//        //               funcionario.setFechaNacimiento(fechaNacimiento);

//        //               funcionarioController.crearFuncionario(funcionario);
//        //               getAllFuncionarios(funcionarioController);

//        //        } catch (Exception e) {
//        //               e.printStackTrace();
//        //        }
//        //        System.out.println("Creando funcionario");
//        // }

//        // public static void main(String[] args) {


//        //        System.out.println("Hello, World!");
//        //        FuncionarioController funcionarioController = new FuncionarioController();
//        //        getAllFuncionarios(funcionarioController);
//        //        // crearFuncionario(funcionarioController);
//        //        System.out.println("-------------------------------------------------");
//        //        // AcademicaController academicaController = new AcademicaController();
//        //        // getAllAcademicas(academicaController);
//        // }

       
//     private JLabel jLabel1;
//     private JPanel jPFuncionario;
//     private JTextField txtTipoIdentificacion;
//     private JTextField txtNumeroIdentificacion;
//     private JTextField txtNombres;
//     private JTextField txtApellidos;
//     private JTextField txtEstadoCivil;
//     private JTextField txtSexo;
//     private JTextField txtDireccion;
//     private JTextField txtTelefono;
//     private JTextField txtFechaNacimiento;
//     private JButton btnSave;

//     public ExceptionTest() {
//         initComponents();
//     }

//     private void initComponents() {
//         jLabel1 = new JLabel("GESTIÓN DE FUNCIONARIOS");
//         jPFuncionario = new JPanel();
//         txtTipoIdentificacion = new JTextField(15);
//         txtNumeroIdentificacion = new JTextField(15);
//         txtNombres = new JTextField(15);
//         txtApellidos = new JTextField(15);
//         txtEstadoCivil = new JTextField(15);
//         txtSexo = new JTextField(15);
//         txtDireccion = new JTextField(15);
//         txtTelefono = new JTextField(15);
//         txtFechaNacimiento = new JTextField(15);
//         btnSave = new JButton("GUARDAR");

//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new FlowLayout());

//         add(jLabel1);
//         jPFuncionario.setBorder(BorderFactory.createTitledBorder("Digite los siguientes campos"));
//         jPFuncionario.setLayout(new GridLayout(10, 2, 5, 5));
//         jPFuncionario.add(new JLabel("TIPO IDENTIFICACION"));
//         jPFuncionario.add(txtTipoIdentificacion);
//         jPFuncionario.add(new JLabel("NUMERO IDENTIFICACION"));
//         jPFuncionario.add(txtNumeroIdentificacion);
//         jPFuncionario.add(new JLabel("NOMBRES"));
//         jPFuncionario.add(txtNombres);
//         jPFuncionario.add(new JLabel("APELLIDOS"));
//         jPFuncionario.add(txtApellidos);
//         jPFuncionario.add(new JLabel("ESTADO CIVIL"));
//         jPFuncionario.add(txtEstadoCivil);
//         jPFuncionario.add(new JLabel("SEXO"));
//         jPFuncionario.add(txtSexo);
//         jPFuncionario.add(new JLabel("DIRECCION"));
//         jPFuncionario.add(txtDireccion);
//         jPFuncionario.add(new JLabel("TELEFONO"));
//         jPFuncionario.add(txtTelefono);
//         jPFuncionario.add(new JLabel("FECHA NACIMIENTO"));
//         jPFuncionario.add(txtFechaNacimiento);
//         jPFuncionario.add(btnSave);

//         add(jPFuncionario);

//         pack();
//         setLocationRelativeTo(null); // Centrar la ventana
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new ExceptionTest().setVisible(true);
//         });
//     }

// }