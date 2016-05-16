
package br.com.sigcopex.bean;



import br.com.sigcopex.dao.TermoAutorizacaoExtensaoDAO;
import br.com.sigcopex.domain.TermoAutorizacaoExtensao;
import br.com.sigcopex.util.FacesUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TermoAutorizacaoExtensaoBean {

    private TermoAutorizacaoExtensao termoCadastro;
    private List<TermoAutorizacaoExtensao> listaTermos;
    private List<TermoAutorizacaoExtensao> ListaTermosFiltrados;

    private String acao;
    private Long codigo;

    

    public TermoAutorizacaoExtensao getTermoCadastro() {
        return termoCadastro;
    }

    public void setTermoCadastro(TermoAutorizacaoExtensao termoCadastro) {
        this.termoCadastro = termoCadastro;
    }

    public List<TermoAutorizacaoExtensao> getListaTermos() {
        return listaTermos;
    }

    public void setListaTermos(List<TermoAutorizacaoExtensao> listaTermos) {
        this.listaTermos = listaTermos;
    }

    public List<TermoAutorizacaoExtensao> getListaTermosFiltrados() {
        return ListaTermosFiltrados;
    }

    public void setListaTermosFiltrados(List<TermoAutorizacaoExtensao> ListaTermosFiltrados) {
        this.ListaTermosFiltrados = ListaTermosFiltrados;
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

    

   
    

   

    public void novo() {
        termoCadastro = new TermoAutorizacaoExtensao();
    }

    public void salvar() {
        try {
            TermoAutorizacaoExtensaoDAO termoAutorizacaoExtensaoDAO = new TermoAutorizacaoExtensaoDAO();

            termoAutorizacaoExtensaoDAO.salvar(termoCadastro);

            termoCadastro = new TermoAutorizacaoExtensao();

            FacesUtil.adicionarMsgInfo("Termo de Autorização de Projeto de Extensão salvo com sucesso");
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar incluir o Termo de Autorização de Projeto de Extensão: " + ex.getMessage());
        }

    }

   public void carregarPesquisa(){
        try {
            TermoAutorizacaoExtensaoDAO termoAutorizacaoExtensaoDAO = new TermoAutorizacaoExtensaoDAO();
            listaTermos = termoAutorizacaoExtensaoDAO.listar();
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar os Termos de Autorização de Projeto de Extensão: " + ex.getMessage());
        }
    }

   public void carregarCadastro(){
        try {
            
            if(codigo != null){
                
                TermoAutorizacaoExtensaoDAO termoAutorizacaoExtensaoDAO = new TermoAutorizacaoExtensaoDAO();
                termoCadastro = termoAutorizacaoExtensaoDAO.buscarPorCodigo(codigo);
            } else {
                termoCadastro = new TermoAutorizacaoExtensao();
            }
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os dados do Termo de Autorização de Projeto de Extensão: " 
                    + ex.getMessage());
        }
    }

    public void excluir() {
        try {
            TermoAutorizacaoExtensaoDAO termoAutorizacaoExtensaoDAO = new TermoAutorizacaoExtensaoDAO();
            termoAutorizacaoExtensaoDAO.excluir(termoCadastro);

            FacesUtil.adicionarMsgInfo("Termo de Autorização de Projeto de Extensão removido com sucesso");
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar remover o Termo de Autorização de Projeto de Extensão: " + ex.getMessage());
        }

    }

    public void editar() {
        try {
            TermoAutorizacaoExtensaoDAO termoAutorizacaoExtensaoDAO = new TermoAutorizacaoExtensaoDAO();
            termoAutorizacaoExtensaoDAO.editar(termoCadastro);

            FacesUtil.adicionarMsgInfo("Termo de Autorização de Projeto de Extensão editado com sucesso");
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar editar o Termo de Autorização de Projeto de Extensão: " + ex.getMessage());
        }

    }

}