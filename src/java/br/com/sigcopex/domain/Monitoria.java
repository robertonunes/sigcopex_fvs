/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author Roberto Nunes
 */

@Entity
@Table(name = "tbl_monitoria")
@NamedQueries({
     @NamedQuery(name = "Monitoria.listar", query = "SELECT monitoria FROM Monitoria monitoria"),
     @NamedQuery(name = "Monitoria.buscarPorCodigo",
             query = "SELECT monitoria FROM Monitoria monitoria WHERE monitoria.codigo = :codigo")
})
public class Monitoria {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "mon_id")
    private Long codigo;
    
    @Column (name = "mon_nome", length = 60, nullable = false)
    private String professor;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_curso_cur_codigo", 
            referencedColumnName = "cur_codigo", nullable = false) 
    private Curso curso;
    
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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    
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
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
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

    @Override
    public String toString() {
        return "Monitoria{" + "codigo=" + codigo + ", professor=" + professor + ", curso=" + curso + ", disciplina=" + disciplina + ", orientador=" + orientador + ", semestre=" + semestre + ", vagas=" + vagas + ", tipo=" + tipo + ", realizacao=" + realizacao + ", hora=" + hora + ", justificativa=" + justificativa + ", conteudo=" + conteudo + '}';
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        
        if (obj == null) 
            return false;
        
        if (getClass() != obj.getClass()) 
            return false;
        
        Monitoria other = (Monitoria) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
            return true;
        
       
    }

}
