/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Grafo;
import Modelo.Slist;
import Modelo.CargaArchivo;
import Vista.DrawGraph;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DEIRY
 */
public class Controller implements ActionListener {

    /**
     * Objeto de la vista principal
     */
    private VistaPrincipal view;
    /**
     * Objeto que se encarga de gestionar los archivos para cargar la interfaz
     */
    private CargaArchivo model;
    /**
     * Grafo que contiene todas la informacion sobre vertices, aristas y
     * trayectorias
     */
    private Grafo x;
    /**
     * Vertices de los String que se cargo en el archivo plano
     */
    private String vecvertices[];
    /**
     * Objeto encargado de graficar el grafo
     */
    private DrawGraph grafoView;
    /**
     * Guarda todas las trayectorias segun la opcion seleccionada
     */
    private ArrayList<Slist> todasReco;
    /**
     * Contador para mostrar los diferentes recorridos
     */

    private int contTodosReco;

    /**
     * Constructor del controlador que recibe la vista principal donde se
     * mostrarán los grafos
     *
     * @param view Vista principal para ver el grafo
     * @param model Clase para manejar los archivos
     */
    public Controller(VistaPrincipal view, CargaArchivo model) {
        this.view = view;
        this.model = model;
        ;
        this.contTodosReco = 0;
    }

    /**
     * Inicializar los atributos del objeto vista para identicar cuando hay un
     * evento
     */
    public void initAtributos() {
        this.view.getExaminaArchivo().setActionCommand("ExaminarArchivo");
        this.view.getExaminaArchivo().addActionListener(this);

        this.view.getOrigenMenoresTrayectorias().setActionCommand("OrigenMenoresTrayectoria");
        this.view.getOrigenMenoresTrayectorias().addActionListener(this);

        this.view.getDestinoMenoresTrayectorias().setActionCommand("DestinoMenoresTrayectorias");
        this.view.getDestinoMenoresTrayectorias().addActionListener(this);

        this.view.getOrigenMenoresTrayectorias().setActionCommand("OrigenTodasTrayectorias");
        this.view.getOrigenMenoresTrayectorias().addActionListener(this);

        this.view.getCargarMenoresTrayectorias().setActionCommand("GeneraMenoresTrayectorias");
        this.view.getCargarMenoresTrayectorias().addActionListener(this);

        this.view.getCargaTodasTrayectorias().setActionCommand("GeneraTodasTrayectorias");
        this.view.getCargaTodasTrayectorias().addActionListener(this);

        this.view.getSiguienteTrayectoria().setActionCommand("SiguienteTrayectoria");
        this.view.getSiguienteTrayectoria().addActionListener(this);
    }

    /**
     * Metodo que contiene el objeto donde se realizó algun evento en la
     * interfaz
     *
     * @param e Objeto accionado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("ExaminarArchivo")) {
            JOptionPane.showMessageDialog(null, "Examinando Archivo..");
            model.cargaInterfaz(this.view);
            vecvertices = model.cargaVertices(this.view.getAreaCadena().getText());//Carga el vector de vertices

            x = new Grafo(vecvertices);
            x.verificadaAdayacencia();

            this.grafoView = new DrawGraph(x);
            view.getAreaGrafo().add(grafoView.showGraph());

            model.cargarCombox(vecvertices, view);

            if (model.getFichero() == null) {

                this.view.getArchivoCargado().setText("Archivo No cargado");
            } else {
                this.view.getArchivoCargado().setText("");
                this.view.getArchivoCargado().setText(model.getFichero().getAbsolutePath());
            }

        }

        if (comando.equals("GeneraMenoresTrayectorias")) {

            JOptionPane.showMessageDialog(null, "cargando Menores Trayectorias");
            if (this.view.getOrigenMenoresTrayectorias().getSelectedIndex() != 0 && this.view.getDestinoMenoresTrayectorias().getSelectedIndex() != 0) {
                contTodosReco = 0;

                int origen = this.view.getOrigenMenoresTrayectorias().getSelectedIndex();
                int destino = this.view.getDestinoMenoresTrayectorias().getSelectedIndex();

                x.incializarVectores();
                x.setOrigen(origen);
                todasReco = x.hacerTrayectorias(origen, destino);
                todasReco = x.hallaMenoresCaminos(destino);
                view.getAreaCadena().setText("Menores trayectorias:" + x.getTamamenor() + "\n");
                mostrarArrray(todasReco);
                view.getGrafoPrincipal().add(grafoView.showGraph());
                grafoView.drawRecorridos(todasReco.get(0));
                cleanPanel(view.getAreaGrafo());
                view.getAreaGrafo().add(grafoView.showGraph());

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar los puntos incio y destino");
            }
        }

        if (comando.equals("GeneraTodasTrayectorias")) {

            JOptionPane.showMessageDialog(null, "cargando Todas Trayectorias");
            if (this.view.getOrigenMenoresTrayectorias().getSelectedIndex() != 0 & this.view.getDestinoMenoresTrayectorias().getSelectedIndex() != 0) {
                contTodosReco = 0;

                int origen = this.view.getOrigenMenoresTrayectorias().getSelectedIndex();
                int destino = this.view.getDestinoMenoresTrayectorias().getSelectedIndex();

                x.incializarVectores();
                x.setOrigen(origen);
                todasReco = x.hacerTrayectorias(origen, destino);
                view.getAreaCadena().setText("Todas trayectorias \n");
                this.mostrarArrray(todasReco);

                view.getGrafoPrincipal().add(grafoView.showGraph());
                grafoView.drawRecorridos(todasReco.get(0));
                cleanPanel(view.getAreaGrafo());
                view.getAreaGrafo().add(grafoView.showGraph());

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar los puntos incio y destino");
            }

        }

        if (comando.equals("SiguienteTrayectoria")) {
            contTodosReco++;
            if (contTodosReco >= todasReco.size()) {
                JOptionPane.showMessageDialog(null, "Ya no hay mas trayectorias");
            } else {
                grafoView.drawRecorridos(todasReco.get(contTodosReco));
                cleanPanel(view.getAreaGrafo());
                view.getAreaGrafo().add(grafoView.showGraph());
            }
        }
    }

    /**
     * Muestra por consola el ArrayList ya sea de todas o las menores
     * trayectorias
     *
     * @param todasReco Contiene las trayectorias a mostrar
     */
    public void mostrarArrray(ArrayList<Slist> todasReco) {
        String mostrar = "";
        for (int i = 0; i < todasReco.size(); i++) {
            mostrar = todasReco.get(i).mostrarLista() + "\n";
            view.getAreaCadena().append(mostrar);
        }
    }

    /**
     * Metodo que muestra el Jframe
     */
    public void mostrar() {

        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    


    }

    /**
     * limpia un panel JPanel para posteriormente dibujar el panel que se
     * necesita
     *
     * @param jp panel que se va limpiar
     */
    public void cleanPanel(JPanel jp) {
        jp.removeAll();
        jp.repaint();
        jp.revalidate();
    }

    /**
     * agregar el panel que se va usar jp en el panel de trabajo
     *
     * @param jp es el panel que se va agregar en el panel JpOri
     */
    public void setPanel(JPanel jp, JPanel jpOri) {
        jpOri.add(jp);
        jpOri.repaint();
        jpOri.revalidate();
    }
}
