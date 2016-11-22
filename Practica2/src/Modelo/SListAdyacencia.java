package Modelo;

import java.util.Arrays;
import java.util.Stack;

public class SListAdyacencia {

    private int numeroVertices;
    private Snode v[];
  

    
    /**
     * Contructor de la clase MatrizListaLigadaAdya
     * @param numeroVertices,numero de vertices que tendra el grafo,que representa el numero de posiciones del vector tipo Snode
     */
    public SListAdyacencia(int numeroVertices) {
        this.numeroVertices = numeroVertices;
        this.v = new Snode[numeroVertices];
       

    }
    
    /**
     * Metodo que recupera el numero de vertices que tiene el grafo
     * @return 
     */

    public int getNumeroVertices() {
        return numeroVertices;
    }
    /**
     * Metodo que recupera el vector de tipo Snode,donde se alamacena las correspondientes adyacencias entre vertices
     * @return,vector tipo Snode
     */

    public Snode[] getV() {
        return v;
    }
    
    /**
     * Metodo que modifica el numero de vertices del grafo
     * @param numeroVertices ,numero de vertices del grafo
     */

    public void setNumeroVertices(int numeroVertices) {
        this.numeroVertices = numeroVertices;
    }
    
    /**
     * Metodo que modifica el vector de vertices del grafo
     * @param v,nuevo vector de vertices de grafos
     */

    public void setV(Snode[] v) {
        this.v = v;
    }
    /**
     * Metodo que insertar elemento en la matriz lista ligada de adyacencia
     * @param i,indice del vector de vertices,donde se insertara el vertice j,que es adyacente a este
     * @param j,vertice adyacente al vertice i
     */

    public void insertarAdyacencia(int i, int j) {
        Snode p, x;
        p = v[i];
        x = new Snode(j);
        x.setLiga(p);
        v[i] = x;

    }

  
    /**
     * Metodo que imprime la lista ligada de adyacencia
     * @param vertices,vector de string donde estan los datos recuperado del archivo txt
     */

    public void imprimirMatriz(String vertices[]) {
        Snode p;

        for (int i = 0; i < v.length; i++) {
            p = v[i];
          
            System.out.print("Adyacentes del vertice " + vertices[i] + " Son:\n");

            while (p != null) {
                System.out.print(vertices[(Integer) p.getDato()] + " ");
                p = p.getLiga();
            }
            System.out.println("\n");
        }
    }

    

}
