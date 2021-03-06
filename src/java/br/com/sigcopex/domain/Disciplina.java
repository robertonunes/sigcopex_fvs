/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.domain;

import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Roberto
 */

@Entity
@Table(name = "tbl_disciplina")
@NamedQueries({
    @NamedQuery(name = "Disciplina.listar", query = "SELECT disciplina FROM Disciplina disciplina"),
    @NamedQuery(name = "Disciplina.buscarPorCodigo", query = "SELECT disciplina FROM Disciplina disciplina WHERE disciplina.codigo = :codigo")
})
public class Disciplina {
    
    @Id
    
    @Column (name = "disci_codigo")
    private Long codigo;
    
    @Column (name = "disci_nome", length = 60, nullable = false)
    private String nome;
    
    @Column (name = "disci_horas", length = 3, nullable = false)   
    private Long horas;

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

    public Long getHoras() {
        return horas;
    }

    public void setHoras(Long horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", nome=" + nome + ", horas=" + horas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.horas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.horas, other.horas)) {
            return false;
        }
        return true;
    }

    /**
     * @return the codigo
     */
    
    
    
    }
