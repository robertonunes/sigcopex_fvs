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
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Roberto
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean {

    /**
     * @return the usuarioAtivo
     */
    public static Usuario getUsuarioAtivo() {
        return usuarioAtivo;
    }

    /**
     * @param aUsuarioAtivo the usuarioAtivo to set
     */
    public static void setUsuarioAtivo(Usuario aUsuarioAtivo) {
        usuarioAtivo = aUsuarioAtivo;
    }

    Usuario usuarioLogado;
    private static Usuario usuarioAtivo;

    public Usuario getUsuarioLogado() {
        if (usuarioLogado == null) {
            usuarioLogado = new Usuario();
            setUsuarioAtivo(usuarioLogado);
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario Logado) {
        usuarioLogado = usuarioLogado;
    }

    public String autenticar() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioLogado = usuarioDAO.autenticar(
                    usuarioLogado.getCpf(), DigestUtils.md5Hex(usuarioLogado.getSenha()));
            usuarioAtivo = usuarioLogado;
            if (usuarioLogado == null) {
                FacesUtil.adicionarMsgError("CPF e/ou senha inválido(s)");
                return null;
            } else {
                FacesUtil.adicionarMsgInfo("Usuário autenticado com sucesso: " + usuarioLogado.getNome());
                return "/pages/principal.xhtml?faces-redirect=true";
            }

        } catch (RuntimeException ex) {
            FacesUtil
                    .adicionarMsgError("Erro ao tentar autenticar no sistema: "
                            + ex.getMessage());
            return null;
        }

    }

    public String sair() {
        usuarioLogado = null;
        return "/pages/autenticacao.xhtml?faces-redirect=true";
    }

}
