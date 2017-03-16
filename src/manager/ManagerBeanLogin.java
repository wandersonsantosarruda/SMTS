package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import entity.Login;
import entity.Usuario;

@ManagedBean(name="mbLogin")
@SessionScoped
public class ManagerBeanLogin implements Serializable {
	
	private Login login;
	private List<Usuario> lstLogin;
	private String loginUsuario;
	private String senhaUsuario;
	
	public ManagerBeanLogin(){
		login = new Login();
	}
	
	public List<Usuario> getLstLogin() {
		return lstLogin;
	}

	public void setLstLogin(List<Usuario> lstLogin) {
		this.lstLogin = lstLogin;
	}

	public String logarNoSistema() throws Exception{
		loginUsuario = login.getUsuario();
		senhaUsuario = login.getSenha();
		
		//FacesContext fc = FacesContext.getCurrentInstance();
		//try{
			System.out.println(loginUsuario);
			System.out.println(senhaUsuario);
			lstLogin = new UsuarioDao().selectById(loginUsuario,senhaUsuario);
			if(!lstLogin.isEmpty()){
				//add usuario na sessão
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.setAttribute("usuario", login);
				
				//direciona para o index
				return "/app/main?faces-redirect=true";
				
			}else{
				//o usuario não esta logado, redireciona para a tela de login
				return "/security/login?faces-redirect=true";
			}
		}
	
	public String Sair(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/security/login?faces-redirect=true";
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	

}
