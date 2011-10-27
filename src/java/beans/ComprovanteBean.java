package beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="ComprovanteBean")
@SessionScoped
public class ComprovanteBean {
    private long codigo;
    private boolean premiado;
    private UsuarioBean dono;

    public ComprovanteBean(){
        premiado=false;        
    }
    public ComprovanteBean(UsuarioBean dono,long c){
        this.dono = dono;
        this.codigo=c;
        premiado=false;        
    }
    public long getCodigo(){
        return this.codigo;
    }    

    public boolean isPremiado() {
        return premiado;
    }

    public void setPremiado(boolean premiado) {
        this.premiado = premiado;
    }

    public UsuarioBean getDono() {
        return dono;
    }

    public void setDono(UsuarioBean dono) {
        this.dono = dono;
    }
    
    public String toString(){
        String res = codigo+"";
        
            if(premiado)
                res += " [PREMIADO]";
            else
                res += " [não]";
            
        return res;
    }
}
