

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.Data;

@Data
public class dao {

    public Connection cn;

    public void Conectar() throws Exception {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=TransFlorencio", "admin", "admin");

        } catch (SQLException e) {
            throw e;
        }
    }

    public void Cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}




    
    
    

