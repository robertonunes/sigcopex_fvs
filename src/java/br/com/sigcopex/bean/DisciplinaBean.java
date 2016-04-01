
package br.com.sigcopex.bean;

import br.com.sigcopex.dao.DisciplinaDAO;
import br.com.sigcopex.domain.Disciplina;
import br.com.sigcopex.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class DisciplinaBean {
    private Disciplina disciplinaCadastro;
    private List<Disciplina> listaDisciplinas;
    private List<Disciplina> ListaDisciplinasFiltrados;
    
    private String acao;
    private Long codigo;
    
     /**
     * @return the usuarioCadastro
     */
    public Disciplina getDisciplinaCadastro() {
        if(disciplinaCadastro == null){
            disciplinaCadastro = new Disciplina();
        }
        return disciplinaCadastro;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    public List<Disciplina> getListaDisciplinasFiltrados() {
        return ListaDisciplinasFiltrados;
    }

    public void setListaDisciplinasFiltrados(List<Disciplina> ListaDisciplinasFiltrados) {
        this.ListaDisciplinasFiltrados = ListaDisciplinasFiltrados;
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
     * @param disciplinaCadastro the usuarioCadastro to set
     */
    public void setDisciplinaCadastro(Disciplina disciplinaCadastro) {
        this.disciplinaCadastro = disciplinaCadastro;
    }
    
    public void novo(){
        disciplinaCadastro = new Disciplina();
    }
    
    public void salvar(){
        try{
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            disciplinaDAO.salvar(getDisciplinaCadastro());
            
            disciplinaCadastro = new Disciplina();
            
            FacesUtil.adicionarMsgInfo("Disciplina salvo com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar incluir a Disciplina: " + ex.getMessage());
        }
        
    

   
    }
    
    public void carregarPesquisa(){
        try {
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            listaDisciplinas = disciplinaDAO.listar();
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar as disciplinas: " + ex.getMessage());
        }
    }
    
    public void carregarCadastro(){
        try {
            
            if(codigo != null){
                
                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                disciplinaCadastro = disciplinaDAO.buscarPorCodigo(codigo);
            } else {
                disciplinaCadastro = new Disciplina();
            }
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os dados da disciplina: " 
                    + ex.getMessage());
        }
    }
    
    public void excluir(){
        try{
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            disciplinaDAO.excluir(disciplinaCadastro);
            
                        
            FacesUtil.adicionarMsgInfo("Disciplina removida com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar remover a disciplina: " + ex.getMessage());
        }
        
    }
    
    public void editar(){
        try{
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            /* Transformar senha em MD5 */
            disciplinaDAO.editar(disciplinaCadastro);
            
            FacesUtil.adicionarMsgInfo("Disciplina editado com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar editar a disciplina: " + ex.getMessage());
        }
        
    }
    
}
