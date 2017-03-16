package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao extends ConnectionFactory{
	
	public void create(Usuario usuario) throws Exception{
		open();
		stmt = con.prepareStatement("insert into usuario (nome, senha) values(?,?)");
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getSenha());
		stmt.execute();
		stmt.close();		
		close();
		
	}
	
	public List<Usuario> selectById(String login, String senha) throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario where nome = ? and senha = ?");
		stmt.setString(1, login);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		
		List <Usuario> lstResult = new ArrayList<Usuario>();
		
		while(rs.next()){
			Usuario u = new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3));
			lstResult.add(u);
			}
		
		stmt.close();		
		close();
		return lstResult;
		
	}

}
