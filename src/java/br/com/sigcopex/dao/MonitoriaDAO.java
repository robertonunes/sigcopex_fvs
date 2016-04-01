/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.dao;

import br.com.sigcopex.domain.Monitoria;
import br.com.sigcopex.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Roberto
 */
public class MonitoriaDAO {
    public void salvar (Monitoria monitoria){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.save(monitoria);
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
    
    
    public List<Monitoria> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Monitoria> monitorias = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Monitoria.listar");
            monitorias = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
             return monitorias;
    }
    
    
    public Monitoria buscarPorCodigo (Long codigo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Monitoria curso = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Monitoria.buscarPorCodigo");
            consulta.setLong("codigo", codigo);
            
            curso = (Monitoria) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
        
        return curso;
    }
    
    
    public void excluir (Monitoria monitoria){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(monitoria);
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
    
    public void editar (Monitoria monitoria){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.update(monitoria);
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
