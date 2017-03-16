package entity;

public class Usuario {
	private Integer idUsuario;
	private String nome;
	private String senha;
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, String nome, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", senha=" + senha + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}