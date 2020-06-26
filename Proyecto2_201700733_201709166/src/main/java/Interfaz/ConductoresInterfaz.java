/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import EDD.ListaCircularDoble;
import Principal.Conductores;
import static Principal.Inicio.condu;
import static Principal.Inicio.lcd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jacky
 */
public class ConductoresInterfaz extends javax.swing.JFrame {

    /**
     * Creates new form Conductores
     */
    public ConductoresInterfaz() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Color = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        TxtGenero = new javax.swing.JTextField();
        TxtLicencia = new javax.swing.JTextField();
        TxtApellidos = new javax.swing.JTextField();
        TxtNombres = new javax.swing.JTextField();
        TxtDpi = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnMostrar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Conductores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 120, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("DPI");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Nombres");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Apellidos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Licencia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        Color.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Color.setForeground(new java.awt.Color(204, 204, 204));
        Color.setText("Genero");
        jPanel1.add(Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Telefono");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Direccion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        TxtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 150, -1));

        TxtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 150, -1));

        TxtGenero.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 150, -1));

        TxtLicencia.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 150, -1));

        TxtApellidos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 150, -1));

        TxtNombres.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 150, -1));

        TxtDpi.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(TxtDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 150, -1));

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 90, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 90, -1));

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 90, -1));

        BtnMostrar.setText("Mostrar Info");
        BtnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 90, -1));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MenuP principal = new MenuP();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        long dpi = Long.parseLong(TxtDpi.getText());
        lcd.Insertar(new Conductores(dpi, TxtNombres.getText(), TxtApellidos.getText(), TxtLicencia.getText(), TxtGenero.getText(), TxtTelefono.getText(), TxtDireccion.getText()));
        TxtDpi.setText("");
        TxtNombres.setText("");
        TxtApellidos.setText("");
        TxtLicencia.setText("");
        TxtGenero.setText("");
        TxtTelefono.setText("");
        TxtDireccion.setText("");
        JOptionPane.showMessageDialog(null, "Usuario Agregado identificado con " + TxtDpi.getText());
        
        //lcd.ordena_lista(lcd);

    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        String seleccion = JOptionPane.showInputDialog("Escriba el DPI que desea eliminar", JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
        System.out.println("El usuario ha escrito " + seleccion);
        // buscar(seleccion);

        long dpi = Long.parseLong(seleccion);
        lcd.Eliminar(dpi);
        TxtDpi.setText("");
        JOptionPane.showMessageDialog(null, "Usuario Eliminado identificado con " + TxtDpi.getText());


    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMostrarActionPerformed
        lcd.Desplegar();
        lcd.ReporteLCD();
    }//GEN-LAST:event_BtnMostrarActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        String seleccion = JOptionPane.showInputDialog("Escriba el DPI que desea buscar", JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
        long upsi = Long.parseLong(seleccion);
        System.out.println("El usuario ha escrito " + upsi);
        lcd.Buscar(upsi);
        TxtDpi.setText(seleccion);


    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        long upsi = Long.parseLong(TxtDpi.getText());
        lcd.Modificar(upsi, TxtNombres.getText(), TxtApellidos.getText(), TxtLicencia.getText(), TxtGenero.getText(), TxtTelefono.getText(), TxtDireccion.getText());
        JOptionPane.showMessageDialog(null, "Usuario Modificado identificado con " + TxtDpi.getText());
        TxtDpi.setText("");
        TxtNombres.setText("");
        TxtApellidos.setText("");
        TxtLicencia.setText("");
        TxtGenero.setText("");
        TxtTelefono.setText("");
        TxtDireccion.setText("");
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos txt", "txt");
            chooser.setFileFilter(filter);
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result=chooser.showOpenDialog(this);
        //Tomamos el archivo que se selecciono
            File open = chooser.getSelectedFile();

            if (open.exists()) {
                //Creamos un buffer para leer el archivo
                
                BufferedReader buffer = new BufferedReader(new FileReader(open));
                String cad = buffer.readLine();
                
                while (cad!= null) {
                    String[] conductores=cad.split(";");
                    for(int i = 0; i < conductores.length; i++)
                    {
                        String[] datos = conductores[i].split("%");
                        System.out.println("DPI "+datos[0]);
                        System.out.println("Nombres "+datos[1]);
                        System.out.println("Apellidos "+datos[2]);
                        System.out.println("Licencia "+datos[3]);
                        System.out.println("Genero "+datos[4]);
                        System.out.println("Telefono "+datos[5]);
                        System.out.println("Direccion "+datos[6]);
                        
                        if(datos.length==7){
                            lcd.Insertar(new Conductores(Long.valueOf(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]));
                        }else if(datos.length<7){
                             System.out.println("No hay datos suficientes para agregar al conductor");
                        }else{
                             System.out.println("Hay más datos de los requeridos, no se puede agregar");
                        }
                        
                    }
                    cad=buffer.readLine();
                    
                   
                }

                buffer.close();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error Al Abrir El Archivo");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error Al Abrir El Archivo: " + ex);
        }

        JOptionPane.showMessageDialog(null, "Carga masiva completada!");

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnMostrar;
    private javax.swing.JLabel Color;
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtDpi;
    private javax.swing.JTextField TxtGenero;
    private javax.swing.JTextField TxtLicencia;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtTelefono;
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

    public void setTxtDpi(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
