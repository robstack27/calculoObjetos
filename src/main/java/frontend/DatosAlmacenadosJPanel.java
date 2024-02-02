/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class DatosAlmacenadosJPanel extends javax.swing.JPanel {

    /**
     * Creates new form IntroducciónJPanel
     */
    public DatosAlmacenadosJPanel(List<Document> calculos) {
        initComponents();
        cargarTabla(calculos);
    }

    private void cargarTabla(List<Document> calculos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("#");
        modeloTabla.addColumn("Tiempo");
        modeloTabla.addColumn("Altura");
        modeloTabla.addColumn("Velocidad Final");

        for (int i = 0; i < calculos.size(); i++) {
            Document datos = calculos.get(i);
            modeloTabla.addRow(new Object[]{i + 1, datos.getDouble("tiempo"), datos.getDouble("altura"),datos.getDouble("velocidad")});
        }

        jTableCalculos.setModel(modeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCalculos = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
        jLabel1.setText("Datos Almacenados");

        jTableCalculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Tiempo", "Altura", "Velocidad Final"
            }
        ));
        jScrollPane2.setViewportView(jTableCalculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCalculos;
    // End of variables declaration//GEN-END:variables
}
