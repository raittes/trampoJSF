package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;


@ManagedBean(name="SorteioBean")
@ApplicationScoped
public class SorteioBean {
    private final List sorteados;
    private Random r;
    
    public SorteioBean(){
       sorteados = new ArrayList<Long>();
       r = new Random();            
    }
    public void sorteie(){
        for(int i =0; i<10; i++){
            long sorteado = r.nextInt(9999);
            this.sorteados.add(sorteado);
        }
    }

    public List getSorteados() {
        return sorteados;
    }
    
    public List checaSorteio(UsuarioBean u){
        List resultado = new ArrayList();
        List comprovantes = u.getComprovantes();        
        
        for(Object objComprovante : comprovantes){
            for(int i = 0; i<sorteados.size(); i++)
            {
                Long sorteado = (Long)sorteados.get(i);
                Long comprovante = ((ComprovanteBean)objComprovante).getCodigo();
                if(sorteado==comprovante){
                    ((ComprovanteBean)objComprovante).setPremiado(true);
                    resultado.add(comprovante);
                }                                   
            }                                    
        }        
        return resultado;
    }           
}
