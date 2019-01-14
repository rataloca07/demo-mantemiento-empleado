/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.model;

import com.fisi.domain.Empleado;
import com.fisi.service.IEmpleado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class EmpleadoImpArchivo implements IEmpleado{
    public static final String PATH = "empleado.dat";
    private List<Empleado> empleados;
    
    public EmpleadoImpArchivo(){
        leerArchivo();
    }
    
    @Override
    public List<Empleado> traerEmpleados() {
       return empleados;
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        if(buscarEmpleado(empleado.getCodigo())==null){
           empleados.add(empleado);
           guardarEnArchivo();
        }       
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        int index = 0;
        for (Empleado x : empleados) {
            if(x.getCodigo().equals(empleado.getCodigo())){
                empleados.set(index, empleado);
                break;
            }
            index++;
        }
        guardarEnArchivo();
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        int index = 0;
        for (Empleado x : empleados) {
            if(x.getCodigo().equals(empleado.getCodigo())){
                empleados.remove(index);
                break;
            }
            index++;
        }
        guardarEnArchivo();
    }

    @Override
    public Empleado buscarEmpleado(String cod) {
        for(Empleado x:empleados){
            if(x.getCodigo().equals(cod)){
                return x;
            }
        }
        return null;
    }
    
    private void leerArchivo(){
        try {
            ObjectInputStream ois = new  ObjectInputStream(new FileInputStream(PATH));
            empleados = (List<Empleado>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            empleados = new ArrayList<>();
            System.out.println(ex);
        } catch (IOException | ClassNotFoundException ex) {
            empleados = new  ArrayList<>();
            System.out.println(ex);
        }
    }
    
    private void guardarEnArchivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(empleados);
            oos.close();
        }catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    
}
