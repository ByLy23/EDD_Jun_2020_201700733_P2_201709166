/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Principal.Cliente;
import Principal.Inicio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
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
public class ClientesInterfaz extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    public ClientesInterfaz() {
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
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtDPI = new javax.swing.JTextField();
        TxtNombres = new javax.swing.JTextField();
        TxtApellidos = new javax.swing.JTextField();
        TxtGenero = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        TxtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnMostrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
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
        jLabel3.setText("DPI");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Nombres");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Apellidos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Genero");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Telefono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Direccion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        TxtDPI.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtDPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 150, -1));

        TxtNombres.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 150, -1));

        TxtApellidos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 150, -1));

        TxtGenero.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 150, -1));

        TxtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 150, -1));

        TxtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 150, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 120, -1));

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 90, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 90, -1));

        BtnMostrar.setText("Generar Reporte");
        BtnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Fecha Nac");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        TxtFecha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 150, -1));

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 90, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 90, -1));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        Inicio.tablita.eliminarDatos(BigInteger.valueOf(Long.valueOf(TxtDPI.getText())));
        JOptionPane.showMessageDialog(null, "Cliente Eliminado identificado con " + TxtDPI.getText());
        TxtDPI.setText("");
        TxtNombres.setText("");
        TxtApellidos.setText("");
        TxtGenero.setText("");
        TxtTelefono.setText("");
        TxtDireccion.setText("");
        TxtFecha.setText("");
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MenuP principal = new MenuP();
        principal.setVisible(true);
        this.dispose();     }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            Inicio.tablita.cargaMasiva(texto);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error Al Abrir El Archivo: " + ex);
        }

        JOptionPane.showMessageDialog(null, "Carga masiva completada!");


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        Inicio.tablita.modificarDatos(BigInteger.valueOf(Long.valueOf(TxtDPI.getText())), TxtNombres.getText(), TxtApellidos.getText(), TxtGenero.getText(), Integer.parseInt(TxtTelefono.getText()), TxtDireccion.getText(), TxtFecha.getText());
        JOptionPane.showMessageDialog(null, "Cliente Modificado identificado con " + TxtDPI.getText());
        TxtDPI.setText("");
        TxtNombres.setText("");
        TxtApellidos.setText("");
        TxtGenero.setText("");
        TxtTelefono.setText("");
        TxtDireccion.setText("");
        TxtFecha.setText("");
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMostrarActionPerformed
        try {
            Inicio.tablita.graficar();        // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(ClientesInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        Reporteria principal = new Reporteria();
        principal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnMostrarActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        Inicio.tablita.insertarClientes(BigInteger.valueOf(Long.valueOf(TxtDPI.getText())), TxtNombres.getText(), TxtApellidos.getText(), TxtGenero.getText(), Integer.parseInt(TxtTelefono.getText()), TxtDireccion.getText(), TxtFecha.getText());
        JOptionPane.showMessageDialog(null, "Cliente agregado identificado con " + TxtDPI.getText());
        TxtDPI.setText("");
        TxtNombres.setText("");
        TxtApellidos.setText("");
        TxtGenero.setText("");
        TxtTelefono.setText("");
        TxtDireccion.setText("");
        TxtFecha.setText("");

    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String seleccion = JOptionPane.showInputDialog("Escriba el Cliente que desea buscar", JOptionPane.QUESTION_MESSAGE);
        Inicio.tablita.buscar(BigInteger.valueOf(Long.valueOf(seleccion)));
        Cliente aux = Inicio.tablita.getAux();
        if (aux != null) {
            TxtDPI.setText(String.valueOf(aux.getDPI()));
            TxtNombres.setText(aux.getNombre());
            TxtApellidos.setText(aux.getApellido());
            TxtGenero.setText(aux.getGenero());
            TxtTelefono.setText(String.valueOf(aux.getTelefono()));
            TxtDireccion.setText(aux.getDireccion());
            TxtFecha.setText(aux.getFechaNac());
        } else {
            JOptionPane.showMessageDialog(null, "No existe");
        }
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
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtDPI;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtGenero;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
