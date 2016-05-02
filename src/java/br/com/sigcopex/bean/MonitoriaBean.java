
package br.com.sigcopex.bean;


import br.com.sigcopex.dao.CursoDAO;
import br.com.sigcopex.dao.DisciplinaDAO;
import br.com.sigcopex.dao.MonitoriaDAO;
import br.com.sigcopex.domain.Curso;
import br.com.sigcopex.domain.Disciplina;
import br.com.sigcopex.domain.Monitoria;
import br.com.sigcopex.util.FacesUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MonitoriaBean {

    private Monitoria monitoriaCadastro;
    private List<Monitoria> listaMonitorias;
    private List<Monitoria> ListaMonitoriasFiltrados;

    private String acao;
    private Long codigo;

    // Listagem dos Extensao
    private List<Curso> listaCursos;
    private List<Disciplina> listaDisciplinas;

    public Monitoria getMonitoriaCadastro() {
        return monitoriaCadastro;
    }

    public void setMonitoriaCadastro(Monitoria monitoriaCadastro) {
        this.monitoriaCadastro = monitoriaCadastro;
    }

    public List<Monitoria> getListaMonitorias() {
        return listaMonitorias;
    }

    public void setListaMonitorias(List<Monitoria> listaMonitorias) {
        this.listaMonitorias = listaMonitorias;
    }

    public List<Monitoria> getListaMonitoriasFiltrados() {
        return ListaMonitoriasFiltrados;
    }

    public void setListaMonitoriasFiltrados(List<Monitoria> ListaMonitoriasFiltrados) {
        this.ListaMonitoriasFiltrados = ListaMonitoriasFiltrados;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    public void novo() {
        monitoriaCadastro = new Monitoria();
    }

    public void salvar() {
        try {
            MonitoriaDAO monitoriaDAO = new MonitoriaDAO();

            monitoriaDAO.salvar(monitoriaCadastro);

            monitoriaCadastro = new Monitoria();

            FacesUtil.adicionarMsgInfo("Formulário de Monitoria salvo com sucesso");
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar incluir formulário de monitoria: " + ex.getMessage());
        }

    }

    public void carregarPesquisa() {
        try {
            MonitoriaDAO monitoriaDAO = new MonitoriaDAO();
            System.out.println("entrei aqui");
            /*Solução temp */
            List<Monitoria> monitorias = monitoriaDAO.listar();
            for (Monitoria monitoria : monitorias) {
                if (monitoria.getProfessor().equalsIgnoreCase(AutenticacaoBean.getUsuarioAtivo().getNome())) {
                    if (listaMonitorias == null) {
                        listaMonitorias = new ArrayList<Monitoria>();
                    }
                    listaMonitorias.add(monitoria);
                }
            }
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar listar os formulários de monitoria: " + ex.getMessage());
        }
    }

    public void carregarCadastro() {
        try {

            if (codigo != null) {

                MonitoriaDAO monitoriaDAO = new MonitoriaDAO();
                monitoriaCadastro = monitoriaDAO.buscarPorCodigo(codigo);
            } else {
                monitoriaCadastro = new Monitoria();
            }

            CursoDAO cursoDAO = new CursoDAO();
            listaCursos = cursoDAO.listar();

            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            listaDisciplinas = disciplinaDAO.listar();

        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar obter os dados do formulário de Monitoria: "
                    + ex.getMessage());
        }
    }

    public void excluir() {
        try {
            MonitoriaDAO monitoriaDAO = new MonitoriaDAO();
            monitoriaDAO.excluir(monitoriaCadastro);

            FacesUtil.adicionarMsgInfo("Formulário de monitoria removido com sucesso");
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar remover o formulário de monitoria: " + ex.getMessage());
        }

    }

    public void editar() {
        try {
            MonitoriaDAO monitoriaDAO = new MonitoriaDAO();
            monitoriaDAO.editar(monitoriaCadastro);

            FacesUtil.adicionarMsgInfo("Formulario de monitoria editado com sucesso");
        } catch (RuntimeException ex) {
            FacesUtil.adicionarMsgError("Erro ao tentar editar o formulário de monitoria: " + ex.getMessage());
        }

    }

}