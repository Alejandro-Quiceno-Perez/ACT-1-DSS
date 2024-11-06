package org.example.domain;

public class Familia {
    private int id_familiar;
    private Funcionario funcionario;
    private String nombre_familiar;
    private String relacion;
    private String telefono_familiar;

    public int getId_familiar() {
        return id_familiar;
    }

    public void setId_familiar(int id_familiar) {
        this.id_familiar = id_familiar;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNombre_familiar() {
        return nombre_familiar;
    }

    public void setNombre_familiar(String nombre_familiar) {
        this.nombre_familiar = nombre_familiar;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    

    public String toString (){
        return funcionario.getNombres();
    }

    public String getTelefono_familiar() {
        return telefono_familiar;
    }

    public void setTelefono_familiar(String telefono_familiar) {
        this.telefono_familiar = telefono_familiar;
    }

}
