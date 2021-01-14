package responsi;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;

public class Cari extends javax.swing.JFrame {
    DefaultTableModel tabModel;
    ResultSet RsPerpustakaan=null;
    
    public Cari() {
        initComponents();
        TampilData();
    }
    
    public void TampilData(){
        try{
            Object[] judul = {
                "ID", "Judul Buku", "Genre Buku", "Penulis", "Penerbit", "Lokasi", "Stok"
            };
            tabModel = new DefaultTableModel(null, judul);
            TablePerpustakaan.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
           
            RsPerpustakaan=stt.executeQuery("SELECT * from buku");  
            while(RsPerpustakaan.next()){
                Object[] data={
                    RsPerpustakaan.getString("id"),
                    RsPerpustakaan.getString("judul"),
                    RsPerpustakaan.getString("genre"),
                    RsPerpustakaan.getString("penulis"),
                    RsPerpustakaan.getString("penerbit"),
                    RsPerpustakaan.getString("lokasi"),
                    RsPerpustakaan.getString("stok")
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    public void TampilCari(){
        try{
            String cari=inputCari.getText();
            Object[] judul = {
                "ID", "Judul Buku", "Genre Buku", "Penulis", "Penerbit", "Lokasi", "Stok"
            };
            tabModel = new DefaultTableModel(null, judul);
            TablePerpustakaan.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
           
            RsPerpustakaan=stt.executeQuery("SELECT * from buku WHERE id='"+cari+"' OR judul='"+cari+"' OR genre='"+cari+"' OR penulis='"+cari+"' OR penerbit='"+cari+"' OR lokasi='"+cari+"' OR stok='"+cari+"'");  
            while(RsPerpustakaan.next()){
                Object[] data={
                    RsPerpustakaan.getString("id"),
                    RsPerpustakaan.getString("judul"),
                    RsPerpustakaan.getString("genre"),
                    RsPerpustakaan.getString("penulis"),
                    RsPerpustakaan.getString("penerbit"),
                    RsPerpustakaan.getString("lokasi"),
                    RsPerpustakaan.getString("stok")
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kategori = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        inputCari = new javax.swing.JTextField();
        Cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePerpustakaan = new javax.swing.JTable();
        Close = new javax.swing.JButton();
        TampilSemua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cari Buku :");

        Cari.setText("Cari");
        Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        });

        TablePerpustakaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(TablePerpustakaan);

        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        TampilSemua.setText("Tampilkan Semua");
        TampilSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TampilSemuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputCari)
                            .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TampilSemua))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Close, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Cari, TampilSemua});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(inputCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cari)
                    .addComponent(TampilSemua))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Close)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariActionPerformed
        /*String cari=inputCari.getText();
        if (cari.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kata tidak boleh kosong");
            inputCari.requestFocus();
        }
        else{
            TampilCari();
        }*/
        TampilCari();
    }//GEN-LAST:event_CariActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CloseActionPerformed

    private void TampilSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TampilSemuaActionPerformed
        TampilData();
    }//GEN-LAST:event_TampilSemuaActionPerformed

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
            java.util.logging.Logger.getLogger(Cari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cari().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cari;
    private javax.swing.JButton Close;
    private javax.swing.ButtonGroup Kategori;
    private javax.swing.JTable TablePerpustakaan;
    private javax.swing.JButton TampilSemua;
    private javax.swing.JTextField inputCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /*public void TampilCari(){
        try{
            Object[] judul = {
                "ID", "Judul Buku", "Genre Buku", "Penulis", "Penerbit", "Lokasi", "Stok"
            };
            tabModel = new DefaultTableModel(null, judul);
            TablePerpustakaan.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            if(rbJudul.isSelected()){ 
                RsPerpustakaan=stt.executeQuery("SELECT * from buku WHERE judul='"+inputCari+"'");  
            }
            else if(rbGenre.isSelected()){ 
                RsPerpustakaan=stt.executeQuery("SELECT * from buku WHERE genre=cari'");  
            }
            if(rbPenulis.isSelected()){ 
                RsPerpustakaan=stt.executeQuery("SELECT * from buku WHERE penulis='"+inputCari+"'");  
            }
            if(rbPenerbit.isSelected()){ 
                RsPerpustakaan=stt.executeQuery("SELECT * from buku WHERE penerbit='"+inputCari+"'");  
            }
            if(rbStok.isSelected()){ 
                RsPerpustakaan=stt.executeQuery("SELECT * from buku WHERE stok='"+inputCari+"'");  
            }
            while(RsPerpustakaan.next()){
                Object[] data={
                    RsPerpustakaan.getString("id"),
                    RsPerpustakaan.getString("judul"),
                    RsPerpustakaan.getString("genre"),
                    RsPerpustakaan.getString("penulis"),
                    RsPerpustakaan.getString("penerbit"),
                    RsPerpustakaan.getString("lokasi"),
                    RsPerpustakaan.getString("stok")
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }*/
}
