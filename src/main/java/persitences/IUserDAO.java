package persitences;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface IUserDAO {
	public void insertUser (User user) throws SQLException;
	public void updateUser(User user) throws SQLException;
	public void deleteUser(User user) throws SQLException;
	public User searchUser(User user)throws SQLException;
	public List<User> searchUsers ()throws SQLException;

}

