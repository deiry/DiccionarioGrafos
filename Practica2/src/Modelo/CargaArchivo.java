package Modelo;

import Vista.FormularioPrincipal;
import Vista.VistaPrincipal;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.Stack;
import java.util.StringTokenizer;

public class CargaArchivo {

    private JFileChooser fc;
    private File fichero;
    

    /**
     * contructor de la clase modelo;
     */
    public CargaArchivo() {

        this.fc = new JFileChooser();
        this.fichero = null;

    }
    
    /**
     * Metodo que retorna un objeto tipo JFileChooser
     * @return objeto tipo JFileChooser
     */

    public JFileChooser getFileChooser() {
        return fc;
    }

    public JFileChooser getFc() {
        return fc;
    }

    /**
     * Metodo que retorna un objeto tipo File
     * @return objeto tipo File
     */
    public File getFichero() {
        return fichero;
    }

    
    /**
     * Meotodo que modifica un objeto tipo JFileChooser
     * @param fc,objeto tipo JFileChooser
     */
    public void setFc(JFileChooser fc) {
        this.fc = fc;
    }
    /**
     * Metodo que modifica un objeto tipo File
     * @param fichero,objeto tipo File
     */

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    
    /**
     * Metodo que permite cargar en la interfaz en panel para examinar el archivo txt
     * @param view,objeto tipo FormularioPrincipal
     */
    public void cargaInterfaz(VistaPrincipal view) {
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setDialogTitle("Examinar Archivo");
        int result = fc.showSaveDialog(null);
        String aux = "";

        if (result == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Cargo Archivo");
            this.fichero = fc.getSelectedFile();

            try (FileReader fr = new FileReader(fichero)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena = cadena + (char) valor;
                    valor = fr.read();

                }

                view.getAreaCadena().setText(cadena);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No cargo ningun archivo");

        }

    }
    
    /**
     * Metodo que carga un vector tipo String con los datos capturado de archivo txt
     * @param cadena,String objetinodo de campo Area de texto del diccionario contruido apartir del txt
     * @return,un vector de String 
     */

    public String[] cargaVertices(String cadena) {
        String dato[];
        int conta = 0;
        dato = cadena.split("/n");
        StringTokenizer st = new StringTokenizer(cadena);
        //sSystem.out.println(st.countTokens());
        dato = new String[st.countTokens()];
        int k = 0;
        while (st.hasMoreElements()) {
            //System.out.println(st.nextElement().toString());
            dato[k] = st.nextElement().toString();
            k++;
        }

        return dato;

    }

    
    /**
     * Metodo que carga en los combobox los datos que existen un vector
     * @param dato,vector de string que tiene la informacion a cargar en los combobox
     * @param view,interfaz tipo FormularioPrincipal
     */
    public void cargarCombox(String dato[], VistaPrincipal view) {
        for (int i = 0; i < dato.length; i++) {
            view.getDestinoMenoresTrayectorias().addItem(dato[i]);
            //view.getdestinoTodasTrayectorias().addItem(dato[i]);
            view.getOrigenMenoresTrayectorias().addItem(dato[i]);
          //  view.getdestinoTodasTrayectorias().addItem(dato[i]);
         //   view.getorigenTodasTrayectorias().addItem(dato[i]);

        }

    }

}
