package dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.empresaModel;

public class empresaDao extends dao {

  
    public void registrar(empresaModel per) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into Empresa (nombre,razonsocial,direccion,teléfono,celular,email,ruc,sucursal_idsucursal) values (?,?,?,?,?,?,?,?)");
            st.setString(1, per.getNom());
            st.setString(2, per.getRazsocial());
             st.setString(2, per.getDir());
              st.setString(2, per.getTelf());
            st.setString(2, per.getCel());
            st.setString(2, per.getEmail());
            st.setString(2, per.getRuc());
           
            st.setString(12, per.getSucur());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

   
    public List<empresaModel> listar() throws Exception {
        List<empresaModel> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select * from empresa ");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                empresaModel per = new empresaModel();
                per.setId(rs.getString("idempresa"));
                per.setNom(rs.getString("nombre"));
                per.setRazsocial(rs.getString("razonsocial"));
      
                per.setDir(rs.getString("direccion"));
                per.setTelf(rs.getString("teléfono"));
                 per.setCel(rs.getString("celular"));
                  per.setTelf(rs.getString("email"));
                   per.setTelf(rs.getString("ruc"));
                      per.setTelf(rs.getString("sucursal_idsucursal"));
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
 
    public void modificar(empresaModel per) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("Update empresa Set nombre=?, razonsocial=?, direccion=?, teléfono=?, celular=?, email=?, ruc=?,sucursal_idsucursal=? Where idempresa = ?");

            st.setString(1, per.getNom());
            st.setString(2, per.getRazsocial());
            st.setString(3, per.getDir());
            st.setString(4, per.getTelf());
             st.setString(5, per.getCel());
             st.setString(6, per.getEmail());
            st.setString(7, per.getRuc());
            st.setString(8, per.getSucur());
           st.setString(9, per.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

 
    public void eliminar(empresaModel per) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("Delete From empresa Where idempresa =?");
            st.setString(1, per.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        }
 

}
