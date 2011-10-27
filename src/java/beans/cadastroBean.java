package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="cadastroBean")
@RequestScoped
public class cadastroBean {

    private String nome;
    private String login;
    private String senha;    
    private Long   telefone;
    
    public cadastroBean() {
                
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getResponse(){
        if(nome!=null)
            return nome+" cadastrado com sucesso!";
        else
            return "";
    }
    
    
}
