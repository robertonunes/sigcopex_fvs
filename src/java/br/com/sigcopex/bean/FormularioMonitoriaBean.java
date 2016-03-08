/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.bean;

import br.com.sigcopex.dao.FormularioMonitoriaDAO;
import br.com.sigcopex.domain.FormularioMonitoria;
import br.com.sigcopex.util.FacesUtil;
import java.util.List;

/**
 *
 * @author Roberto
 */
public class FormularioMonitoriaBean {
    private FormularioMonitoria monitoriaCadastro;
    private List<FormularioMonitoria> listaMonitorias;
    private List<FormularioMonitoria> ListaMonitoriasFiltrados;
    
    private String acao;
    private Long codigo;
    
     /**
     * @return the usuarioCadastro
     */
    public FormularioMonitoria getFormularioMonitoria() {
        if(monitoriaCadastro == null){
            monitoriaCadastro = new FormularioMonitoria();
        }
        return monitoriaCadastro;
    }

    public List<FormularioMonitoria> getFormularioMonitorias() {
        return listaMonitorias;
    }

    public void setListaMonitorias(List<FormularioMonitoria> listaMonitorias) {
        this.listaMonitorias = listaMonitorias;
    }

    public List<FormularioMonitoria> getListaMonitoriasFiltrados() {
        return ListaMonitoriasFiltrados;
    }

    public void setListaMonitoriasFiltrados(List<FormularioMonitoria> ListaMonitoriasFiltrados) {
        this.ListaMonitoriasFiltrados = ListaMonitoriasFiltrados;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    
    /**
     * @param monitoriaCadastro the monitoriaCadastro to set
     */
    public void setMonitoriaCadastro(FormularioMonitoria monitoriaCadastro) {
        this.monitoriaCadastro = monitoriaCadastro;
    }
    
    public void novo(){
        monitoriaCadastro = new FormularioMonitoria();
    }
    
    public void salvar(){
        try{
            FormularioMonitoriaDAO formularioMonitoriaDAO = new FormularioMonitoriaDAO();
            formularioMonitoriaDAO.salvar(getFormularioMonitoria());
            
            monitoriaCadastro = new FormularioMonitoria();
            
            FacesUtil.adicionarMsgInfo("Formulário de Monitoria salvo com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar incluir o Formulário de Monitoria: " + ex.getMessage());
        }
        
    

   
    }
    
    public void carregarPesquisa(){
        try {
            FormularioMonitoriaDAO formularioMonitoriaDAO = new FormularioMonitoriaDAO();
            listaMonitorias = formularioMonitoriaDAO.listar();
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar os formulários de monitoria: " + ex.getMessage());
        }
    }
    
    public void carregarCadastro(){
        try {
            
            if(codigo != null){
                
                FormularioMonitoriaDAO formularioMonitoriaDAO = new FormularioMonitoriaDAO();
                monitoriaCadastro = formularioMonitoriaDAO.buscarPorCodigo(codigo);
            } else {
                monitoriaCadastro = new FormularioMonitoria();
            }
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os dados do formulário de Monitoria: " 
                    + ex.getMessage());
        }
    }
    
    public void excluir(){
        try{
            FormularioMonitoriaDAO formularioMonitoriaDAO = new FormularioMonitoriaDAO();
            formularioMonitoriaDAO.excluir(monitoriaCadastro);
            
                        
            FacesUtil.adicionarMsgInfo("Formulário de Monitoria removido com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar remover o formulário de monitoria: " + ex.getMessage());
        }
        
    }
    
    public void editar(){
        try{
            FormularioMonitoriaDAO formularioMonitoriaDAO = new FormularioMonitoriaDAO();
            /* Transformar senha em MD5
            usuarioCadastro.setSenha(DigestUtils.md5Hex(usuarioCadastro.getSenha()));*/
            formularioMonitoriaDAO.editar(monitoriaCadastro);
            
            FacesUtil.adicionarMsgInfo("Formulário de monitoria editado com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar editar o formulário de monitoria: " + ex.getMessage());
        }
        
    }
    
}
