/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.factory;

import com.fisi.model.EmpleadoImpMySQL;
import com.fisi.service.IEmpleado;

/**
 *
 * @author Alejandro
 */
public class MySQLFactory extends AbstractFactory{

    @Override
    public IEmpleado getEmpleadoEsp() {
        return new EmpleadoImpMySQL();
    }
    
}
