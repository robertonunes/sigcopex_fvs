/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.dao;

import br.com.sigcopex.domain.TermoAutorizacaoExtensao;
import br.com.sigcopex.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Roberto
 */
public class TermoAutorizacaoExtensaoDAO {
    public void salvar (TermoAutorizacaoExtensaoDAO termoAutorizacaoExtensao){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.save(termoAutorizacaoExtensao);
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
    
    
    public List<TermoAutorizacaoExtensao> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<TermoAutorizacaoExtensao> termoAutorizacaoExtensaos = null;
        
        try {
            Query consulta = sessao.getNamedQuery("Monitoria.listar");
            termoAutorizacaoExtensaos = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
             return termoAutorizacaoExtensaos;
    }
    
    
    public TermoAutorizacaoExtensao buscarPorCodigo (Long codigo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        TermoAutorizacaoExtensao termoAutorizacaoExtensao = null;
        
        
        try {
            
            
            Query consulta = sessao.getNamedQuery("TermoAutorizacaoExtensao.buscarPorCodigo");
            consulta.setLong("codigo", codigo);
            
            termoAutorizacaoExtensao = (TermoAutorizacaoExtensao) consulta.uniqueResult();
           
        } 
        
        catch (RuntimeException ex) {
            throw ex;
        } finally{
            sessao.close();
        }
        
        return termoAutorizacaoExtensao;
        
        
    }
    
    
    
    
    public void excluir (TermoAutorizacaoExtensao termoAutorizacaoExtensao){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.delete(termoAutorizacaoExtensao);
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
    
    public void editar (TermoAutorizacaoExtensao termoAutorizacaoExtensao){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try {
            transacao = sessao.beginTransaction();
            sessao.update(termoAutorizacaoExtensao);
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

    public void salvar(TermoAutorizacaoExtensao termoAutorizacaoExtensaoCadastro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
