/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.dao;


import br.com.sigcopex.domain.Professor;
import br.com.sigcopex.util.HibernateUtil;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author Roberto
 */
public class ProfessorDAO {
    public void salvar (Professor professor){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.save(professor);
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
    
    
    public List<Professor> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Professor> professores = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Professor.listar");
            professores = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
             return professores;
    }
    
    
    public Professor buscarPorCodigo (Long codigo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Professor professor = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Professor.buscarPorCodigo");
            consulta.setLong("codigo", codigo);
            
            professor = (Professor) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
        
        return professor;
    }
    
    
    public void excluir (Professor professor){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(professor);
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
    
    public void editar (Professor professor){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.update(professor);
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

