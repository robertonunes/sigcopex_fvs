/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.domain;

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
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "disci_codigo")
    private Long codigo;
    
    @Column (name = "disci_nome", length = 60, nullable = false)
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_curso_curso_codigo", 
            referencedColumnName = "curso_codigo", nullable = false)
    private Curso curso;

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
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", nome=" + nome + ", curso=" + curso + '}';
    }
    
    
    
    }
