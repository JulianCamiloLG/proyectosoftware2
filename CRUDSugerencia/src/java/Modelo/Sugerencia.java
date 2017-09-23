/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SALDARRIAGA VILLADA
 */
public class Sugerencia {
    
    private int identificador;
    private String nombreSugerencia;
    private String descripcionSugerencia;

    public Sugerencia() {
    }

    public Sugerencia(int identificador, String nombreSugerencia, String descripcionSugerencia) {
        this.identificador = identificador;
        this.nombreSugerencia = nombreSugerencia;
        this.descripcionSugerencia = descripcionSugerencia;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    public String getNombreSugerencia() {
        return nombreSugerencia;
    }

    public void setNombreSugerencia(String nombreSugerencia) {
        this.nombreSugerencia = nombreSugerencia;
    }

    public String getDescripcionSugerencia() {
        return descripcionSugerencia;
    }

    public void setDescripcionSugerencia(String descripcionSugerencia) {
        this.descripcionSugerencia = descripcionSugerencia;
    }

}
