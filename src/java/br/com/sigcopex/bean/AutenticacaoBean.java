/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.bean;

import br.com.sigcopex.dao.UsuarioDAO;
import br.com.sigcopex.domain.Usuario;
import br.com.sigcopex.util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Roberto
 */

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
    private Usuario usuarioLogado;

    public Usuario getUsuarioLogado() {
        if(usuarioLogado == null){
            usuarioLogado = new Usuario();
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario Logado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    
    public void autenticar(){
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioLogado = usuarioDAO.autenticar(usuarioLogado.getCpf(), usuarioLogado.getSenha());
            if (usuarioLogado == null) {
                FacesUtil.adicionarMsgError("CPF e/ou senha inválido(s)");
            } else{
                FacesUtil.adicionarMsgInfo("Usuário autenticado com sucesso");
            }
            
        } catch (RuntimeException ex) {
            FacesUtil
                    .adicionarMsgError("Erro ao tentar autenticar no sistema: "
                    + ex.getMessage());
        }
    }
    
    public String sair(){
        usuarioLogado = null;
        return "/pages/autenticacao.xhtml?faces-redirect=true";
    }
}
