package org.example.domain;

public class Academica {
    private int id_educacion;
    private Funcionario id;
    private int numeroIdentificacion;
    private String universidad;
    private String nivel_estudio;
    private String titulo;
    
    // Getters and setters
    public int getId_educacion() {
        return id_educacion;
    }
    public void setId_educacion(int id_educacion) {
        this.id_educacion = id_educacion;
    }
    public Funcionario getId() {
        return id;
    }
    public void setId(Funcionario id) {
        this.id = id;
    }
    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
    public String getUniversidad() {
        return universidad;
    }
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    public String getNivel_estudio() {
        return nivel_estudio;
    }
    public void setNivel_estudio(String nivel_estudio) {
        this.nivel_estudio = nivel_estudio;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
<<<<<<< HEAD

    @Override
   public String toString(){
    return universidad + titulo + nivel_estudio;
   }

    public void setId_funcionario(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
=======
}
>>>>>>> 80838b4fe441fcf83a2b937c015882bd0a7801ef
