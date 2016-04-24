/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.bean;

import br.com.sigcopex.dao.ExtensaoDAO;
import br.com.sigcopex.domain.Extensao;
import br.com.sigcopex.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ExtensaoBean {
    private Extensao extensao;
    private List<Extensao> listaExtensao;
    private List<Extensao> ListaExtensaoFiltrados;
    
    private String acao;
    private Long codigo;
    
     /**
     * @return the cursoCadastro
     */
    public Extensao getExtensaoCadastro() {
        if(extensao == null){
            extensao = new Extensao();
        }
        return extensao;
    }

    public List<Extensao> getListaExtensaoes() {
        return listaExtensao;
    }

    public void setListaExtensaoes(List<Extensao> listaExtensaos) {
        this.listaExtensao = listaExtensaos;
    }

    public List<Extensao> getListaExtensaoesFiltrados() {
        return ListaExtensaoFiltrados;
    }

    public void setListaExtensaoesFiltrados(List<Extensao> ListaExtensaoesFiltrados) {
        this.ListaExtensaoFiltrados = ListaExtensaoesFiltrados;
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
     * @param extensao the cursoCadastro to set
     */
    public void setExtensaoCadastro(Extensao extensao) {
        this.extensao = extensao;
    }
    
    public void novo(){
        extensao = new Extensao();
    }
    
    public void salvar(){
        try{
            ExtensaoDAO extensaoDAO = new ExtensaoDAO();
            extensaoDAO.salvar(getExtensaoCadastro());
            
            extensao = new Extensao();
            
            FacesUtil.adicionarMsgInfo("Extensão salva com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar incluir o extensão: " + ex.getMessage());
        }
    }
    
    public void carregarPesquisa(){
        try {
            ExtensaoDAO extensaoDAO = new ExtensaoDAO();
            listaExtensao = extensaoDAO.listar();
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar as extensões: " + ex.getMessage());
        }
    }
    
    public void carregarCadastro(){
        try {
            
            if(codigo != null){
                
                ExtensaoDAO extensaoDAO = new ExtensaoDAO();
                extensao = extensaoDAO.buscarPorCodigo(codigo);
            } else {
                extensao = new Extensao();
            }
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os dados da extensão: " 
                    + ex.getMessage());
        }
    }
    
    public void excluir(){
        try{
            ExtensaoDAO extensaoDAO = new ExtensaoDAO();
            extensaoDAO.excluir(extensao);
            
                        
            FacesUtil.adicionarMsgInfo("Extensao removido com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar remover o professor: " + ex.getMessage());
        }
        
    }
    
    public void editar(){
        try{
            ExtensaoDAO extensaoDAO = new ExtensaoDAO();
            extensaoDAO.editar(extensao);
            
            FacesUtil.adicionarMsgInfo("Extensao editado com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar editar o professor: " + ex.getMessage());
        }
        
    }
}
