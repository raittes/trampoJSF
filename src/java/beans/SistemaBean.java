package beans;

import beans.UsuarioBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ApplicationScoped;


@ManagedBean(name="SistemaBean")
@ApplicationScoped
public class SistemaBean {
    
    private List usuarios;
    private LoginBean login; 
    private SorteioBean sorteio;
    private ArrayList<ComprovanteBean> resultadoGeral;
         
    public SistemaBean(){
        usuarios = new ArrayList<UsuarioBean>();
        sorteio = new SorteioBean();     
        // Usuarios Default
        usuarios.add(new UsuarioBean("Administrador","admin","admin",null));
        usuarios.add(new UsuarioBean("Marcos","marcos","paulo",null));
        usuarios.add(new UsuarioBean("Raittes","joao","paulo",null));
        // Usuario da sessao
        login = new LoginBean();                    
    }

    public String deslogar(){
        // se colocar null, despois q faz logout da pau!
        login = new LoginBean();
        return "index";
    } 
    public void cadastrar(String nome, String login, String senha, Long telefone) {
        usuarios.add(new UsuarioBean(nome,login,senha,telefone));
    }   

    public String checaLogin(String slogin, String senha){
        for(Object u : usuarios){
            UsuarioBean user = (UsuarioBean) u;
            if(slogin.equals(user.getLogin().toString())){
                if(senha.equals(user.getSenha())){
                    login.logar(user);
                    return "login";                                        
                }
            }
        }        
        //senao manda pra erro.xhtml
        return "erro";
    }
    
    
    
    
    ////////////////////////  
    
    
    
    public List checaUsuario(UsuarioBean u){
        List resultado = new ArrayList<ComprovanteBean>();
        List comprovantes;
        if(u!=null)
            comprovantes = u.getComprovantes();        
        else
            comprovantes = new ArrayList<ComprovanteBean>();
        
        
        for(Object objComprovante : comprovantes){
            for(int i = 0; i<sorteio.getSorteados().size(); i++)
            {
                Long sorteado = (Long)sorteio.getSorteados().get(i);
                Long comprovante = ((ComprovanteBean)objComprovante).getCodigo();
                if(sorteado==comprovante){
                    ((ComprovanteBean)objComprovante).setPremiado(true);
                    resultado.add(comprovante);
                }                                   
            }                                    
        }        
        login.setResultado(resultado);
        return (ArrayList<ComprovanteBean>) resultado;
    }  
    
       
    
    
    public String checaResultado(){
        // retorna lista de numeros premiados
        //return sorteio.checaUsuario(login.getUsuario());
        login.setResultado(this.checaUsuario(login.getUsuario()));
        return login.getResultado().size()+" numeros premiados!";
    }    
    public void resultadoGeral(){
        // retorna lista de numeros premiados
        List resultado = new ArrayList<ComprovanteBean>();
        List cadaUser = new ArrayList<ComprovanteBean>();
        
        for (Object u : usuarios){
            UsuarioBean user = (UsuarioBean)u;
            cadaUser = this.checaUsuario(user);
            for (Object lista : cadaUser){
                lista = (Long) lista;
                resultado.add(lista);
            }
        }             
        //return (ArrayList<ComprovanteBean>) resultado;
        this.resultadoGeral = (ArrayList<ComprovanteBean>) resultado;
    }    
    public LoginBean getLogin() {
        return login;
    }
    public void setLogin(LoginBean login) {
        this.login = login;
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

    public ArrayList<ComprovanteBean> getResultadoGeral() {
        return resultadoGeral;
    }

    public void setResultadoGeral(ArrayList<ComprovanteBean> resultadoGeral) {
        this.resultadoGeral = resultadoGeral;
    }
    
}
