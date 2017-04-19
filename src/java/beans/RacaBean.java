/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.RacaDao;
import entities.Raca;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vinicius Faria
 */
@ManagedBean
@RequestScoped
public class RacaBean {

    /**
     * Creates a new instance of RacaBean
     */
    public RacaBean() {
    }
    
    public List<Raca> listaRacas() {
        RacaDao racaDao = new RacaDao();
        return racaDao.listar();
    }
    
}
