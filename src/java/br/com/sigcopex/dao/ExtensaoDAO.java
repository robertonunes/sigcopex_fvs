/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.dao;

import br.com.sigcopex.domain.Extensao;
import br.com.sigcopex.util.HibernateUtil;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author Roberto
 */
public class ExtensaoDAO {
    public void salvar (Extensao extensao){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.save(extensao);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null){
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
        
    }
    
    
    public List<Extensao> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Extensao> extensaos = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Extensao.listar");
            extensaos = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
             return extensaos;
    }
    
    
    public Extensao buscarPorCodigo (Long codigo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Extensao extensao = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Extensao.buscarPorCodigo");
            consulta.setLong("codigo", codigo);
            
            extensao = (Extensao) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
        
        return extensao;
    }
    
    
    public void excluir (Extensao extensao){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(extensao);
            transacao.commit();
        } catch (RuntimeException ex) {
            if(transacao != null){
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }
    
    public void editar (Extensao extensao){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.update(extensao);
            transacao.commit();
        } catch (RuntimeException ex) {
            if(transacao != null){
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }
}
