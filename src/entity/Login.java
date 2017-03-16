package entity;

import java.io.Serializable;

public class Login implements Serializable {

	public static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}	

	public Login(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", senha=" + senha + "]";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
