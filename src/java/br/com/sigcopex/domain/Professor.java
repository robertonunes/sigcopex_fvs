package br.com.sigcopex.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;



@Entity
@Table(name = "tbl_professor")
@NamedQueries({
    @NamedQuery(name = "Professor.listar", query = "SELECT professor FROM Professor professor"),
    @NamedQuery(name = "Professor.buscarPorCodigo", query = "SELECT professor FROM Professor professor WHERE professor.codigo = :codigo"),
    
})
public class Professor {
    @Id
    @Column(name = "prof_codigo")
    private Long codigo;
    
    @NotEmpty(message = "O campo nome é obrigatório")
    @Size(min = 5,max = 50,message = "Tamanho inválido para o campo nome (5-50)")
    @Column (name = "prof_nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "prof_identidade", length = 20, nullable = false, unique = true)
    private String identidade;
    
    @CPF(message = "O CPF informado é inválido")
    @Column(name = "prof_cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    
    
    @Column(name = "user_telefone", length = 13, nullable = false, unique = false)
    private String telefone;
    
    @Column(name = "user_endereco", length = 50, nullable = false, unique = false)
    private String endereco;
    
    @Email(message = "o email informado é inválido")
    @Column(name = "user_email", length = 40, nullable = false, unique = false)
    private String email;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Professor{" + "codigo=" + codigo + ", nome=" + nome + ", identidade=" + identidade + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email + '}';
    }
    
    

   
    
  
}

