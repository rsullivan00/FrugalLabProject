/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.ParticipantController;

/**
 *
 * @author Rick
 */
public class ParticipantView extends javax.swing.JInternalFrame {
    private ParticipantController controller;

    /**
     * Creates new form ParticipantView
     */
    public ParticipantView() {
        controller = new ParticipantController(this);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        PersistenceUnitEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
        roleQuery = java.beans.Beans.isDesignTime() ? null : PersistenceUnitEntityManager.createQuery("SELECT r.name FROM role r");
        roleList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : roleQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        participantPanel = new javax.swing.JPanel();
        lblParticipantFirstName = new javax.swing.JLabel();
        lblParticipantRole = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        comboRole = new javax.swing.JComboBox();
        participantOptionsPanel = new javax.swing.JPanel();
        btnAddProj = new javax.swing.JButton();
        btnAddImage = new javax.swing.JButton();
        btnSaveParticipant = new javax.swing.JButton();
        btnDeleteParticipant = new javax.swing.JButton();
        txtLastName = new javax.swing.JTextField();
        participantDependencyTab = new javax.swing.JTabbedPane();
        participantProjectPane = new javax.swing.JPanel();

        participantPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Participant Details"));
        participantPanel.setName(""); // NOI18N

        lblParticipantFirstName.setText("First Name");

        lblParticipantRole.setText("Last Name");

        lblStartDate.setText("Role");

        jLabel4.setText("Photo");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, roleList, comboRole);
        bindingGroup.addBinding(jComboBoxBinding);

        comboRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRoleActionPerformed(evt);
            }
        });

        btnAddProj.setText("Add Project");
        btnAddProj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjActionPerformed(evt);
            }
        });

        btnAddImage.setText("Add Image");
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });

        btnSaveParticipant.setText("Save Participant");
        btnSaveParticipant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveParticipantActionPerformed(evt);
            }
        });

        btnDeleteParticipant.setText("Delete Participant");
        btnDeleteParticipant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteParticipantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout participantOptionsPanelLayout = new javax.swing.GroupLayout(participantOptionsPanel);
        participantOptionsPanel.setLayout(participantOptionsPanelLayout);
        participantOptionsPanelLayout.setHorizontalGroup(
            participantOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(participantOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveParticipant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteParticipant, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(btnAddProj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        participantOptionsPanelLayout.setVerticalGroup(
            participantOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantOptionsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddProj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveParticipant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteParticipant)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout participantPanelLayout = new javax.swing.GroupLayout(participantPanel);
        participantPanel.setLayout(participantPanelLayout);
        participantPanelLayout.setHorizontalGroup(
            participantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(participantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(participantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblParticipantFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblParticipantRole, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStartDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(participantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFirstName)
                    .addComponent(comboRole, 0, 299, Short.MAX_VALUE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(66, 66, 66)
                .addComponent(participantOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        participantPanelLayout.setVerticalGroup(
            participantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantPanelLayout.createSequentialGroup()
                .addGroup(participantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(participantPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblParticipantFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(participantPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(participantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParticipantRole, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(participantPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
            .addGroup(participantPanelLayout.createSequentialGroup()
                .addComponent(participantOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout participantProjectPaneLayout = new javax.swing.GroupLayout(participantProjectPane);
        participantProjectPane.setLayout(participantProjectPaneLayout);
        participantProjectPaneLayout.setHorizontalGroup(
            participantProjectPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );
        participantProjectPaneLayout.setVerticalGroup(
            participantProjectPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );

        participantDependencyTab.addTab("Projects", participantProjectPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(participantDependencyTab)
                    .addComponent(participantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(participantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(participantDependencyTab, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        participantPanel.getAccessibleContext().setAccessibleName("Participant Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteParticipantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteParticipantActionPerformed

    }//GEN-LAST:event_btnDeleteParticipantActionPerformed

    private void btnSaveParticipantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveParticipantActionPerformed
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        int role = comboRole.getSelectedIndex();
        /* Photo URL handling? */

        controller.addParticipant(firstName, lastName, role, null);
    }//GEN-LAST:event_btnSaveParticipantActionPerformed

    private void btnAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddImageActionPerformed

    private void btnAddProjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjActionPerformed
    }//GEN-LAST:event_btnAddProjActionPerformed

    private void comboRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRoleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager PersistenceUnitEntityManager;
    private javax.swing.JButton btnAddImage;
    private javax.swing.JButton btnAddProj;
    private javax.swing.JButton btnDeleteParticipant;
    private javax.swing.JButton btnSaveParticipant;
    private javax.swing.JComboBox comboRole;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblParticipantFirstName;
    private javax.swing.JLabel lblParticipantRole;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JTabbedPane participantDependencyTab;
    private javax.swing.JPanel participantOptionsPanel;
    private javax.swing.JPanel participantPanel;
    private javax.swing.JPanel participantProjectPane;
    private java.util.List<model.Role> roleList;
    private javax.persistence.Query roleQuery;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
