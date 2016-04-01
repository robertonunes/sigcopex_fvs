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
@Table (name = "tbl_curso")

@NamedQueries({
    @NamedQuery(name = "Curso.listar", query = "SELECT curso FROM Curso curso"),
    @NamedQuery(name = "Curso.buscarPorCodigo", 
            query = "SELECT curso FROM Curso curso WHERE curso.codigo = :codigo")
})

public class Curso {
    
    @Id
    
    @Column (name = "cur_codigo")
    private Long codigo;
    
    @Column (name = "curso_nome", length = 60, nullable = false)
    private String nome;
    
    @Column (name = "curso_coordenador", length = 50, nullable = false)
    private String coordenador;

    /**
     * @return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
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
     * @return the coordenador
     */
    public String getCoordenador() {
        return coordenador;
    }

    /**
     * @param coordenador the coordenador to set
     */
    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nome=" + nome + ", coordenador=" + coordenador + '}';
    }
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
}
