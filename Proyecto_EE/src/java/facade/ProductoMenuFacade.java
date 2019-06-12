/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.ProductoMenu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergi
 */
@Stateless
public class ProductoMenuFacade extends AbstractFacade<ProductoMenu> {

    @PersistenceContext(unitName = "Proyecto_EEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoMenuFacade() {
        super(ProductoMenu.class);
    }
    
}
