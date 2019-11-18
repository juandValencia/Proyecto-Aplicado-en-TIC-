package demo1.proyectotic1.tic1;

import android.util.Log;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class SQLServerConnection {
    Connection connection = null;
    String cn = "jdbc:jtds:sqlserver://192.168.43.106;port=1433;databaseName=RetoEmpresarial;user=sa;password=admin";
    public Connection conexion(){
        try {
            Log.i("paso1","Entró");
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection(cn);
            Log.i("paso2","Conexión OK");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}