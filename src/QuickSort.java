/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author 88805210
 */
public class QuickSort {

    public Elemento[] elementos;
    private Integer pusicao;

    public QuickSort() {
    }

    public QuickSort(Elemento[] numeros) {
        this.elementos = numeros;
    }

    public void ordenar() throws NaoOrdenavel {
        if (elementos == null || elementos.length == 0) {
            return;
        }
        
        pusicao = elementos.length;
        quicksort(0, pusicao - 1);
    }

    private void quicksort(Integer menor, Integer maior) throws NaoOrdenavel {
        Integer i = menor, j = maior;
        Comparable pivo = (Comparable) elementos[menor + (maior - menor) / 2].valor;

        try {
            while (i <= j) {
                while (pivo.compareTo(elementos[i]) > 0) {
                    i++;
                }

                while (pivo.compareTo(elementos[i]) < 0) {
                    j--;
                }

                if (i <= j) {
                    trocar(i, j);
                    i++;
                    j--;
                }
            }
        } catch (Exception e) {
            throw new NaoOrdenavel("Conjunto não ordenável!");
        }

        if (menor < j) {
            quicksort(menor, j);
        }
        if (i < maior) {
            quicksort(i, maior);
        }
    }

    private void trocar(Integer i, Integer j) {
        Elemento temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
    }
}
