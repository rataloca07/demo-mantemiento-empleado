/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.factory;

import com.fisi.service.IEmpleado;

/**
 *
 * @author Alejandro
 */
public abstract class AbstractFactory {
    
    private static final String DATA_MEMORIA = "MEMORIA";
    private static final String DATA_ARCHIVO = "ARCHIVO";
    private static final String DATA_MYSQL = "MYSQL";
    
    private static final String DATA_ACTUAL;
    
    static{
        //DATA_ACTUAL = DATA_ARCHIVO;
        DATA_ACTUAL = DATA_MYSQL;
    }
    
    public static AbstractFactory getFactory(){
        AbstractFactory factory = null;
        switch(DATA_ACTUAL){
            case DATA_MEMORIA:
                factory = new MemoriaFactory();
                break;
            case DATA_ARCHIVO:
                factory = new ArchivoFactory();
                break;
            case DATA_MYSQL:
                factory = new MySQLFactory();
                break;       
        }
        
        return factory;
    }
    
    public abstract IEmpleado getEmpleadoEsp();
    
}
