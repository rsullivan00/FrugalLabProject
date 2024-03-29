/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.ProjectProperties;
import controller.SearchParticipantController;
import model.Participant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 *  SearchParticipantView.java
 *  Created by Rick Sullivan on 5/27/2014.
 *
 *  The SearchParticipantView shows all participants stored. It also connects to the
 *  ParticipantView to allow editing of the participants.
 *
 */
public class SearchParticipantView extends JInternalFrame {
    private SearchParticipantController controller;
    private List<Participant> participantList;
    private boolean chooseView;
    private int selectedParticipantID;

    /**
     * Creates new form ParticipantView
     */
    public SearchParticipantView() {
        this(false);
    }

    public SearchParticipantView(boolean chooseView) {
        this.chooseView = chooseView;
        selectedParticipantID = -1; /* Initialized to invalid state */
        controller = new SearchParticipantController(this);
        initComponents();
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        participantScrollPane = new javax.swing.JScrollPane();
        participantTable = getParticipantsTable();

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(725, 343));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Participants"));
        jPanel1.setPreferredSize(new java.awt.Dimension(648, 40));

        searchTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        searchTextField.setToolTipText("Enter a filtering string");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        addButton.setText("Add participant");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(addButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton)
                    .addComponent(SearchButton))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Participants"));

        participantScrollPane.setPreferredSize(new java.awt.Dimension(600, 300));

        participantTable.setAutoCreateRowSorter(true);
        participantTable.setModel(participantTable.getModel());
        participantScrollPane.setViewportView(participantTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(participantScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(participantScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 725, 325);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        ParticipantView pv = new ParticipantView();
        pv.setVisible(true);
        this.getParent().add(pv);
        pv.moveToFront();
    }//GEN-LAST:event_addButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        /* Case insensitive regex for strings starting with search string */
        String regex = "(?i)^" + searchTextField.getText();
        TableRowSorter rowSorter = (TableRowSorter) this.participantTable.getRowSorter();
        if (rowSorter == null) {
            rowSorter = new TableRowSorter(participantTable.getModel());
            participantTable.setRowSorter(rowSorter);
        }
        List<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object, Object>>(participantTable.getColumnCount());
        RowFilter<Object, Object> of;
        try {
            for (int i = 0; i < participantTable.getColumnCount(); i++) {
                rfs.add(RowFilter.regexFilter(regex, i));
            }
            of = RowFilter.orFilter(rfs);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(of);
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        searchTextFieldActionPerformed(evt);
    }//GEN-LAST:event_SearchButtonActionPerformed

    public JTable getParticipantsTable(){
        participantList = controller.getAllParticipants();
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("First Name");
        columnNames.add("Last Name");
        columnNames.add("Role");
        columnNames.add("Photo");
        if (ProjectProperties.isAdminMode) {
            columnNames.add("View/Edit");
            columnNames.add("Delete");
        } else {
            columnNames.add("View");
        }

        if (isChooseView()) {
            columnNames.add("Select");
        }
        final Vector<Vector> participantData = new Vector<Vector>();

        for(final Participant participant: participantList){
            Vector<Object> rowData = new Vector<Object>();
            rowData.add(participant.getId());
            rowData.add(participant.getFirstName());
            rowData.add(participant.getLastName());
            rowData.add(participant.getRoleName());
            rowData.add(participant.getPhotoURL());
            final int id = participant.getId();
            if(ProjectProperties.isAdminMode){
                rowData.add("View/Edit");
                rowData.add("Delete");
            } else {
                rowData.add("View");
            }

            if (isChooseView()) {
                rowData.add("Select");
            }

            participantData.add(rowData);
        }

        JTable newTable = new JTable(participantData, columnNames);

        Action view = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                final int id = ((Integer) table.getValueAt(modelRow, 0));
                viewParticipant(id);
            }
        };

        ButtonColumn viewButtonColumn = new ButtonColumn(newTable, view, 5);

        if (ProjectProperties.isAdminMode) {
            Action delete = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    JTable table = (JTable) e.getSource();
                    int modelRow = Integer.valueOf(e.getActionCommand());
                    final int id = ((Integer) table.getValueAt(modelRow, 0));
                    /* Update DB */
                    controller.deleteParticipant(id);
                    /* Update table */
                    ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                }
            };

            ButtonColumn deleteButtonColumn = new ButtonColumn(newTable, delete, 6);
        }

        if (isChooseView()) {
             Action select = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    JTable table = (JTable) e.getSource();
                    int modelRow = Integer.valueOf(e.getActionCommand());
                    setSelectedParticipantID((Integer) table.getValueAt(modelRow, 0));
                    setVisible(false);
                }
            };

            ButtonColumn selectButtonColumn = new ButtonColumn(newTable, select, 6 + (ProjectProperties.isAdminMode ? 1 : 0));
        }

        return newTable;
    }

    public void viewParticipant(int id) {
        Participant p = controller.getParticipant(id);
        ParticipantView pv = new ParticipantView(p);
        pv.setVisible(true);
        this.getParent().add(pv);
        pv.moveToFront();
    }

    public void updateTable() {
        /* Re-query DB and construct new table */
        participantTable = getParticipantsTable();
        participantScrollPane.setViewportView(participantTable);
    }

    public boolean isChooseView() {
        return chooseView;
    }

    public void setChooseView(boolean chooseView) {
        this.chooseView = chooseView;
    }

    public int getSelectedParticipantID() {
        return selectedParticipantID;
    }

    public void setSelectedParticipantID(int selectedParticipantID) {
        firePropertyChange("selectedParticipantID", this.selectedParticipantID, selectedParticipantID);
        this.selectedParticipantID = selectedParticipantID;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchButton;
    private javax.swing.JButton addButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane participantScrollPane;
    private javax.swing.JTable participantTable;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
