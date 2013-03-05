/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author aula
 */
public class Elemento<T> implements Comparable<T> {
    public T valor;
    
    public boolean pertence(Conjunto c){
        for (Elemento e : c.elementos) {
            if(this.equals(e)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean equals(Elemento obj) {
        return this.valor.equals(obj.valor) || obj.toString().equals(this.valor.toString());
    }

	@Override
	protected Object clone() {
		Elemento clone = new Elemento();
		
		clone.valor = valor;
		
		return clone;
	}

	public Elemento() {}

	public Elemento(T valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(T o) {
		if(this.equals(new Elemento<T>(o))){
			return 0;
		}
		
		return this.valor.hashCode() - o.hashCode();
	}
}
