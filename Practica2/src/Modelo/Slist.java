package Modelo;

public class Slist {

    private Snode primero;
    private Snode ultimo;

    /*
     Contructor de la clase Slist
     */
    public void Slist() {
        this.primero = null;
        this.ultimo = null;

    }

    /*
     Metodo que retorna el primer nodo de la lista
     retorna un objeto tipo Snode
     */
    public Snode getPrimero() {
        return primero;
    }

    /**
     * Metodo que retorna el ultimo nodo de la lista
     *
     * @return objeto tipo Snode
     */
    public Snode getUltimo() {
        return ultimo;
    }

    /**
     * Metodo que actualiza el primer nodo de la lista
     *
     * @param primero ,nodo que tomara la posicion del primer nodo de la lista
     */

    public void setPrimero(Snode primero) {
        this.primero = primero;
    }

    /**
     * Metodo que actualiza el ultimo nodo de la lista
     *
     * @param ultimo,nodo que tomra la posicion del ultimo nodo de la lsta
     */
    public void setUltimo(Snode ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Metodo que inserte un nodo despues del otro
     *
     * @param d,nuevo nodo que sera insertado en la lista
     * @param y,nodo previo a donde se insertara el primer parametro
     */
    public void insert(Object d, Snode y) {
        Snode x = new Snode(d);
        connect(x, y);

    }

    /**
     * Metodo que cuenta el numero de nodos que tiene la lista
     *
     * @return,dato tipo entero con el numero de nodos de la lista
     */
    public int numeroNodos() {
        Snode p;
        int cont = 0;
        p = primero;

        while (p != null) {
            cont++;
            p = p.getLiga();
        }

        return cont;

    }

    /**
     * Metodo que imprime los datos que contiene cada nodo de la lista
     */
    public String mostrarLista() {
        Snode p;
        String cad ="";
        p = this.primero;

        while (p != null) {
            cad = cad + p.getDato() +"->";
     
            p = p.getLiga();
        }
        
        return cad;
    }

    /**
     * Metodo que conecta las ligas,cuando se inserta un nuevo nodo
     * @param x,nodo que sera conectado en la lista
     * @param y,nodo previo al cual se conectara el primer parametro
     */
    
    public void connect(Snode x, Snode y) {

        if (y == null)//Insercion al principio
        {
            x.setLiga(primero);
            if (primero == null) {
                primero = x;
                ultimo = x;
            }
            primero = x;
            return;
        }
        if (y.getLiga() == null)//Insercion al final
        {
            y.setLiga(x);
            ultimo = x;
            return;

        } else { //Insercion en la mitad

            x.setLiga(y.getLiga());
            y.setLiga(x);

        }
    }

}
