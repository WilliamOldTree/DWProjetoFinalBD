package persitences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO implements IUserDAO{
	
	
	private Connection connection;
	
	public UserDAO() throws ClassNotFoundException, SQLException {
		IGenericDAO genDao = new GenericDAO();
		connection =  genDao.getConnection();	
	}
	
	
	@Override
	public void insertUser(User user) throws SQLException {
		
		String sql = "INSERT  INTO  USERS  (name, email, country) VALUES ( ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getNome());
		ps.setString(2, user.getEmail());
		ps.setString(3,  user.getPais());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void updateUser(User user) throws SQLException {
		
		String sql = "UPDATE USERS SET name = ?, email = ? WHERE id_users = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getNome());
		ps.setString(2, user.getEmail());
		ps.setInt(3, user.getId());
		
		ps.execute();
		ps.close();
				
	}//end updateUser

	@Override
	public void deleteUser(User user) throws SQLException {
		
		String sql = "DELETE FROM USERS WHERE id_users = ? ";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, user.getId());
		ps.execute();
		ps.close();
				
	}//end deleteUser

	@Override
	public User searchUser(User user) throws SQLException {
		
		/* consultar um registro */
		String sql = "SELECT id_users, name, email, country FROM USERS WHERE id_users = ?";
		PreparedStatement ps  = connection.prepareStatement(sql);
		ps.setInt(1,user.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			user.setId(rs.getInt("id_users"));
			user.setNome(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPais(rs.getNString("country"));	
		}
		rs.close();
		ps.close();
	
		return user;
	}// end searchUser

	@Override
	public List<User> searchUsers() throws SQLException {
		
		List<User> listUsers = new ArrayList <User>();
		String sql = "SELECT id_users, name, email, country FROM USERS";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id_users"));
			user.setNome(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPais(rs.getString("country"));
			listUsers.add(user);
		}
		rs.close();
		ps.close();
		return listUsers;
	}//end searchUsers


	
	
}//end userDAO