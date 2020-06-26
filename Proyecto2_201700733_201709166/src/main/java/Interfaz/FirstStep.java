/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Principal.Inicio.graph;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jacky
 */
public class FirstStep extends javax.swing.JFrame {

    /**
     * Creates new form FirstStep
     */
    public FirstStep() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido a Llega Rapidito");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 270, 39));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Por favor, cargue el archivo de Rutas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 270, 20));

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos txt", "txt");
            chooser.setFileFilter(filter);
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = chooser.showOpenDialog(this);
            File open = chooser.getSelectedFile();

            if (open.exists()) {
                BufferedReader buffer = new BufferedReader(new FileReader(open));
                String cad = buffer.readLine();

                while (cad != null) {
                    String[] rutas = cad.split("%");
                    for (int i = 0; i < rutas.length; i++) {
                        String[] datos = rutas[i].split("/");
                        System.out.println("Lugar Origen " + datos[0]);
                        System.out.println("Lugar Destino " + datos[1]);
                        System.out.println("Tiempo Ruta " + datos[2]);

                        if (datos.length == 3) {
                            datos[0] = datos[0].trim(); //eliminamos espacios en blancos, por si el
                            datos[1] = datos[1].trim(); //archivo viene con espacios en blancos 
                            datos[2] = datos[2].trim(); //como en el enunciado

                            if (graph.getVertex(datos[0]) == null) { //Verificamos si no existe el origen, sino existe
                                graph.insertarVertex(datos[0]);      //lo insertamos   
                            }
                            if (graph.getVertex(datos[1]) == null) { //Verificamos sino existe el destino, sino existe
                                graph.insertarVertex(datos[1]);     //lo metemos
                            }

                            //Si existen los vertices obviamente solo queda meter las aristas
                            graph.insertarEdge(graph.getVertex(datos[0]), graph.getVertex(datos[1]), Integer.parseInt(datos[2]));
                        } else if (datos.length < 3) {
                            System.out.println("No hay datos suficientes para agregar al conductor");
                        } else {
                            System.out.println("Hay más datos de los requeridos, no se puede agregar");
                        }
                    }
                    cad = buffer.readLine();

                }

                buffer.close();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error Al Abrir El Archivo");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error Al Abrir El Archivo: " + ex);
        }

        JOptionPane.showMessageDialog(null, "Carga masiva completada!");
        graph.Mostrar();
        graph.Graficar();
        MenuP principal = new MenuP();
        principal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
