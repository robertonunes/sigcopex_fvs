
package br.com.sigcopex.bean;


import br.com.sigcopex.dao.CursoDAO;
import br.com.sigcopex.domain.Curso;
import br.com.sigcopex.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class CursoBean {
    private Curso cursoCadastro;
    private List<Curso> listaCursos;
    private List<Curso> ListaCursosFiltrados;
    
    private String acao;
    private Long codigo;
    
     /**
     * @return the cursoCadastro
     */
    public Curso getCursoCadastro() {
        if(cursoCadastro == null){
            cursoCadastro = new Curso();
        }
        return cursoCadastro;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Curso> getListaCursosFiltrados() {
        return ListaCursosFiltrados;
    }

    public void setListaCursosFiltrados(List<Curso> ListaCursosFiltrados) {
        this.ListaCursosFiltrados = ListaCursosFiltrados;
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
     * @param cursoCadastro the cursoCadastro to set
     */
    public void setCursoCadastro(Curso cursoCadastro) {
        this.cursoCadastro = cursoCadastro;
    }
    
    public void novo(){
        cursoCadastro = new Curso();
    }
    
    public void salvar(){
        try{
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.salvar(getCursoCadastro());
            
            cursoCadastro = new Curso();
            
            FacesUtil.adicionarMsgInfo("Curso salvo com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar incluir o Curso: " + ex.getMessage());
        }
        
    

   
    }
    
    public void carregarPesquisa(){
        try {
            CursoDAO cursoDAO = new CursoDAO();
            listaCursos = cursoDAO.listar();
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar os cursos: " + ex.getMessage());
        }
    }
    
    public void carregarCadastro(){
        try {
            
            if(codigo != null){
                
                CursoDAO cursoDAO = new CursoDAO();
                cursoCadastro = cursoDAO.buscarPorCodigo(codigo);
            } else {
                cursoCadastro = new Curso();
            }
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os dados do curso: " 
                    + ex.getMessage());
        }
    }
    
    public void excluir(){
        try{
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.excluir(cursoCadastro);
            
                        
            FacesUtil.adicionarMsgInfo("Curso removido com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar remover o curso: " + ex.getMessage());
        }
        
    }
    
    public void editar(){
        try{
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.editar(cursoCadastro);
            
            FacesUtil.adicionarMsgInfo("Curso editado com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar editar curso: " + ex.getMessage());
        }
        
    }
    
}

