/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Grafo;
import Modelo.Lado;
import Modelo.SListAdyacencia;
import Modelo.Slist;
import Modelo.Snode;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.PickableVertexPaintTransformer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.ArrayList;
import org.apache.commons.collections15.Transformer;

/**
 * Clase que se encargar de dibujar el grafo para cargarlo en el panel que sea
 * llamado
 *
 * @author Deiry
 */
public class DrawGraph {

    /**
     * Grafo con los vertices y aristas que fueron asignados
     */
    private Graph<String, String> g;
    /**
     * Objeto de clase creada por nosotros donde contiene toda la informacion
     * sobre su adyacencia y recorridos
     */
    private Grafo grafo;
    /**
     * Los vertices existentes en el grafo
     */
    private String[] vertices;
    /**
     * Vector para validar de que ya fue creada las aristas correspondientes
     */
    private int[] visitado;
    /**
     * Objeto para realizar las modificaciones graficas a las aristas
     */
    private Transformer<String, Paint> edgeTransformer;

    /**
     * Objeto que contiene toda la informacion sobre como se va representar el
     * grafo, su color, y aspecto
     */
    private BasicVisualizationServer<Integer, String> vv;

    /**
     * Objeto que de acuerdo a la lista ligada de adyacencia se crea los lados
     * para pintar
     */
    private ArrayList<Lado> lados;
    /**
     * Contiene las aristas correspondientes para pintar la trayectoria
     * seleccionada
     */
    private ArrayList<Slist> aristaReco;
    /**
     * Lista auxiliar para guardar una trayectoria
     */
    private Slist aux;
    /**
     * Nodo auxiliar para la lista
     */
    private Snode p;
    /**
     * Contador de las aristas que contiene la trayectoria
     */
    private int contAristas;

    /**
     * Constructor que se inicializa con el grafo
     *
     * @param grafo Objeto tipo grafo
     */
    public DrawGraph(Grafo grafo) {
        this.contAristas = 0;
        this.grafo = grafo;
        this.lados = new ArrayList<Lado>();
        // Graph<V, E> where V is the type of the vertices and E is the type of the edges
        g = new SparseMultigraph<String, String>();
        this.vertices = grafo.getVertice();
        initVertices(vertices);
        visitado = new int[vertices.length];
        initAristas(grafo.getmad());
        edgeTransformer = new Transformer<String, Paint>() {
            @Override
            public Paint transform(String i) {
                return Color.black;
            }
        };
        // vertexPaint = new PickableVertexPaintTransformer(vv.getPickedVertexState(), Color.green, Color.yellow);

    }

    /**
     * Metodo para mostrar el grafo actual de acuerdo a los cambios que se hayan
     * hecho para pintar
     *
     * @return Objeto que contiene le grafo para que se pueda añadir al panel de
     * la vista
     */
    public BasicVisualizationServer showGraph() {

        Layout<Integer, String> layout = new CircleLayout(g);
        layout.setSize(new Dimension(300, 300));
        vv = new BasicVisualizationServer<Integer, String>(layout);
        vv.setPreferredSize(new Dimension(100, 100));
        vv.getRenderContext().setEdgeDrawPaintTransformer(edgeTransformer);
        vv.getRenderContext().setVertexFillPaintTransformer(new PickableVertexPaintTransformer(vv.getPickedVertexState(), elegirColor(), Color.yellow));
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.setBackground(Color.gray);
        return vv;
    }

    /**
     * Metodo que inicializa los vertices de acuerdo al grafo
     *
     * @param vertices Vector que contiene todos los vertices del grafo
     */
    public final void initVertices(String[] vertices) {

        for (int i = 0; i < vertices.length; i++) {
            g.addVertex(vertices[i]);
        }
    }

    /**
     * Inicializa el grafo nuevamente para mostrar las nuevas trayectorias
     */
    public void initGrafo() {
        g = new SparseMultigraph<String, String>();
        this.vertices = grafo.getVertice();
        initVertices(vertices);
    }

    /**
     * Metodo que dibuja los recorridos de acuerdo a la lista que contiene los
     * vertices adyacentes
     *
     * @param ruta Lista que contiene la ruta con los vertices adyacentes
     */
    public void drawRecorridos(final Slist ruta) {

        initGrafo();
        contAristas = 0;
        Snode p, q;
        p = ruta.getPrimero();
        q = p.getLiga();
        while (q != null) {
            addEdge((String) p.getDato(), (String) q.getDato());
            p = q;
            q = q.getLiga();
        }
        pintarAristas();
    }

    /**
     * Añadir arista de acuerdo a los vertices adyacentes a la trayectoria
     *
     * @param v1 Vertice 1 adyacente al vertice 2
     *
     * @param v2 Vertice 2 adyacente al vertice 3
     */
    public void addEdge(String v1, String v2) {
        g.addEdge("" + contAristas, v1, v2);
        contAristas++;
    }

    /**
     * Metodo que asigna el color a la arista con la lista del recorrido
     *
     * @param i Arista que se verifica si pertenece a la trayectoria
     * @param pos Posicion del arraylist que se hará la verificacion
     * @return Color en el que se pintará la trayectoria
     */
    public Color pintarRuta(String i, int pos, ArrayList<Slist> reco) {

        aux = reco.get(pos);
        p = aux.getPrimero();
        while (p != null) {
            if (i.equals((p.getDato()).toString())) {
                return Color.yellow;
            }
            p = p.getLiga();
        }

        return Color.black;
    }

    /**
     * Pinta las aristas que hay en el grafo con un color aleatorio
     */
    public void pintarAristas() {
        final Color colorArista = elegirColor();
        edgeTransformer = new Transformer<String, Paint>() {
            @Override
            public Paint transform(String i) {
                return colorArista;
            }
        };
    }

    /**
     * Metodo que crea un color aleatoriamente con el fin de que no se vea
     * repetido en el grafo
     *
     * @return Color creado
     */
    public Color elegirColor() {
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        Color color = new Color(R, G, B);
        return color;
    }

    public void imprimir(ArrayList<Slist> reco) {
        Slist lista;
        Snode p;
        for (int i = 0; i < reco.size(); i++) {
            lista = reco.get(i);
            p = lista.getPrimero();
            while (p != null) {
                System.out.print(p.getDato() + "-->");
                p = p.getLiga();
            }
            System.out.println("");
        }
    }

    /**
     * Pintar vertices de origen y destino para efectos de visualizacion
     *
     * @param v1 Vertice de origen que fue seleccionado
     * @param v2 Vertice de destino que fue seleccionado
     */
    public void pintarOrigenDesitno(final String v1, final String v2) {
        System.out.println("entro origen");

    }

    /**
     * Imprimir lado para efectos de verificar por consola
     */
    public void imprimirLados() {
        for (int i = 0; i < lados.size(); i++) {
            lados.get(i).mostrar();
        }
    }

    /**
     * Metodo para inicializar las aristas de a su adyacencia
     *
     * @param ady Lista Ligada de adyacencia para realizar los lados en el grafo
     */
    public void initAristas(SListAdyacencia ady) {
        Snode v[] = ady.getV();
        Snode p;
        int dato, cont = 0;
        String nameV, nameDato;

        for (int i = 0; i < v.length; i++) {
            p = v[i];
            nameV = vertices[i];

            while (p != null) {
                dato = (Integer) p.getDato();
                nameDato = vertices[dato];
                if (visitado[dato] != 1) {
                    //System.out.println("Arista " + nameV + " " + nameDato);
                    g.addEdge("" + cont, vertices[i], vertices[dato]);
                    lados.add(cont, new Lado(vertices[i], vertices[dato], cont));
                    cont++;
                }
                p = p.getLiga();

            }
            visitado[i] = 1;
        }
    }

    public Graph<String, String> getG() {
        return g;
    }

    public void setG(Graph<String, String> g) {
        this.g = g;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public int getContRecorridos() {
        return contAristas;
    }

    public void setContRecorridos(int contRecorridos) {
        this.contAristas = contRecorridos;
    }

}
