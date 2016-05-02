package br.com.sigcopex.converter;


import br.com.sigcopex.dao.DisciplinaDAO;
import br.com.sigcopex.domain.Disciplina;
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
@FacesConverter("disciplinaConverter")
public class DisciplinaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, 
            String valor) {
        try {
            Long codigo = Long.parseLong(valor);
            
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            Disciplina disciplina = disciplinaDAO.buscarPorCodigo(codigo);
            
            return disciplina;
        } catch (Exception e) {
          return null;
        }
        
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, 
            Object objeto) {
        try {
            Disciplina disciplina = (Disciplina) objeto;
            Long codigo = disciplina.getCodigo();
            return codigo.toString();
        } catch (Exception e) {
            return null;
        }
    }

   
    
}

