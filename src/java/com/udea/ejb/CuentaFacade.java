/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Cuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author giovanny
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> implements CuentaFacadeLocal {

    @PersistenceContext(unitName = "Lab1ArqPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }

    @Override
    public boolean checkLogin(String u, String p) {
        return false;
    }
    
}
