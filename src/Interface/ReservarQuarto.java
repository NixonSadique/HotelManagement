/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import gestorHotel.FicheiroClientes;
import gestorHotel.FicheiroQuartos;
import gestorHotel.FicheiroReservas;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author HP
 */
public class ReservarQuarto extends javax.swing.JFrame {

    /**
     * Creates new form ReservarQuarto
     */
    
    Vector vClientes = new Vector();
    Vector vQuartos = new Vector();
    Vector vReservas = new Vector();
    
    public ReservarQuarto() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("IconHotel.png")));
        try {
            vClientes = (Vector) FicheiroClientes.ler();
            vQuartos = (Vector) FicheiroQuartos.ler();
            vReservas = (Vector) FicheiroReservas.ler();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabClientes();
        tabQuartos();
    }
    
    //tabela de clientes e de quartos aqui
    
    public void tabClientes(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        Clientes cliente;
        Object[] linha = new Object[4];
        for (int i = 0; i < vClientes.size(); i++) {
            cliente = (Clientes) vClientes.get(i);
            linha[0]= cliente.getId();
            linha[1]= cliente.getNome();
            linha[2]= cliente.getEmail();
            linha[3]= cliente.getTelefone();
            
            if(cliente.getIdQuarto() == 0){
                modelo.addRow(linha);
            }
            
        }
    }
    
    public void tabQuartos(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaQuartos.getModel();
        Quarto quarto;
        Object[] linha = new Object[4];
        for (int i = 0; i < vQuartos.size(); i++) {
            quarto = (Quarto) vQuartos.get(i);
            linha[0] = quarto.getNrQuarto();
            linha[1] = quarto.getAndar();
            linha[2] = quarto.getDisponivel();
            linha[3] = quarto.getPreco();
            
            if(quarto.getDisponivel().equals("Disponivel")){
                modelo.addRow(linha);
            }
        }

    }
    
    
    void reservar(){
        int rowClientes = tabelaClientes.getSelectedRow();
        int rowQuartos = tabelaQuartos.getSelectedRow();
        
        Object idCliente = tabelaClientes.getModel().getValueAt(rowClientes, 0);
        Object idQuarto = tabelaQuartos.getModel().getValueAt(rowQuartos, 0);
        
        Clientes cliente;
        Quarto quarto;
        Reservas reserva = new Reservas();
        
        String estadia;
                
        for (int i = 0; i < vClientes.size(); i++) {
            
            cliente = (Clientes) vClientes.get(i);
            int cId = cliente.getId();
            for (int j = 0; j < vQuartos.size(); j++) {
                
                quarto = (Quarto) vQuartos.get(j);
                //Change  to QuartoId later
                int qId = quarto.getNrQuarto();
                if (((int)idCliente== cId && (int) idQuarto == qId )) {
                    estadia = JOptionPane.showInputDialog("Introduza o tempo de estadia:");
                    
                    cliente.setIdQuarto((int) idQuarto);
                    
                    quarto.setClienteId((int) idCliente);
                    quarto.setDisponivel("Indisponivel");
                    JOptionPane.showMessageDialog(null, "Reserva efectuada!");
                    
                    reserva.setNome(cliente.getNome());
                    reserva.setTelefone(cliente.getTelefone());
                    reserva.setEmai(cliente.getEmail());
                    reserva.setQuarto(quarto.getNrQuarto());
                    reserva.setTempo(Integer.parseInt(estadia));
                    reserva.setPreco(quarto.getPreco());
                    
                    vReservas.add(reserva);
                    
                    try{
                        FicheiroQuartos.guardar(vQuartos);
                        FicheiroClientes.guardar(vClientes);
                        FicheiroReservas.guardar(vReservas);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaQuartos = new javax.swing.JTable();
        buttonReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reservar um Quarto");
        setResizable(false);

        tabelaClientes.setBackground(new java.awt.Color(204, 204, 255));
        tabelaClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelaClientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaClientes);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quarto");

        tabelaQuartos.setBackground(new java.awt.Color(204, 204, 255));
        tabelaQuartos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelaQuartos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tabelaQuartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero do Quarto", "Andar", "Disponibilidade", "Preco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaQuartos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaQuartos);

        buttonReserva.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        buttonReserva.setText("Reservar");
        buttonReserva.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReservaActionPerformed
        // TODO add your handling code here:
        //see if room is available 
        reservar();
    }//GEN-LAST:event_buttonReservaActionPerformed

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
            java.util.logging.Logger.getLogger(ReservarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservarQuarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservarQuarto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTable tabelaQuartos;
    // End of variables declaration//GEN-END:variables
}
