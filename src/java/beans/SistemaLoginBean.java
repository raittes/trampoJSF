package beans;

import beans.UsuarioBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="SistemaLoginBean")
@SessionScoped
public class SistemaLoginBean {
    
    private List usuarios;
    private UsuarioBean usuario;    
         
    public SistemaLoginBean(){
        usuarios = new ArrayList<UsuarioBean>();
        // Usuarios Default
        usuarios.add(new UsuarioBean("admin","admin"));
        usuarios.add(new UsuarioBean("marcos","paulo"));
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
            if(usuario.getLogin().toString().equals(user.getLogin().toString())){
                if(usuario.getSenha().toString().equals(user.getSenha()))
                    return "[logado]";
            }
        }        
        return "Falha no login: "+usuarios.indexOf(usuario);
    }    
}
