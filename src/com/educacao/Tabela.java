/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacao;

import com.educacao.dao.GenericDAO;
import com.educacao.dao.IGenericDAO;
import com.educacao.models.Pessoa;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cleys
 */
public class Tabela extends javax.swing.JFrame {
    private static Tabela singleton;
    private IGenericDAO service;
    private DefaultTableModel currentData;
    /**
     * Creates new form Tabela
     */
    public Tabela() {
        this.service = new GenericDAO();
        initComponents();
        
        try {
            this.atualizarDados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void atualizarDados() throws Exception {
        tb_dados.setModel(this.getPessoas());
    }
    
    private void atualizarDados(DefaultTableModel model) throws Exception {
        tb_dados.setModel(model);
    }
    
    public DefaultTableModel getPessoas() throws Exception {
        List<Pessoa> pessoas = this.service.listar();
        this.currentData = this.fromTable(pessoas);
        return this.currentData;
    }
    
    private DefaultTableModel fromTable(List<Pessoa> pessoas) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Código", "Nome", "Idade", "Sexo"}, 0);
        if (pessoas != null) {
            for (Pessoa p : pessoas) {
                model.addRow(new Object[]{p.getId(), p.getNome(), p.getIdade(), p.getSexo().getLiteral()});
            }
        }

        this.currentData = model;
        return model;
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
        tb_dados = new javax.swing.JTable();
        tx_pesquisar = new javax.swing.JTextField();
        bt_pesquisar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tb_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de candidatos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tb_dados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Idade", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tb_dados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tb_dados);

        bt_pesquisar.setText("Pesquisar");
        bt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarActionPerformed(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");

        tb_voltar.setText("Voltar");
        tb_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(tx_pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tb_voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tb_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarActionPerformed
        try {
            // TODO add your handling code here:
            List<Pessoa> pessoas = this.service.buscarPorNome(tx_pesquisar.getText());
            this.atualizarDados(this.fromTable(pessoas));
        } catch (Exception ex) {
            Logger.getLogger(Tabela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bt_pesquisarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedId = tb_dados.getSelectedRow();
        System.out.println(this.currentData.getValueAt(selectedId, 0));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.out.println("Fechando...");
    }//GEN-LAST:event_formWindowClosing

    private void tb_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_voltarActionPerformed
        // TODO add your handling code here:
        Application.app.setVisible(true);
        
        
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    singleton.setVisible(false);
                    Thread.sleep(200);
                    singleton.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tabela.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };
        
        new Thread(run).start();
    }//GEN-LAST:event_tb_voltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                singleton = new Tabela();
                singleton.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_pesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_dados;
    private javax.swing.JButton tb_voltar;
    private javax.swing.JTextField tx_pesquisar;
    // End of variables declaration//GEN-END:variables
}
