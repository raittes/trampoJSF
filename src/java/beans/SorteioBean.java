package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SorteioBean {
    private List sorteados;
    private Random r;
    
    public SorteioBean(){
       sorteados = new ArrayList<Long>();
       r = new Random();            
    }
    public void sorteie(){
        long sorteado = r.nextInt(9999);
        sorteados.add(sorteado);
    }

    public List getSorteados() {
        return sorteados;
    }
    
    public List checaSorteio(UsuarioBean u){
        List usuario = u.getComprovantes();
        List resultado = new ArrayList();
        
        for(Object a : usuario){
            Long checagem = (Long) this.sorteados.get(this.sorteados.indexOf(a));
            if(checagem!=null){
                resultado.add(checagem);
            }            
                    
        }        
        return resultado;
    }
        
        
        
        
}
