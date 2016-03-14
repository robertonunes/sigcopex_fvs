package br.com.sigcopex.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "tbl_usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
    @NamedQuery(name = "Usuario.buscarPorCodigo", query = "SELECT usuario FROM Usuario usuario WHERE usuario.codigo = :codigo"),
    @NamedQuery(name = "Usuario.autenticar", 
            query = "SELECT usuario FROM Usuario usuario WHERE usuario.cpf = :cpf AND usuario.senha = :senha")
})
public class Usuario {
    @Id
    @Column(name = "user_codigo")
    private Long codigo;
    
    @NotEmpty(message = "O campo nome é obrigatório")
    @Size(min = 5,max = 50,message = "Tamanho inválido para o campo nome (5-50)")
    @Column (name = "user_nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "user_identidade", length = 20, nullable = false, unique = true)
    private String identidade;
    
    @CPF(message = "O CPF informado é inválido")
    @Column(name = "user_cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    
    
    @Column(name = "user_telefone", length = 13, nullable = false, unique = false)
    private String telefone;
    
    @Column(name = "user_endereco", length = 50, nullable = false, unique = false)
    private String endereco;
    
    @Email(message = "o email informado é inválido")
    @Column(name = "user_email", length = 40, nullable = false, unique = false)
    private String email;
    
    //curso que ministra fazer uma classe e herda-la
    @NotEmpty(message = "O campo senha é obrigatório")
    @Column(name = "user_senha", length = 32, nullable = false)
    private String senha;
    
    @NotEmpty(message = "O campo função é obrigatório")
    @Column(name = "user_funcao", length = 50)
    private String funcao;

    /**
     * @return the matricula
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the identidade
     */
    public String getIdentidade() {
        return identidade;
    }

    /**
     * @param identidade the identidade to set
     */
    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nome=" + nome + ", identidade=" + identidade + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email + ", senha=" + senha + ", funcao=" + funcao + '}';
    }
    
  
}
