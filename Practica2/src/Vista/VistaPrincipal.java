/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author DEIRY
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        grafoPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ExaminaArchivo = new javax.swing.JButton();
        areaGrafo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaCadena = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        origenMenoresTrayectorias = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        destinoMenoresTrayectorias = new javax.swing.JComboBox<>();
        cargaTodasTrayectorias = new javax.swing.JButton();
        cargarMenoresTrayectorias = new javax.swing.JButton();
        siguienteTrayectoria = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        archivoCargado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N
        jLabel1.setText("DICCIONARIO GRAFO");

        grafoPrincipal.setBackground(new java.awt.Color(153, 153, 153));
        grafoPrincipal.setLayout(new java.awt.CardLayout());

        jLabel2.setText("Grafo principal");

        ExaminaArchivo.setBackground(new java.awt.Color(204, 255, 204));
        ExaminaArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/add.png"))); // NOI18N
        ExaminaArchivo.setToolTipText("");
        ExaminaArchivo.setBorder(null);

        areaGrafo.setBackground(new java.awt.Color(153, 153, 153));
        areaGrafo.setLayout(new java.awt.CardLayout());

        areaCadena.setEditable(false);
        areaCadena.setColumns(20);
        areaCadena.setRows(5);
        jScrollPane1.setViewportView(areaCadena);

        jLabel3.setText("Cadenas Archivo");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Calcular trayectorias");

        jLabel5.setText("Origen");

        jLabel6.setText("Destino");

        cargaTodasTrayectorias.setBackground(new java.awt.Color(204, 255, 204));
        cargaTodasTrayectorias.setText("Todas Trayectorias");

        cargarMenoresTrayectorias.setBackground(new java.awt.Color(204, 255, 204));
        cargarMenoresTrayectorias.setText("Menores Trayectorias");

        siguienteTrayectoria.setBackground(new java.awt.Color(255, 255, 255));
        siguienteTrayectoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/next_1.png"))); // NOI18N
        siguienteTrayectoria.setBorder(null);
        siguienteTrayectoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteTrayectoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(origenMenoresTrayectorias, 0, 116, Short.MAX_VALUE)
                    .addComponent(destinoMenoresTrayectorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(siguienteTrayectoria)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cargaTodasTrayectorias)
                            .addComponent(cargarMenoresTrayectorias))
                        .addContainerGap(84, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(origenMenoresTrayectorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cargaTodasTrayectorias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cargarMenoresTrayectorias)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(destinoMenoresTrayectorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(siguienteTrayectoria))
                .addGap(13, 13, 13))
        );

        jLabel7.setText("Secuencia grafo");

        archivoCargado.setText("Ruta Archivo");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tutorial_1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel9)
                                .addGap(148, 148, 148)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(244, 244, 244)))
                        .addComponent(ExaminaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(archivoCargado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(areaGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(grafoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ExaminaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(areaGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(grafoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(archivoCargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteTrayectoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteTrayectoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siguienteTrayectoriaActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExaminaArchivo;
    private javax.swing.JTextField archivoCargado;
    private javax.swing.JTextArea areaCadena;
    private javax.swing.JPanel areaGrafo;
    private javax.swing.JButton cargaTodasTrayectorias;
    private javax.swing.JButton cargarMenoresTrayectorias;
    private javax.swing.JComboBox<String> destinoMenoresTrayectorias;
    private javax.swing.JPanel grafoPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> origenMenoresTrayectorias;
    private javax.swing.JButton siguienteTrayectoria;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getExaminaArchivo() {
        return ExaminaArchivo;
    }

    public void setExaminaArchivo(javax.swing.JButton ExaminaArchivo) {
        this.ExaminaArchivo = ExaminaArchivo;
    }

    public javax.swing.JTextArea getAreaCadena() {
        return areaCadena;
    }

    public void setAreaCadena(javax.swing.JTextArea areaCadena) {
        this.areaCadena = areaCadena;
    }

    public javax.swing.JPanel getAreaGrafo() {
        return areaGrafo;
    }

    public void setAreaGrafo(javax.swing.JPanel areaGrafo) {
        this.areaGrafo = areaGrafo;
    }

    public javax.swing.JButton getCargaTodasTrayectorias() {
        return cargaTodasTrayectorias;
    }

    public void setCargaTodasTrayectorias(javax.swing.JButton cargaTodasTrayectorias) {
        this.cargaTodasTrayectorias = cargaTodasTrayectorias;
    }

    public javax.swing.JButton getCargarMenoresTrayectorias() {
        return cargarMenoresTrayectorias;
    }

    public void setCargarMenoresTrayectorias(javax.swing.JButton cargarMenoresTrayectorias) {
        this.cargarMenoresTrayectorias = cargarMenoresTrayectorias;
    }

    public javax.swing.JComboBox<String> getDestinoMenoresTrayectorias() {
        return destinoMenoresTrayectorias;
    }

    public void setDestinoMenoresTrayectorias(javax.swing.JComboBox<String> destinoMenoresTrayectorias) {
        this.destinoMenoresTrayectorias = destinoMenoresTrayectorias;
    }

    public javax.swing.JComboBox<String> getOrigenMenoresTrayectorias() {
        return origenMenoresTrayectorias;
    }

    public void setOrigenMenoresTrayectorias(javax.swing.JComboBox<String> origenMenoresTrayectorias) {
        this.origenMenoresTrayectorias = origenMenoresTrayectorias;
    }

    public javax.swing.JButton getSiguienteTrayectoria() {
        return siguienteTrayectoria;
    }

    public void setSiguienteTrayectoria(javax.swing.JButton siguienteTrayectoria) {
        this.siguienteTrayectoria = siguienteTrayectoria;
    }

    public javax.swing.JTextField getArchivoCargado() {
        return archivoCargado;
    }

    public void setArchivoCargado(javax.swing.JTextField archivoCargado) {
        this.archivoCargado = archivoCargado;
    }

    public javax.swing.JPanel getGrafoPrincipal() {
        return grafoPrincipal;
    }

    public void setGrafoPrincipal(javax.swing.JPanel grafoPrincipal) {
        this.grafoPrincipal = grafoPrincipal;
    }
}
