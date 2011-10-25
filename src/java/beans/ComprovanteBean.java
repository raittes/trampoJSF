package beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="ComprovanteBean")
@SessionScoped
public class ComprovanteBean {
    private long codigo;
    private boolean premiado;

    public ComprovanteBean(){
        premiado=false;        
    }
    public ComprovanteBean(long c){
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
    public String toString(){
        String res = codigo+"";
        
            if(premiado)
                res += " [PREMIADO]";
            else
                res += " [não premiado]";
            
        return res;
    }
}
