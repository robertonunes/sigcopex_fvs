/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.domain;

import java.util.Date;
import javax.persistence.*;


/**
 *
 * @author Roberto Nunes
 */

@Entity
@Table(name = "tbl_monitoria")
@NamedQueries({
    @NamedQuery(name = "usuario.listar", query = "SELECT usuario FROM FormularioMonitoria usuario"),
    @NamedQuery(name = "usuario.buscarPorMonitoria", query = "SELECT usuario FROM FormularioMonitoria usuario WHERE usuario.professor = :professor")    
})
public class FormularioMonitoria {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "mon_id")
    private Long id;
    
    @Column (name = "mon_nome", length = 60, nullable = false)
    private String professor;
    
    @Column (name = "mon_curso", length = 60, nullable = false)
    private String curso;
    
    @Column (name = "mon_disciplina", length = 60, nullable = false)
    private String disciplina;
    
    @Column (name = "mon_orientador", length = 60, nullable = false)
    private String orientador;
    
    @Column (name = "mon_semestre", length = 30, nullable = false)
    private String semestre;
    
    @Column (name = "mon_vagas", length = 3, nullable = false)
    private int vagas;
    
    @Column (name = "mon_tipo", length = 12, nullable = false)
    private String tipo;
    
    @Temporal (value = TemporalType.DATE)
    @Column(name = "mon_realizacao", nullable = false)
    private Date realizacao;
    
    @Temporal (value = TemporalType.TIME)
    @Column(name = "mon_horario", nullable = false)
    private Date hora;
    
    @Column (name = "mon_justificativa", length = 500, nullable = false)
    private String justificativa;
    
    @Column (name = "mon_conteudo", length = 2000, nullable = false)
    private String conteudo;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the professor
     */
    public String getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the orientador
     */
    public String getOrientador() {
        return orientador;
    }

    /**
     * @param orientador the orientador to set
     */
    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the vagas
     */
    public int getVagas() {
        return vagas;
    }

    /**
     * @param vagas the vagas to set
     */
    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the realizacao
     */
    public Date getRealizacao() {
        return realizacao;
    }

    /**
     * @param realizacao the realizacao to set
     */
    public void setRealizacao(Date realizacao) {
        this.realizacao = realizacao;
    }

    /**
     * @return the hora
     */
    public Date getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     * @return the justificativa
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * @param justificativa the justificativa to set
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * @return the conteudo
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo the conteudo to set
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    
}
