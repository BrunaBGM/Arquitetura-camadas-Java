package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	
	public static  Connection getConnection() {
		
		Connection conn= null;
		
		try {
			Class.forName("oracle.jbdc.driver.OracleDriver");
			conn = DriverManager.getConnection("jbdc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","rm","senha");
			
            if(conn!=null)
                System.out.println("Conexão estabelecida com sucesso!");
            else
                System.out.println("Falha na conexão com o Banco de Dados!");
		}
		catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(),e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
