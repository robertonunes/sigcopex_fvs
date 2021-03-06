/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.dao;


import br.com.sigcopex.domain.Disciplina;
import br.com.sigcopex.util.HibernateUtil;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author Roberto
 */
public class DisciplinaDAO {
    public void salvar (Disciplina disciplina){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.save(disciplina);
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
    
    
    public List<Disciplina> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Disciplina> cursos = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Disciplina.listar");
            cursos = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
             return cursos;
    }
    
    
    public Disciplina buscarPorCodigo (Long codigo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Disciplina disciplina = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Disciplina.buscarPorCodigo");
            consulta.setLong("codigo", codigo);
            
            disciplina = (Disciplina) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
        
        return disciplina;
    }
    
    
    public void excluir (Disciplina disciplina){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(disciplina);
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
    
    public void editar (Disciplina disciplina){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.update(disciplina);
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
