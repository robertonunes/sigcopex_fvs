/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.sigcopex.dao.UsuarioDAO;
import br.com.sigcopex.domain.Usuario;
import org.junit.Test;

/**
 *
 * @author Roberto
 */
public class UsuarioDAOTest {
    
    @Test
    public void autenticar(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        Usuario usuario = usuarioDAO.autenticar("223.977.588-22", "uy2to7k5");
        
        System.out.println("Usuario: " + usuario);
    }
    
}
