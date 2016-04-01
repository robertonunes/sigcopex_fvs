package br.com.sigcopex.converter;


import br.com.sigcopex.dao.CursoDAO;
import br.com.sigcopex.domain.Curso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Roberto
 */
@FacesConverter("cursoConverter")
public class CursoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, 
            String valor) {
        try {
            Long codigo = Long.parseLong(valor);
            
            CursoDAO cursoDAO = new CursoDAO();
            Curso curso = cursoDAO.buscarPorCodigo(codigo);
            
            return curso;
        } catch (Exception e) {
          return null;
        }
        
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, 
            Object objeto) {
        try {
            Curso curso = (Curso) objeto;
            Long codigo = curso.getCodigo();
            return codigo.toString();
        } catch (Exception e) {
            return null;
        }
    }

   
    
}
