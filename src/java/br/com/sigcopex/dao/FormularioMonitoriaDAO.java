/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.dao;

import br.com.sigcopex.domain.FormularioMonitoria;
import br.com.sigcopex.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Roberto
 */
public class FormularioMonitoriaDAO {
    public void salvar (FormularioMonitoria formularioMonitoria){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.save(formularioMonitoria);
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
    
    
    public List<FormularioMonitoria> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<FormularioMonitoria> formulariosMonitoria = null;
        
        try {
            Query consulta = sessao.getNamedQuery("FormularioMonitoria.listar");
            formulariosMonitoria = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
             return formulariosMonitoria;
    }
    
    
    public FormularioMonitoria buscarPorCodigo (Long codigo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        FormularioMonitoria curso = null;
        
        try {
            Query consulta = sessao.getNamedQuery("FormularioMonitoria.buscarPorCodigo");
            consulta.setLong("codigo", codigo);
            
            curso = (FormularioMonitoria) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
        
        return curso;
    }
    
    
    public void excluir (FormularioMonitoria formularioMonitoria){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(formularioMonitoria);
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
    
    public void editar (FormularioMonitoria formularioMonitoria){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.update(formularioMonitoria);
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
