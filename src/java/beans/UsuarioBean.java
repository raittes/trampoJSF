package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="UsuarioBean")
@SessionScoped

public class UsuarioBean {
    private String login;
    private String senha;
    private String nome;
    private List   comprovantes;
    
    public UsuarioBean(String l, String p){
        this.login = l;
        this.senha = p;        
    }

    public List getComprovantes() {
        return comprovantes;
    }

    public void setComprovantes(List Comprovantes) {
        this.comprovantes = Comprovantes;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    
    public void addCodigoPromocional(long x) {
        this.comprovantes.add(new ComprovanteBean(x));
    }
    public String getResponse(){
        
        
        return "jesus";
    }
}
