package org.example.domain;

public class Academica {
    private int id_educacion;
    private Funcionario funcionario;
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
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
    
    public String toString() {
        return funcionario.getNombres();
    }
}

