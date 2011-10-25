package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
    
    private UsuarioBean usuario;
    private String login;
    private String senha;
    
    public LoginBean() {
        usuario = null;       
    }
    public void logar(UsuarioBean user){
        this.usuario = user;
    }
    public void deslogar(){
        this.usuario = null;
    }
    public UsuarioBean getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
