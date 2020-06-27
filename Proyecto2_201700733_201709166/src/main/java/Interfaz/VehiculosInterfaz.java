/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Principal.Inicio;
import Principal.Vehiculo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jacky
 */
public class VehiculosInterfaz extends javax.swing.JFrame {

    public VehiculosInterfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Color = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtTransmision = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        TxtColor = new javax.swing.JTextField();
        TxtAnio = new javax.swing.JTextField();
        TxtModelo = new javax.swing.JTextField();
        TxtMarca = new javax.swing.JTextField();
        TxtPlaca = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnMostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Placa");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Marca");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Modelo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Anio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        Color.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Color.setForeground(new java.awt.Color(204, 204, 204));
        Color.setText("Color");
        jPanel1.add(Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Precio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Tipo de Transmision");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        TxtTransmision.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtTransmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 150, -1));

        TxtPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 150, -1));

        TxtColor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 150, -1));

        TxtAnio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 150, -1));

        TxtModelo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, -1));

        TxtMarca.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 150, -1));

        TxtPlaca.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 150, -1));

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 90, -1));

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 90, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 90, -1));

        BtnMostrar.setText("Mostrar Info");
        BtnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vehiculos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 200, 90, -1));

        jMenu1.setText("Cargar Archivo");

        jMenuItem2.setText("Cargar Archivo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Regresar");

        jMenuItem1.setText("Regresar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        Vehiculo aux;
        aux = new Vehiculo(TxtPlaca.getText(), TxtMarca.getText(), TxtModelo.getText(), Integer.parseInt(TxtAnio.getText()), TxtColor.getText(), Integer.parseInt(TxtPrecio.getText()), TxtTransmision.getText());
        Inicio.arbolito.Insertar(aux);
        JOptionPane.showMessageDialog(null, "Vehiculo agregado identificado con " + TxtPlaca.getText());
        TxtPlaca.setText("");
        TxtMarca.setText("");
        TxtModelo.setText("");
        TxtAnio.setText("");
        TxtColor.setText("");
        TxtPrecio.setText("");
        TxtTransmision.setText("");

    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed


    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MenuP principal = new MenuP();
        principal.setVisible(true);
        this.dispose();    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            String texto = "";
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos txt", "txt");
            chooser.setFileFilter(filter);
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = chooser.showOpenDialog(this);
            //Tomamos el archivo que se selecciono
            File open = chooser.getSelectedFile();
            Scanner salida = new Scanner(open, "UTF-8");
            while (salida.hasNextLine()) {
                texto += salida.nextLine();
            }
            salida.close();
            Inicio.arbolito.cargaMasiva(texto);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error Al Abrir El Archivo: " + ex);
        }

        JOptionPane.showMessageDialog(null, "Carga masiva completada!");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void BtnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMostrarActionPerformed
        try {
            Inicio.arbolito.imprimirNodo();
        } catch (Exception ex) {
            Logger.getLogger(VehiculosInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BtnMostrarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        Inicio.arbolito.modificarDatos(new Vehiculo(TxtPlaca.getText(), TxtMarca.getText(), TxtModelo.getText(), Integer.parseInt(TxtAnio.getText()), TxtColor.getText(), Integer.parseInt(TxtPrecio.getText()), TxtTransmision.getText()));
        JOptionPane.showMessageDialog(null, "Vehiculo modificado identificado con " + TxtPlaca.getText());
        TxtPlaca.setText("");
        TxtMarca.setText("");
        TxtModelo.setText("");
        TxtAnio.setText("");
        TxtColor.setText("");
        TxtPrecio.setText("");
        TxtTransmision.setText("");
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String seleccion = JOptionPane.showInputDialog("Escriba la Placa del carro que desea buscar", JOptionPane.QUESTION_MESSAGE);
        Inicio.arbolito.buscarCarro(seleccion);
        Vehiculo aux= Inicio.arbolito.getCarros();
        TxtPlaca.setText(aux.getPlaca());
        TxtMarca.setText(aux.getMarca());
        TxtModelo.setText(aux.getModelo());
        TxtAnio.setText(String.valueOf(aux.getAnio()));
        TxtPrecio.setText(String.valueOf(aux.getPrecio()));
        TxtTransmision.setText(aux.getTransmision());
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnMostrar;
    private javax.swing.JLabel Color;
    private javax.swing.JTextField TxtAnio;
    private javax.swing.JTextField TxtColor;
    private javax.swing.JTextField TxtMarca;
    private javax.swing.JTextField TxtModelo;
    private javax.swing.JTextField TxtPlaca;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtTransmision;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
