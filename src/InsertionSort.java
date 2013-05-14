/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author 88805210
 */
public class InsertionSort {

    public Elemento[] elementos;

    public InsertionSort() {
    }

    public InsertionSort(Elemento[] e) {
        this.elementos = e;
    }

    public void ordenar() throws NaoOrdenavel {
        try {
            for (int i = 0; i < elementos.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (elementos[j - 1].compareTo(elementos[j]) > 0) {
                        trocar(j - 1, j);
                    }
                }
            }
        } catch (Exception e) {
            throw new NaoOrdenavel("Conjunto não ordenável!");
        }
    }

    private void trocar(Integer i, Integer j) {
        Elemento temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
    }
}
