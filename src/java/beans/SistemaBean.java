package beans;

import beans.UsuarioBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="SistemaBean")
@SessionScoped
public class SistemaBean {
    
    private List usuarios;
    private LoginBean login; 
    private SorteioBean sorteio;
         
    public SistemaBean(){
        usuarios = new ArrayList<UsuarioBean>();
        // Usuarios Default
        usuarios.add(new UsuarioBean("Administrador","admin","admin",null));
        usuarios.add(new UsuarioBean("Marcos","marcos","paulo",null));
        usuarios.add(new UsuarioBean("Raittes","joao","paulo",null));
        
        // Usuario da sessao
        login = new LoginBean();            
        sorteio = new SorteioBean();     
    }

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }
    
    
    
    public void cadastrar(String nome, String login, String senha, Long telefone) {
        usuarios.add(new UsuarioBean(nome,login,senha,telefone));
                
    }   

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }
    
    
    public SorteioBean getSorteio() {
        return sorteio;
    }
    public void setSorteio(SorteioBean sorteio) {
        this.sorteio = sorteio;
    }    
        
    
    public String checaLogin(String slogin, String senha){
        
        for(Object u : usuarios){
            UsuarioBean user = (UsuarioBean) u;
            if(slogin.equals(user.getLogin().toString())){
                if(senha.equals(user.getSenha())){
                    login.logar(user);
                    return "[logado]";                                        
                }
            }
        }        
        return "Falha no login";
    }    
}
