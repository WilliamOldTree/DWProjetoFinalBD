package persitences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  GenericDAO implements IGenericDAO {

	

	private Connection connection;
	
	@Override
	public Connection getConnection()  {
		try {		
			if ((connection == null) || (connection.isClosed())) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoFinal", "root","root");
				System.out.println("Conexao estabelecida");
				return connection;
			}
		} catch (SQLException e) {
			System.out.println("Conexao nao estabelecida: " + e.getMessage());
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	
		return connection;
	}

}
