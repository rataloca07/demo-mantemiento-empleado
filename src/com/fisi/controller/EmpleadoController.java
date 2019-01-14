/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.controller;

import com.fisi.domain.Empleado;
import com.fisi.factory.AbstractFactory;
import com.fisi.service.IEmpleado;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class EmpleadoController {
    
    private final IEmpleado empleado = AbstractFactory.getFactory().getEmpleadoEsp();
    
    public List<Empleado> traerEmpleados(){
       return empleado.traerEmpleados();
    }
    
    public void registrarEmpleado(Empleado e){
       empleado.registrarEmpleado(e);
    }
    
    public void modificarEmpleado(Empleado e){
        empleado.modificarEmpleado(e);
    }
    
    public void eliminarEmpleado(Empleado e){
        empleado.eliminarEmpleado(e);
    }
    
    public Empleado buscarEmpleado(String cod){
        return empleado.buscarEmpleado(cod);
    }
}