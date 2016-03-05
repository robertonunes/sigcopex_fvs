/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.sigcopex.dao.UsuarioDAO;
import br.com.sigcopex.domain.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Roberto
 */
public class UsuarioDAOTeste {
    
    @Test
    
    public void salvar(){
        Usuario usuario = new Usuario();
        usuario.setCodigo(7399L);
        usuario.setNome("Roberto Nunes Ferreira");
        usuario.setIdentidade("28.153.542-5");
        usuario.setCpf("223.977.588-22");
        usuario.setTelefone("88999857731");
        usuario.setEndereco("José Linhares");
        usuario.setEmail("robertonunesferreira@hotmail.com");
        usuario.setSenha("uy2to7k5");
        usuario.setFuncao("Administrador");
        
        UsuarioDAO dao = new UsuarioDAO();
        
        dao.salvar(usuario);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
