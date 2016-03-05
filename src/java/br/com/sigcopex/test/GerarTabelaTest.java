/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.test;

import br.com.sigcopex.util.HibernateUtil;
import org.junit.Test;

/**
 *
 * @author Roberto
 */
public class GerarTabelaTest {
    
        @Test
    public void gerar(){
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
}

