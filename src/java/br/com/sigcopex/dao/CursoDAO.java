/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.dao;

import br.com.sigcopex.domain.Curso;
import br.com.sigcopex.util.HibernateUtil;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author Roberto
 */
public class CursoDAO {
    public void salvar (Curso curso){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.save(curso);
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
    
    
    public List<Curso> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Curso> cursos = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Curso.listar");
            cursos = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
             return cursos;
    }
    
    
    public Curso buscarPorCodigo (Long codigo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Curso curso = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Curso.buscarPorCodigo");
            consulta.setLong("codigo", codigo);
            
            curso = (Curso) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
        
        return curso;
    }
    
    
    public void excluir (Curso curso){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(curso);
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
    
    public void editar (Curso curso){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.update(curso);
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
