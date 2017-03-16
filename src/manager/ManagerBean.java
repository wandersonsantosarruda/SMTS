package manager;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;
import entity.Usuario;

@ManagedBean(name="mb")
@RequestScoped
public class ManagerBean {

	private Usuario usuario;
	
	public ManagerBean() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void create(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			new UsuarioDao().create(usuario);
			fc.addMessage("form1", new FacesMessage("Usuario Cadastrado!"));
		}catch(Exception ex){
			fc.addMessage("form1", new FacesMessage("Usuario não Cadastrado! Erro: " +ex.getMessage()));
		}
		
		usuario = new Usuario();
	}
}
