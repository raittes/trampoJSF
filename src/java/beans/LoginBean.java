package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {
    
    private UsuarioBean usuario;
    private List resultado;
    //temporario para logar
    private String login;
    private String senha;  
    private Long   codigo;
    
    public LoginBean() {
        usuario = null;
        codigo = null;
    }
    public String logar(UsuarioBean user){
        if(user==null)
            return "erro";
        else{
            this.usuario = user;
            //this.usuario = new UsuarioBean("jose","teste","teste",new Long(123));
            return "login";
        }            
    }  
    public String deslogar(UsuarioBean user){
        this.usuario=null;
        this.login=null;
        this.senha=null;
        this.codigo=null;
        return "index";
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
    public List getResultado() {
        return resultado;
    }
    public void setResultado(List resultado) {
        this.resultado = resultado;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public String getResponse(){
        if(usuario == null)
            return "deslogado";
        else
            return "logado";
    }
    public LoginBean getThis(){
        return this;
    }
    
}
