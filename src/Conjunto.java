/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import src.Elemento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

    public boolean contem(Conjunto c) {
        boolean contem = false;

        for (Elemento e1 : c.elementos) {
            contem = false;
            for (Elemento e2 : elementos) {
                if (e2.equals(e1)) {
                    contem = true;
                    break;
                }
            }

            if (!contem) {
                return contem;
            }
        }

        return true;
    }

    public boolean igual(Conjunto c) {
        return c.contem(this) && this.contem(c);
    }

    public int cardinalidade() {
        return this.elementos.size();
    }

    public Conjunto uniao(Conjunto c) {
        Conjunto clone = (Conjunto) c.clone();

        for (Elemento e : elementos) {
            if (!e.pertence(clone)) {
                clone.elementos.add(e);
            }
        }

        return clone;
    }

    public Conjunto intersecao(Conjunto c) {
        Conjunto r = new Conjunto();

        for (Elemento e : elementos) {
            if (e.pertence(c)) {
                r.elementos.add(e);
            }
        }

        return r;
    }

    public Conjunto complemento(Conjunto u) {
        Conjunto c = new Conjunto();

        for (Elemento e : u.elementos) {
            if (!e.pertence(this)) {
                c.elementos.add(e);
            }
        }

        return c;
    }

    public Conjunto diferenca(Conjunto c) {
        Conjunto intersecao = this.intersecao(c);
        return intersecao.complemento(this);
    }

    public void zerar() {
        elementos.clear();
    }

    @Override
    protected Object clone() {
        Conjunto clone = new Conjunto();

        for (Elemento e : elementos) {
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

    public Conjunto produtoCartesiano(Conjunto b) {
        Conjunto c = new Conjunto();

        for (Elemento e : elementos) {
            for (Elemento e1 : b.elementos) {
                c.elementos.add(new Elemento(new Tupla(e, e1)));
            }
        }

        return c;
    }

    public boolean isReflexiva() throws NaoEhRelacao {
        HashMap<Integer, HashMap<Integer, Elemento>> map = getMap();
        Conjunto c = new Conjunto();

        for (Map.Entry<Integer, HashMap<Integer, Elemento>> entry : map.entrySet()) {
            Integer i = entry.getKey();
            HashMap<Integer, Elemento> hashMap = entry.getValue();

            if (hashMap.get(i) == null) {
                return false;
            }
        }

        return true;
    }
    
    public boolean isAntiReflexiva() throws NaoEhRelacao {
        HashMap<Integer, HashMap<Integer, Elemento>> map = getMap();
        Conjunto c = new Conjunto();

        for (Map.Entry<Integer, HashMap<Integer, Elemento>> entry : map.entrySet()) {
            Integer i = entry.getKey();
            HashMap<Integer, Elemento> hashMap = entry.getValue();

            if (hashMap.get(i) != null) {
                return false;
            }
        }

        return true;
    }

    public boolean isSimetrica() throws NaoEhRelacao {
        HashMap<Integer, HashMap<Integer, Elemento>> map = getMap();
        Conjunto c = new Conjunto();

        for (Map.Entry<Integer, HashMap<Integer, Elemento>> entry : map.entrySet()) {
            Integer i = entry.getKey();
            HashMap<Integer, Elemento> hashMap = entry.getValue();

            for (Map.Entry<Integer, Elemento> entry1 : hashMap.entrySet()) {
                Integer j = entry1.getKey();
                Elemento elemento = entry1.getValue();

                if (map.get(j) == null || map.get(j).get(i) == null) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public boolean isAssimetrica() throws NaoEhRelacao {
        HashMap<Integer, HashMap<Integer, Elemento>> map = getMap();
        Conjunto c = new Conjunto();

        for (Map.Entry<Integer, HashMap<Integer, Elemento>> entry : map.entrySet()) {
            Integer i = entry.getKey();
            HashMap<Integer, Elemento> hashMap = entry.getValue();

            for (Map.Entry<Integer, Elemento> entry1 : hashMap.entrySet()) {
                Integer j = entry1.getKey();
                Elemento elemento = entry1.getValue();

                if (map.get(j) != null && map.get(j).get(i) != null && i != j) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isTransitiva() throws NaoEhRelacao {
        HashMap<Integer, HashMap<Integer, Elemento>> map = getMap();
        Conjunto c = new Conjunto();

        for (Map.Entry<Integer, HashMap<Integer, Elemento>> entry : map.entrySet()) {
            Integer i = entry.getKey();
            HashMap<Integer, Elemento> hashMap = entry.getValue();

            for (Map.Entry<Integer, Elemento> entry1 : hashMap.entrySet()) {
                Integer j = entry1.getKey();
                Elemento elemento = entry1.getValue();

                for (Map.Entry<Integer, HashMap<Integer, Elemento>> entryK : map.entrySet()) {
                    Integer k = entryK.getKey();
                    HashMap<Integer, Elemento> hashMapK = entryK.getValue();

                    if(map.get(i).get(j) != null && map.get(j) != null && map.get(j).get(k) != null && map.get(i).get(k) == null){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private HashMap<Integer, HashMap<Integer, Elemento>> getMap() throws NaoEhRelacao {
        Conjunto c = new Conjunto();
        HashMap<Integer, HashMap<Integer, Elemento>> map = new HashMap<>();
        Integer i = -1, j = -1;
        for (Elemento e : elementos) {
            try {
                Tupla t = (Tupla) e.valor;
                if (!t.a.pertence(c)) {
                    i = c.elementos.size();
                    c.elementos.add(t.a);
                } else {
                    i = c.elementos.indexOf(t.a);
                }
                if (!t.b.pertence(c)) {
                    j = c.elementos.size();
                    c.elementos.add(t.b);
                } else {
                    j = c.elementos.indexOf(t.b);
                }

                HashMap<Integer, Elemento> submap = new HashMap<>();
                submap.put(j, e);
                map.put(i, submap);
            } catch (Exception ex) {
                throw new NaoEhRelacao("Esta não é uma relação");
            }
        }

        return map;
    }
}
