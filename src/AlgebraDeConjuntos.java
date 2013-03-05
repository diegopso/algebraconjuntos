/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algebradeconjuntos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aula
 */
public class AlgebraDeConjuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Elemento<Integer> e = new Elemento<>(6);
		Elemento<String> e2 = new Elemento<>("Diego");
		Elemento<String> e3 = new Elemento<>("Diego");
		Elemento<String> e4 = new Elemento<>("Gaby");
		
		ArrayList<Elemento> ae = new ArrayList<>();
		ae.add(e);
		ae.add(e2);
		
		ArrayList<Elemento> be = new ArrayList<>();
		be.add(e);
		//be.add(e3);
		//be.add(e4);
		
		Conjunto a = new Conjunto(ae);
		Conjunto b = new Conjunto(be);
		
		a.diferenca(b).imprimir();
    }
}
