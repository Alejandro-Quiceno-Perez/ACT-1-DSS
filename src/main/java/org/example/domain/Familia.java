package org.example.domain;

public class Familia {
    private int id_familiar;
    private Funcionario funcionario;
    private String nombre_familiar;
    private String relacion;
    private int telefono_familiar;

    public int getId_familiar() {
        return id_familiar;
    }

    public void setId_familiar(int id_familiar) {
        this.id_familiar = id_familiar;
    }

    public Funcionario getId() {
        return funcionario;
    }

    public void setId(Funcionario funcionario) {
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

    public int getTelefono_familiar() {
        return telefono_familiar;
    }

    public void setTelefono_familiar(int telefono_familiar) {
        this.telefono_familiar = telefono_familiar;
    }

    @Override
    public String toString (){
        return funcionario.getNombres();
    }
}
