/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Roberto
 */

@Entity
@Table(name = "tbl_termo")
@NamedQueries({
     @NamedQuery(name = "TermoAutorizacaoExtensao.listar", query = "SELECT termoAutorizacaoExtensao FROM TermoAutorizacaoExtensao termoAutorizacaoExtensao"),
     @NamedQuery(name = "TermoAutorizacaoExtensao.buscarPorCodigo",
             query = "SELECT termoAutorizacaoExtensao FROM TermoAutorizacaoExtensao termoAutorizacaoExtensao WHERE termoAutorizacaoExtensao.codigo = :codigo")
})
public class TermoAutorizacaoExtensao {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "termo_id")
    private Long codigo;
    
    @Temporal (value = TemporalType.DATE)
    @Column(name = "termo_data", nullable = false)
    private Date data;
    
    @Column (name = "termo_destino", length = 60, nullable = false)
    private String destino;
    
    @Column (name = "termo_titulo", length = 100, nullable = false)
    private String titulo;
    
    @Column (name = "termo_objetivogeral", length = 300, nullable = false)
    private String objetivogeral;
    
    @Column (name = "termo_orientador", length = 60, nullable = false)
    private String orientador;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivogeral() {
        return objetivogeral;
    }

    public void setObjetivogeral(String objetivogeral) {
        this.objetivogeral = objetivogeral;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    @Override
    public String toString() {
        return "TermoAutorizacaoExtensao{" + "codigo=" + codigo + ", data=" + data + ", destino=" + destino + ", titulo=" + titulo + ", objetivogeral=" + objetivogeral + ", orientador=" + orientador + '}';
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
        
        TermoAutorizacaoExtensao other = (TermoAutorizacaoExtensao) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
            return true;
        
       
    }

    
    
}
