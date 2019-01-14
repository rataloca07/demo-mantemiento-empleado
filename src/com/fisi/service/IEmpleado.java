/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.service;

import com.fisi.domain.Empleado;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IEmpleado {
    
    List<Empleado> traerEmpleados();
    void registrarEmpleado(Empleado empleado);
    void modificarEmpleado(Empleado empleado);
    void eliminarEmpleado(Empleado empleado);
    Empleado buscarEmpleado(String cod);
     
}
