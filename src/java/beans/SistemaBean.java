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
    //private LoginBean login; 
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
        //login = new LoginBean();  
        
        //CHEATS
        sorteio.getSorteados().add(new Long(1010));
        ((UsuarioBean)usuarios.get(0)).getComprovantes().add(new ComprovanteBean(((UsuarioBean)usuarios.get(0)),new Long (1010)));
        
        
    }

    //public String deslogar(){
    //    // se colocar null, despois q faz logout da pau!
     //   login = new LoginBean();
     //   return "index";
    //} 
    public void cadastrar(String nome, String login, String senha, Long telefone) {
        usuarios.add(new UsuarioBean(nome,login,senha,telefone));
    }   
    
    public UsuarioBean checaLogin(String slogin, String senha){
        for(Object u : usuarios){
            UsuarioBean user = (UsuarioBean) u;
            if(slogin.equals(user.getLogin().toString())){
                if(senha.equals(user.getSenha())){
                    //logou, retorna user
                    return user;                                        
                }
            }
        }        
        //login errado = null
        return null;
    }
    
        
      //////////////////
     // varios erros //
    //////////////////
    
    public List checaUsuario(UsuarioBean u){
        List resultado = new ArrayList<ComprovanteBean>();
              
        for(Object objComprovante : u.getComprovantes()){
            
            for(int i = 0; i<sorteio.getSorteados().size(); i++)
            {
                Long sorteado = (Long) sorteio.getSorteados().get(i);
                Long comprovante = ((ComprovanteBean)objComprovante).getCodigo();
                
                if(comprovante.equals(sorteado)){
                    ((ComprovanteBean)objComprovante).setPremiado(true);
                    resultado.add((ComprovanteBean)objComprovante);
                }                                   
            }                                    
        }        
        
        //login.setResultado(resultado);
        return (ArrayList<ComprovanteBean>) resultado;
        //return "Voce tem: "+resultado.size()+" numeros sorteados!";
    }  
    
    public String checaResultado(LoginBean login){
        // retorna lista de numeros premiados do usuario logado
        login.setResultado(this.checaUsuario(login.getUsuario()));
        return login.getResultado().size()+" numeros premiados: "+login.getResultado();
    }    
    
    
    public void resultadoGeral(){
        // retorna lista de numeros premiados
        List resultado = new ArrayList<ComprovanteBean>();
        List cadaUser = new ArrayList<ComprovanteBean>();
        
        for (Object u : usuarios){
            UsuarioBean user = (UsuarioBean)u;
            for (Object comprovante : this.checaUsuario(user)){
                resultado.add(comprovante);
            }
        }             
        
        this.resultadoGeral = (ArrayList<ComprovanteBean>) resultado;
        //return resultadoGeral;
    }    
    public String validaCodigo(UsuarioBean u, Long codigo){
        //roda a verificacao antes de testar
        this.resultadoGeral();
        /// VALIDA PARA NAO REPETIR OS PREMIADOS
        for(ComprovanteBean comprovante : resultadoGeral){
            if(codigo == comprovante.getCodigo()){
                return null;
            }
        }
        // VALIDA PARA USUARIO NAO REPETIR COMPROVANTES
        for(Object objC : u.getComprovantes()){
            ComprovanteBean comprovante = (ComprovanteBean)objC;
        
            if(codigo == comprovante.getCodigo()){
                return null;
            }
        }
        u.addCodigoPromocional(codigo);
        return "";
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
