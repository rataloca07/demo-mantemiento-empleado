/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.domain;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;
    private String fecha;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(String codigo, String nombre, String fecha, double sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", nombre=" + nombre + ", fecha=" + fecha + ", sueldo=" + sueldo + '}';
    }
    
    
    
}
