
package controller;

import dao.empresaDao;
import dao.pasajeroDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Data;
import model.empresaModel;
import model.pasajeroModel;


@Data
@Named(value = "pasajeroController")
@SessionScoped
public class pasajeroController implements Serializable {

    private pasajeroModel empresa = new pasajeroModel();
    private List<pasajeroModel> listempresa;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void preparCI() {
        empresa = new pasajeroModel();
    }

    public void add() throws Exception {
        pasajeroDao dao;
        try {
            dao = new pasajeroDao();
            dao.registrar(empresa);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se han guardado con exito los cambios!", "Se han guardado con exito los cambios!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "aviso", "error"));
            throw e;
        }
    }

    public void update() throws Exception {
        pasajeroDao dao;
        try {
            dao = new pasajeroDao();
            dao.modificar(empresa);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "modificación exitoso!", "modificación exitoso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "aviso", "error"));
            throw e;
        }
    }

    public void listar() throws Exception {
        pasajeroDao dao;
        try {

            dao = new pasajeroDao();
            listempresa = dao.listar();

       
        } catch (Exception e) {

            throw e;
        }
    }



    public void delete() throws Exception {
        pasajeroDao dao;
        try {
            dao = new pasajeroDao();
            dao.eliminar(empresa);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "eliminado exitoso!", "eliminado exitoso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "aviso", "error"));
            throw e;
        }
    }




}
