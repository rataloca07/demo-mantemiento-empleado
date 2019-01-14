/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.model;

import com.fisi.domain.Empleado;
import com.fisi.service.IEmpleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class EmpleadoImpMemoria implements IEmpleado {

    List<Empleado> lista;
    
    public EmpleadoImpMemoria(){
        lista = new ArrayList();
    }
    
    @Override
    public List<Empleado> traerEmpleados() {
        return lista;
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        if(buscarEmpleado(empleado.getCodigo())==null){
            lista.add(empleado);
        }
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        int index = 0;
        for (Empleado x : lista) {
            if(x.getCodigo().equals(empleado.getCodigo())){
                lista.set(index, empleado);
                break;
            }
            index++;
        }
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        int index = 0;
        for (Empleado x : lista) {
            if(x.getCodigo().equals(empleado.getCodigo())){
                lista.remove(index);
                break;
            }
            index++;
        }
    }

    @Override
    public Empleado buscarEmpleado(String cod) {
        for(Empleado x:lista){
            if(x.getCodigo().equals(cod)){
                return x;
            }
        }
        return null;
    }
    
}
