
package br.com.sigcopex.bean;

import br.com.sigcopex.dao.UsuarioDAO;
import br.com.sigcopex.domain.Usuario;
import br.com.sigcopex.util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean
@ViewScoped
public class UsuarioBean {
    private Usuario usuarioCadastro;
    private List<Usuario> listaUsuarios;
    private List<Usuario> ListaUsuariosFiltrados;
    
    private String acao;
    private Long codigo;
    
     /**
     * @return the usuarioCadastro
     */
    public Usuario getUsuarioCadastro() {
        if(usuarioCadastro == null){
            usuarioCadastro = new Usuario();
        }
        return usuarioCadastro;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Usuario> getListaUsuariosFiltrados() {
        return ListaUsuariosFiltrados;
    }

    public void setListaUsuariosFiltrados(List<Usuario> ListaUsuariosFiltrados) {
        this.ListaUsuariosFiltrados = ListaUsuariosFiltrados;
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
     * @param usuarioCadastro the usuarioCadastro to set
     */
    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }
    
    public void novo(){
        usuarioCadastro = new Usuario();
    }
    
    public void salvar(){
        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioCadastro.setSenha(DigestUtils.md5Hex(usuarioCadastro.getSenha()));
            usuarioDAO.salvar(getUsuarioCadastro());
            
            usuarioCadastro = new Usuario();
            
            FacesUtil.adicionarMsgInfo("Usuario salvo com sucesso");
            
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar incluir o Usuário: " + ex.getMessage());
        }
        
    

   
    }
    
    public void carregarPesquisa(){
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            listaUsuarios = usuarioDAO.listar();
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar os usuários: " + ex.getMessage());
        }
    }
    
    public void carregarCadastro(){
        try {
            
            if(codigo != null){
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioCadastro = usuarioDAO.buscarPorCodigo(codigo);
            } else {
                usuarioCadastro = new Usuario();
            }
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os dados do usuário: " 
                    + ex.getMessage());
        }
    }
    
    public void excluir(){
        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.excluir(usuarioCadastro);
            
                        
            FacesUtil.adicionarMsgInfo("Usuário removido com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar remover o usuário: " + ex.getMessage());
        }
        
    }
    
    public void editar(){
        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            /* Transformar senha em MD5 */
            usuarioCadastro.setSenha(DigestUtils.md5Hex(usuarioCadastro.getSenha()));
            usuarioDAO.editar(usuarioCadastro);
            
            FacesUtil.adicionarMsgInfo("Usuário editado com sucesso");
        }catch(RuntimeException ex){
            FacesUtil.adicionarMsgError("Erro ao tentar editar usuário: " + ex.getMessage());
        }
        
    }
    
}
