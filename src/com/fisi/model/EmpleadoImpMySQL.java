/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.model;

import com.fisi.conexion.Conexion;
import com.fisi.domain.Empleado;
import com.fisi.service.IEmpleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class EmpleadoImpMySQL implements IEmpleado {

    @Override
    public List<Empleado> traerEmpleados() {
       List<Empleado> empleados = null;
      try {
          empleados = new ArrayList<Empleado>();
            PreparedStatement cl = Conexion.getConnexion().prepareStatement("SELECT * FROM empleado");
            ResultSet rs = cl.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado(rs.getString("codigo"),rs.getString("nombre"), rs.getString("fecha"), rs.getDouble("sueldo"));
                empleados.add(empleado);

               
            }
            cl.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontró empleados en la bd", "Buscar Empleados", JOptionPane.WARNING_MESSAGE);
        }
        return empleados;
    }

    @Override
    public void registrarEmpleado(Empleado empleado) {
        try {

            PreparedStatement cl = Conexion.getConnexion().prepareStatement("INSERT INTO empleado (codigo , nombre, fecha, sueldo) VALUES (?, ?, ?, ?) ");
            cl.setString(1, empleado.getCodigo());
            cl.setString(2, empleado.getNombre());
            cl.setString(3, empleado.getFecha());
            cl.setDouble(4, empleado.getSueldo());
            cl.executeUpdate();
            cl.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar empleado", "Registrar Empleado", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        try {

            PreparedStatement cl = Conexion.getConnexion().prepareStatement("UPDATE empleado set codigo = ? , nombre = ?, fecha = ?, sueldo = ? WHERE codigo = ?");
            cl.setString(1, empleado.getCodigo());
            cl.setString(2, empleado.getNombre());
            cl.setString(3, empleado.getFecha());
            cl.setDouble(4, empleado.getSueldo());
            cl.setString(5, empleado.getCodigo());
            cl.executeUpdate();
           
             cl.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar empleado", "Modificar Empleado", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        try {

            PreparedStatement cl = Conexion.getConnexion().prepareStatement("DELETE FROM empleado WHERE codigo = ?");
            cl.setString(1, empleado.getCodigo());
            cl.executeUpdate();
             cl.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar empleado", "Eliminar Empleado", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public Empleado buscarEmpleado(String cod) {
        Empleado empleado=null;

        try {
            
            PreparedStatement cl = Conexion.getConnexion().prepareStatement("SELECT * FROM empleado WHERE codigo = ?");
            cl.setString(1, cod);
            ResultSet rs = cl.executeQuery();
            while (rs.next()) {
                empleado = new Empleado(rs.getString("codigo"),rs.getString("nombre"), rs.getString("fecha"), rs.getDouble("sueldo"));

               
            }
            cl.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Empleado no registrado", "Buscar Empleado", JOptionPane.WARNING_MESSAGE);
        }
        return empleado;
    }

}
