/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigcopex.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Roberto
 */

    @Entity
@Table(name = "tbl_extensao")
@NamedQueries({
     @NamedQuery(name = "Extensao.listar", query = "SELECT extensao FROM Extensao extensao"),
     @NamedQuery(name = "Extensao.buscarPorCodigo",
             query = "SELECT extensao FROM Extensao extensao WHERE extensao.codigo = :codigo")
})
public class FormularioExtensao {
    @Id
    @Column(name = "user_codigo")
    private Long codigo;
    
    @Size(min = 6,max = 200,message = "Tamanho inválido para o campo Título do Projeto (6-200)")
    @Column (name = "ext_nomeProjeto", length = 200)
    private String nomeProjeto;
    
    @Size(min = 5,max = 25,message = "Tamanho inválido para o campo Modalidade do Projeto (5-50)")
    @Column (name = "ext_modalidade", length = 50)
    private String modalidade;
    
    @Column (name = "ext_vinculo_qual", length = 50)
    private String vinculoQual;
    
    @Column (name = "ext_vinculo_periodo", length = 20)
    private String vinculoPeriodo;
    
    @Column (name = "ext_areaPrincipal", length = 20)
    private String areaPrincipal;
    
    @Column (name = "ext_areaSecundaria", length = 20)
    private String areaSecundaria;
    
    @Column (name = "ext_setor", length = 40)
    private String setor;
    
    @Temporal (value = TemporalType.DATE)
    @Column(name = "ext_inicio")
    private Date inicio;
    
    @Temporal (value = TemporalType.DATE)
    @Column(name = "ext_termino")
    private Date termino;
    
    @Column (name = "ext_municipio", length = 60)
    private String municipio;
    
    @Column (name = "ext_justificativa", length = 3000)
    private String justificativa;
    
    @Column (name = "ext_referenciais", length = 3000)
    private String referenciais;
    
    @Column (name = "ext_relacao", length = 2000)
    private String relacao;
    
    @Column (name = "ext_objGeral", length = 500)
    private String objetivos;
    
    @Column (name = "ext_especificos", length = 1000)
    private String especificos;
    
    @Column (name = "ext_metas", length = 1000)
    private String metas;
    
    @Column (name = "ext_metodologia", length = 5000)
    private String metodologia;
    
    @Column (name = "ext_avaliacao", length = 1000)
    private String avaliacao;
    
    @Column (name = "ext_resumo", length = 1000)
    private String resumo;
    
    @Column (name = "ext_referencias", length = 2000)
    private String referencias;
    
    @Size(min = 5,max = 50,message = "Tamanho inválido para o campo nome (5-50)")
    @Column (name = "ext_coordNome", length = 50)
    private String coordNome;
    
    @CPF(message = "O CPF informado é inválido")
    @Column(name = "ext_coordCpf", length = 14, unique = true)
    private String coordCpf;
    
    @Column(name = "ext_coordIdentidade", length = 20, unique = true)
    private String coordIdentidade;
    
    @Column(name = "ext_coordEndereco", length = 130)
    private String coordEndereco;
    
    @Column(name = "coordBairro", length = 40)
    private String coordBairro;
    
    @Column(name = "coordCidade", length = 40)
    private String coordCidade;
    
    @Column(name = "coordCep", length = 9)
    private String coordCep;
    
    
    
    
}
