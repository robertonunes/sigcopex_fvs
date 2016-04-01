
package br.com.sigcopex.bean;



import br.com.sigcopex.dao.ProfessorDAO;
import br.com.sigcopex.domain.Professor;
import br.com.sigcopex.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class ProfessorBean {
    private Professor professorCadastro;
    private List<Professor> listaProfessores;
    private List<Professor> ListaProfessoresFiltrados;
    
    private String acao;
    private Long codigo;
    
     /**
     * @return the cursoCadastro
     */
    public Professor getProfessorCadastro() {
        if(professorCadastro == null){
            professorCadastro = new Professor();
        }
        return professorCadastro;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessors) {
        this.listaProfessores = listaProfessors;
    }

    public List<Professor> getListaProfessoresFiltrados() {
        return ListaProfessoresFiltrados;
    }

    public void setListaProfessoresFiltrados(List<Professor> ListaProfessoresFiltrados) {
        this.ListaProfessoresFiltrados = ListaProfessoresFiltrados;
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
     * @param professorCadastro the cursoCadastro to set
     */
    public void setProfessorCadastro(Professor professorCadastro) {
        this.professorCadastro = professorCadastro;
    }
    
    public void novo(){
        professorCadastro = new Professor();
    }
    
    public void salvar(){
        try{
            ProfessorDAO professorDAO = new ProfessorDAO();
            professorDAO.salvar(getProfessorCadastro());
            
            professorCadastro = new Professor();
            
            FacesUtil.adicionarMsgInfo("Professor salvo com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar incluir o professor: " + ex.getMessage());
        }
        
    

   
    }
    
    public void carregarPesquisa(){
        try {
            ProfessorDAO professorDAO = new ProfessorDAO();
            listaProfessores = professorDAO.listar();
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar os professores: " + ex.getMessage());
        }
    }
    
    public void carregarCadastro(){
        try {
            
            if(codigo != null){
                
                ProfessorDAO professorDAO = new ProfessorDAO();
                professorCadastro = professorDAO.buscarPorCodigo(codigo);
            } else {
                professorCadastro = new Professor();
            }
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os dados do professor: " 
                    + ex.getMessage());
        }
    }
    
    public void excluir(){
        try{
            ProfessorDAO professorDAO = new ProfessorDAO();
            professorDAO.excluir(professorCadastro);
            
                        
            FacesUtil.adicionarMsgInfo("Professor removido com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar remover o professor: " + ex.getMessage());
        }
        
    }
    
    public void editar(){
        try{
            ProfessorDAO professorDAO = new ProfessorDAO();
            professorDAO.editar(professorCadastro);
            
            FacesUtil.adicionarMsgInfo("Professor editado com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar editar o professor: " + ex.getMessage());
        }
        
    }
    
}


