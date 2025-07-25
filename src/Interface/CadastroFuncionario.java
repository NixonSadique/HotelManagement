/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.Vector;
import model.Funcionarios;
import gestorHotel.FicheiroFuncionarios;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class CadastroFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form CadastroFuncionario
     */
    public CadastroFuncionario() {
        initComponents();
        try{
            vector = (Vector) FicheiroFuncionarios.ler();
        }catch(Exception e){
            e.printStackTrace();
        }
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Funcionarios.png")));
    }
    
    Vector vector = new Vector();    
    
    public void cadastro(){
        Funcionarios funcionario = new Funcionarios();
        funcionario.setNome(textoNome.getText());
        funcionario.setSenha(textoSenha.getText());
        funcionario.setCodigo(Integer.parseInt(textoCodigo.getText()));
        funcionario.setFuncao(cBoxFuncao.getSelectedItem()+"");
        funcionario.setIdade(Integer.parseInt(textoIdade.getText()));
        if(radioMasculino.isSelected()){
            funcionario.setGenero("Masculino");
        }else{
            if(radioFemenino.isSelected()){
                funcionario.setGenero("Femenino");
            }else{
                funcionario.setGenero(null);
            }
        }
        vector.add(funcionario);
        JOptionPane.showMessageDialog(null, "Cadastro Efectuado!");
        limpar();
        try{
            FicheiroFuncionarios.guardar(vector);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actualizar(){
        Funcionarios funcionario;
        for (int i = 0; i < vector.size(); i++) {
            funcionario = (Funcionarios) vector.get(i);
            if (Integer.parseInt(textoCodigo.getText())==funcionario.getCodigo()) {
                funcionario.setNome(textoNome.getText());
                funcionario.setSenha(textoSenha.getText());
                funcionario.setCodigo(Integer.parseInt(textoCodigo.getText()));
                funcionario.setFuncao(cBoxFuncao.getSelectedItem() + "");
                funcionario.setIdade(Integer.parseInt(textoIdade.getText()));
                if (radioMasculino.isSelected()) {
                    funcionario.setGenero("Masculino");
                } else {
                    if (radioFemenino.isSelected()) {
                        funcionario.setGenero("Femenino");
                    } else {
                        funcionario.setGenero(null);
                    }
                }
                vector.add(funcionario);
                try {
                    FicheiroFuncionarios.guardar(vector);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }  
    }
    
    public void limpar(){
        textoNome.setText("");
        textoSenha.setText("");
        textoCodigo.setText("");
        cBoxFuncao.setSelectedIndex(0);
        textoIdade.setText("");
        groupGenero.clearSelection();
        
    }
    
    public void eliminar() {
        Funcionarios funcionario;
        
        for (int i = 0; i < vector.size(); i++) {
            funcionario = (Funcionarios) vector.get(i);
            if(Integer.parseInt(textoCodigo.getText())==funcionario.getCodigo()){
                try{
                    vector.remove(i);
                    FicheiroFuncionarios.guardar(vector);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void procurar(){
        Funcionarios funcionario;
        for (int i = 0; i < vector.size(); i++) {
            funcionario = (Funcionarios) vector.get(i);
            if(Integer.parseInt(textoProcura.getText())==funcionario.getCodigo()){
                textoNome.setText(funcionario.getNome());
                textoSenha.setText(funcionario.getSenha());
                textoCodigo.setText(funcionario.getCodigo()+"");
                cBoxFuncao.setSelectedItem(funcionario.getFuncao());
                textoIdade.setText(funcionario.getIdade()+"");
                if(funcionario.getGenero().equals("Masculino")){
                    radioMasculino.setSelected(true);
                }else{
                    if(funcionario.getGenero().equals("Femenino")){
                        radioFemenino.setSelected(true);
                    }else{
                       
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

        groupGenero = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        textoSenha = new javax.swing.JTextField();
        labelCodigo = new javax.swing.JLabel();
        textoCodigo = new javax.swing.JTextField();
        labelFuncao = new javax.swing.JLabel();
        cBoxFuncao = new javax.swing.JComboBox<>();
        labelProcura = new javax.swing.JLabel();
        textoProcura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        radioMasculino = new javax.swing.JRadioButton();
        radioFemenino = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        textoIdade = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        buttonCadastro = new javax.swing.JButton();
        buttonActualizar = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonProcurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro do Funcionario");
        setResizable(false);

        labelNome.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        labelNome.setText("Nome:");

        textoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNomeActionPerformed(evt);
            }
        });

        labelSenha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        labelSenha.setText("Senha");

        labelCodigo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        labelCodigo.setText("Codigo:");

        labelFuncao.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        labelFuncao.setText("Funcao");

        cBoxFuncao.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cBoxFuncao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Recepcionista", "Administrador", "Gerente", " " }));

        labelProcura.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        labelProcura.setText("Procura");

        textoProcura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoProcuraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel1.setText("Genero");

        groupGenero.add(radioMasculino);
        radioMasculino.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        radioMasculino.setText("Masculino");

        groupGenero.add(radioFemenino);
        radioFemenino.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        radioFemenino.setText("Femenino");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("Idade");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelFuncao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioFemenino)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textoIdade, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cBoxFuncao, javax.swing.GroupLayout.Alignment.LEADING, 0, 136, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelProcura)
                        .addGap(12, 12, 12)
                        .addComponent(textoProcura, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNome)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textoProcura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelProcura)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSenha)
                            .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCodigo)
                            .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFuncao)
                            .addComponent(cBoxFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radioMasculino)
                    .addComponent(radioFemenino))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Operadores"));

        buttonCadastro.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        buttonCadastro.setText("Cadastro");
        buttonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastroActionPerformed(evt);
            }
        });

        buttonActualizar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        buttonActualizar.setText("Actualizar");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        buttonLimpar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        buttonLimpar.setText("Limpar");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        buttonEliminar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        buttonEliminar.setText("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonProcurar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        buttonProcurar.setText("Procurar");
        buttonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonCadastro)
                .addGap(18, 18, 18)
                .addComponent(buttonActualizar)
                .addGap(18, 18, 18)
                .addComponent(buttonLimpar)
                .addGap(18, 18, 18)
                .addComponent(buttonEliminar)
                .addGap(18, 18, 18)
                .addComponent(buttonProcurar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCadastro)
                    .addComponent(buttonActualizar)
                    .addComponent(buttonLimpar)
                    .addComponent(buttonEliminar)
                    .addComponent(buttonProcurar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textoProcuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoProcuraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoProcuraActionPerformed

    private void textoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNomeActionPerformed

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastroActionPerformed
        // TODO add your handling code here:
        cadastro();
    }//GEN-LAST:event_buttonCadastroActionPerformed

    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_buttonLimparActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarActionPerformed
        // TODO add your handling code here:
        procurar();
    }//GEN-LAST:event_buttonProcurarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonCadastro;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JButton buttonProcurar;
    private javax.swing.JComboBox<String> cBoxFuncao;
    private javax.swing.ButtonGroup groupGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelFuncao;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelProcura;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JRadioButton radioFemenino;
    private javax.swing.JRadioButton radioMasculino;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoIdade;
    private javax.swing.JTextField textoNome;
    private javax.swing.JTextField textoProcura;
    private javax.swing.JTextField textoSenha;
    // End of variables declaration//GEN-END:variables
}
