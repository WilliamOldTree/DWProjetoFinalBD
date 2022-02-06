package model;

import java.util.ArrayList;
import java.util.List;

public class Container {
	
	private List<User> usuarios = new ArrayList<User>();
	private static int id = 1;

	public void inserir(User user) {
		user.setId(id);
		usuarios.add(user);
		id++;
	}

	public List<User> consultar() {
		return usuarios;
	}

	public User consultar(int indice) {
		return usuarios.get(indice);
	}

	public void alterar(int id, String nome, String email, String pais) {
		User user = consultar(id);
		user.setNome(nome);
		user.setEmail(email);
		user.setPais(pais);
	}

	public void deletar(int indice) {
		usuarios.remove(indice);
	}

}//end  Container
