package dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.empresaModel;
import model.pasajeroModel;

public class pasajeroDao extends dao {

  
    public void registrar(pasajeroModel per) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into pasajero (nombre,apellido,nrodocumento) values (?,?,?)");
            st.setString(1, per.getNombre());
            st.setString(2, per.getApellido());
             st.setString(3, per.getNumdoc());
         

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

   
    public List<pasajeroModel> listar() throws Exception {
        List<pasajeroModel> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select * from pasajero ");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                pasajeroModel per = new pasajeroModel();
                per.setId(rs.getString("idpasajero"));
                per.setNombre(rs.getString("nombre"));
                per.setApellido(rs.getString("apellido"));
                per.setNumdoc(rs.getString("nroDocumento"));
      
            
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
 
    public void modificar(pasajeroModel per) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("Update pasajero Set nombre=?, apellido=?, nrodocumento=? Where idpasajero = ?");

            st.setString(1, per.getNombre());
            st.setString(2, per.getApellido());
            st.setString(3, per.getNumdoc());
           st.setString(4, per.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

 
    public void eliminar(pasajeroModel per) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("Delete From pasajero Where idpasajero =?");
            st.setString(1, per.getId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        }
   }
