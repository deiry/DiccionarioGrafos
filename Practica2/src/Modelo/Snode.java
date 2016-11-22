package Modelo;

public class Snode {

    private Snode liga;
    private Object dato;

    /**
     * Contructor de la clase Snode
     *
     * @param dato,dato que almacenara el nodo en su campo de dato
     */
    public Snode(Object dato) {

        this.liga = null;
        this.dato = dato;
    }

    /**
     * Metodo que modifica hacia donde apunta el campo de liga del nodo
     *
     * @param liga,nuevo direccion de memomria hacia donde apuntara el nodo
     */
    public void setLiga(Snode liga) {
        this.liga = liga;
    }

    /**
     * Metodo que modifica el campo de dato del nodo
     *
     * @param dato,dato tipo objeto que se alamacenara el campo dato del nodo
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Metodo que retorna la liga del nodo
     *
     * @return objeto tipo Snode
     */
    public Snode getLiga() {
        return liga;
    }

    /*
     * Metodo que retorna dato del nodo
     * @return objeto tipo object 
     */
    public Object getDato() {
        return dato;
    }

}
