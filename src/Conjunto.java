/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import src.Elemento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aula
 */
public class Conjunto {
    public List<Elemento> elementos;

	public Conjunto() {
		elementos = new ArrayList<Elemento>();
	}

	public Conjunto(List<Elemento> elementos) {
		this.elementos = elementos;
	}
    
    public boolean contem(Conjunto c){
        boolean contem = false;
        
        for (Elemento e1 : c.elementos) {
            contem = false;
            for (Elemento e2 : elementos) {
                if(e2.equals(e1)){
                    contem = true;
                    break;
                }
            }
            
            if(!contem){
                return contem;
            }
        }
        
        return true;
    }
	
	public boolean igual(Conjunto c){
        return c.contem(this) && this.contem(c);
	}
	
	public int cardinalidade(){
		return this.elementos.size();
	}
	
	public Conjunto uniao(Conjunto c){
		Conjunto clone = (Conjunto) c.clone();
		
		for(Elemento e : elementos){
			if(!e.pertence(clone))
				clone.elementos.add(e);
		}
		
		return clone;
	}
	
	public Conjunto intersecao(Conjunto c){
		Conjunto r = new Conjunto();
		
		for(Elemento e : elementos){
			if(e.pertence(c))
				r.elementos.add(e);
		}
		
		return r;
	}
	
	public Conjunto complemento(Conjunto u){
		Conjunto c = new Conjunto();
		
		for (Elemento e : u.elementos) {
			if(!e.pertence(this))
				c.elementos.add(e);
		}
		
		return c;
	}
	
	public Conjunto diferenca(Conjunto c){
		Conjunto intersecao = this.intersecao(c);
		return intersecao.complemento(this);
	}
	
	public void zerar(){
		elementos.clear();
	}

	@Override
	protected Object clone() {
		Conjunto clone = new Conjunto();
		
		for(Elemento e : elementos){
			clone.elementos.add(((Elemento) e.clone()));
		}
		
		return clone;
	}

	@Override
	public String toString() {
		String str = "{ ";
		
		for (Elemento e : elementos) {
			str += e.valor + ", ";
		}
		
		str = str.substring(0, str.length() - 2) + " }";
		
		return str;
	}
}
