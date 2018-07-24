
package controller;

import dao.empresaDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Data;
import model.empresaModel;


@Data
@Named(value = "empresaController")
@SessionScoped
public class empresaController implements Serializable {

    private empresaModel empresa = new empresaModel();
    private List<empresaModel> listempresa;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void preparCI() {
        empresa = new empresaModel();
    }

    public void add() throws Exception {
        empresaDao dao;
        try {
            dao = new empresaDao();
            dao.registrar(empresa);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se han guardado con exito los cambios!", "Se han guardado con exito los cambios!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "aviso", "error"));
            throw e;
        }
    }

    public void update() throws Exception {
        empresaDao dao;
        try {
            dao = new empresaDao();
            dao.modificar(empresa);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "modificación exitoso!", "modificación exitoso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "aviso", "error"));
            throw e;
        }
    }

    public void listar() throws Exception {
        empresaDao dao;
        try {

            dao = new empresaDao();
            listempresa = dao.listar();

       
        } catch (Exception e) {

            throw e;
        }
    }



    public void delete() throws Exception {
        empresaDao dao;
        try {
            dao = new empresaDao();
            dao.eliminar(empresa);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "eliminado exitoso!", "eliminado exitoso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "aviso", "error"));
            throw e;
        }
    }




}
