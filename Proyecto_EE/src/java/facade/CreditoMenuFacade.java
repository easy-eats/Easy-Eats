/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.CreditoMenu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergi
 */
@Stateless
public class CreditoMenuFacade extends AbstractFacade<CreditoMenu> {

    @PersistenceContext(unitName = "Proyecto_EEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CreditoMenuFacade() {
        super(CreditoMenu.class);
    }
    
}
