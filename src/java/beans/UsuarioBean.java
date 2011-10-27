package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="LoginBean")
@SessionScoped

public class UsuarioBean {
    private String nome;
    private String login;
    private String senha;
    private Long   telefone;
    private List   comprovantes;
    //private long   codigo;
    
    public UsuarioBean(){
    }
    
    public UsuarioBean(String l, String p){
        this.comprovantes = new ArrayList<ComprovanteBean>();
        this.login = l;
        this.senha = p;
    }
    public UsuarioBean(String n, String l, String p, Long t){
        this.comprovantes = new ArrayList<ComprovanteBean>();
        this.login = l;
        this.senha = p;
        this.nome = n;
        this.telefone = t;
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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
        
    public void addCodigoPromocional(Long codigo) {
        this.comprovantes.add(new ComprovanteBean(this,codigo));
    }
    public String toString(){
        return nome+" :: "+login+" : ("+senha+") : "+telefone;
    }   
    public String getResponse(){
        return "lol";
    }
}
