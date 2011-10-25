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
    private UsuarioBean usuario;    
         
    public SistemaBean(){
        usuarios = new ArrayList<UsuarioBean>();
        
        usuarios.add(new UsuarioBean("marcos","paulo"));
        usuarios.add(new UsuarioBean("marcos2","paulo2"));
        usuarios.add(new UsuarioBean(null,null));
        usuarios.add(new UsuarioBean("joao","paulo"));
        usuario = new UsuarioBean(null,null);
     
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
    
    public String getResponse(){
        
        for(Object u : usuarios){
            UsuarioBean user = (UsuarioBean) u;
            if(user.getLogin().equals(usuario.getLogin())){
                if(user.getSenha().equals(usuario.getSenha()))
                    return "logado";
            }else{
                return "senha errada";
            }
        }
        
        return ""+usuarios.indexOf(usuario);
    }    
}
