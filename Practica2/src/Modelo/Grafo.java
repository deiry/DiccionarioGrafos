package Modelo;

import cern.colt.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class Grafo {

    private SListAdyacencia mad;
    private String vertices[];
    private int vistado[];
    private int kl;
    private int cola[];
    private ArrayList<Slist> aux;
    private ArrayList<Slist> meno;
    private int llamados;
    private Slist vlist[];
    private int tamamenor;
    private int origen, destino;

    /**
     * Constructor de la clase Grafo
     *
     * @param x,numero de vertices que tendra el grafo
     */
    public Grafo(String[] x) {
        this.vertices = x;
        this.mad = new SListAdyacencia(this.vertices.length);
        vistado = new int[this.vertices.length];
        this.kl = 0;
        this.cola = new int[this.vertices.length];
        this.incializarVectores();
        this.llamados = 0;
        this.aux = new ArrayList<Slist>();
        this.meno = new ArrayList<Slist>();
        this.tamamenor = 0;
    }

    /**
     * Metodo que recupera la lista ligada de adyacencia del grafo
     *
     * @return objeto tip SListAdyacencia
     */
    public SListAdyacencia getmad() {
        return mad;
    }

    /**
     * Metodo que retorna el valor del atributo llamado,
     *
     * @return,entero
     */
    public int getllamados() {
        return llamados;
    }

    /**
     * Metodo que retorna el vector de vertices
     *
     * @return,vector de String
     */
    public String[] getVertice() {
        return this.vertices;
    }

    /**
     * Metodo que evalua la adyancia entre vertices segun la informacion que
     * posee cada nodo
     */
    public void verificadaAdayacencia() {
        String cadena1 = "";
        String cadena2 = "";
        Slist l1 = null;
        Slist l2 = null;
        Snode p, q;
        char v1;
        char v2;
        int contador = 0;

        for (int i = 0; i < vertices.length; i++) {
            cadena1 = vertices[i];

            for (int j = 0; j < vertices.length; j++) {
                cadena2 = vertices[j];
                l1 = creaLista(cadena1);
                l2 = creaLista(cadena2);
                p = l1.getPrimero();
                q = l2.getPrimero();

                while (p != null || q != null) {
                    if (p == null) {
                        v1 = (char) l1.getUltimo().getDato();
                    } else {
                        v1 = (char) p.getDato();
                        p = p.getLiga();
                    }

                    if (q == null) {
                        v2 = (char) l2.getUltimo().getDato();
                    } else {
                        v2 = (char) q.getDato();
                        q = q.getLiga();
                    }

                    if (v1 != v2) {
                        contador++;
                    }

                }

                if (contador == 1) {
                    mad.insertarAdyacencia(i, j);
                }
                contador = 0;
            }
        }

    }

    /**
     * Metodo que incializa los Arraylist y datos que controlan las trayectorias
     * de un vertice a otro.
     */
    public void incializarVectores() {

        this.llamados = 0;
        this.kl = 0;
        this.aux = new ArrayList<Slist>();
        this.meno = new ArrayList<Slist>();
        this.tamamenor = 0;

        for (int i = 0; i < this.vertices.length; i++) {
            vistado[i] = 0;
            cola[i] = 0;
        }
    }

    /**
     * Metodo que imprime los vertices adayacentes al grafo
     */
    public void imprimirVerticesAdy() {

        mad.imprimirMatriz(vertices);
    }

    /**
     * Metodo que cree una lista
     *
     * @param x,string que contiene cada uno de los componentes de la lista
     * @return,retorna un objeto tipo Slist
     */
    public Slist creaLista(String x) {

        Slist lista = new Slist();
        Snode p;
        for (int i = 0; i < x.length(); i++) {
            p = new Snode(x.charAt(i));
            lista.connect(p, lista.getUltimo());
        }

        return lista;

    }

    /**
     * Metodo que determina todas las trayectorias para ir de vertice x al
     * vertice y
     *
     * @param x,vertice partdia
     * @param y ,vertice destino
     */
    public ArrayList hacerTrayectorias(int x, int y) {
        Snode p;

        if (x == y) {
            //cola[kl] = x;
            Slist lista = new Slist();
             Snode origenNode = new Snode(vertices[getOrigen()]);
            lista.connect(origenNode, lista.getUltimo());
            this.agregarTrayectoria(y, lista);

        } else {
            if (vistado[x] == 0) {

                vistado[x] = 1;
                cola[kl] = x;
                p = mad.getV()[x];
                kl++;
                while (p != null) {
                    hacerTrayectorias((Integer) p.getDato(), y);
                    p = p.getLiga();
                }

                vistado[x] = 0;

                kl--;

            }
        }
        return aux;
    }

    /**
     * Metodo que imprime el vector que almacena los vertices acumulados durante
     * la trayectoria
     */
    public void agregarTrayectoria(int y, Slist x) {
        this.llamados++;
        Snode p;

        for (int j = 0; j < kl; j++) {
            p = new Snode((String) vertices[cola[j]]);
            x.connect(p, x.getUltimo());

        }
        p = new Snode((String) vertices[y]);
        x.connect(p, x.getUltimo());
        aux.add(x);

    }

    /**
     * Metodo que determina el menor recorrido para llegar al vertice destino
     *
     * @param destino ,vertice al cul se quiere llegar
     */
    public ArrayList hallaMenoresCaminos(int destino) {

        Slist lista;
        String menorCad = "";
        int c = 0;
        int l = 0;
        this.vlist = new Slist[aux.size()];
        int menor = 0;
        int tama = aux.size();
        //int tamamenor=0;

        for (int k = 0; k < tama; k++) {

            lista = aux.get(k);
            if (menor == 0) {
                menor = lista.numeroNodos();
                meno.add(lista);
                tamamenor++;
            } else {
                if (lista.numeroNodos() < menor) {
                    borraExistencias(menor);
                    menor = lista.numeroNodos();
                    meno.add(lista);
                    tamamenor++;
                } else if (lista.numeroNodos() == menor) {
                    meno.add(lista);
                    tamamenor++;
                }

            }

        }

      
     
        return meno;

    }
    
    

    /**
     * Metodo que elimina los datos que no cumple con la menor dimsension de la
     * lista para los menores recorridos
     *
     * @param size ,dato tipo entero con el tamaño que con anterioridad era el
     * menor
     */
    public void borraExistencias(int size) {
        int indice = 0;
        Slist lista = null;
        //int tama=meno.size();
        while (indice < meno.size()) {
            lista = meno.get(indice);
            if (lista.numeroNodos() == size) {

                meno.remove(indice);
                //meno.remove(lista);

                tamamenor--;
                indice = 0;
            } else {
                indice++;
            }

        }

    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getTamamenor() {
        return tamamenor;
    }

    public void setTamamenor(int tamamenor) {
        this.tamamenor = tamamenor;
    }

}
