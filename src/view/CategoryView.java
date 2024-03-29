/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import controller.CategoryController;
import controller.ParticipantController;
import controller.ProjectController;
import model.Category;
import model.Project;
import service.CategoryService;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jorge
 */
public class CategoryView extends javax.swing.JInternalFrame {
	private CategoryController categoryController = new CategoryController();
	private int selectedCategoryID;
	
    /**
     * Creates new form CategoryVieww
     */
    public CategoryView() {

        initComponents();
        jTextField1.setCaretPosition(0);
        jTextField1.requestFocusInWindow();
        jTextField1.selectAll();
       
        //jTable1 = getCategoryListTable();
    	//JScrollPane scrollpane = new JScrollPane(jt);
    	//jTable1.setLayout(new BorderLayout());
    	//jTable1.add(scrollpane);
        selectedCategoryID = 0;
    
    	


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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = getCategoryListTable();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jTextField1.setText("Enter New Category");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeyPressed(evt);
            }
        });

        jLabel2.setText("New Category");

      /*  jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Categories"
            }
        )); 
        */
        
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 149, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Edit Categories");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 287, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
            	categoryController.addNewCategory(jTextField1.getText());
    	jTextField1.setText("Enter New Category");
        jTable1 = getCategoryListTable();
        jScrollPane1.setViewportView(jTable1);
        jTable1.scrollRectToVisible(jTable1.getCellRect(jTable1.getRowCount()-1, jTable1.getColumnCount(), true));
        jTextField1.setCaretPosition(0);
        jTextField1.requestFocusInWindow();
        jTextField1.selectAll();
    }                               

    
    public JTable getCategoryListTable(){
    	
        List<Category> categoryList = categoryController.getAllCategoryList();
        
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Name");

        //if (ProjectProperties.isAdminMode) {
            columnNames.add("Delete");
            columnNames.add("Select");
       // } else {
         //   columnNames.add("View");
      //  }
        final Vector<Vector> categoryData = new Vector<Vector>();

        final List<Category> categoryList1 = new CategoryController().getAllCategoryList();
        for(final Category category: categoryList1){
            Vector<Object> rowData = new Vector<Object>();
            rowData.add(category.getCategoryName());
  
            final int id = category.getId();
         //   if(CategoryProperties.isAdminMode){
                rowData.add("Delete");
                rowData.add("Select");
         //   } else {
             //   rowData.add("Select");
          //  }

            categoryData.add(rowData);
        }

        JTable categoryTable = new JTable(categoryData, columnNames);
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                Category c = categoryList1.get(modelRow);
                int id = c.getId(); //((Integer) table.getValueAt(modelRow, 0));
                /* Update DB */
                categoryController.deleteCategory(id);
                /* Update table */
                ((DefaultTableModel) table.getModel()).removeRow(modelRow);
            }
        };
        
        Action select = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                Category c = categoryList1.get(modelRow);
                int id = c.getId(); //((Integer) table.getValueAt(modelRow, 0));
                System.out.println(c.getId());
                setSelectedCategoryID(id);
                //System.out.println("jorge" + table.getValueAt(1, 2));
                //System.out.println("id ========="+(Integer) table.getValueAt(modelRow, 2));
                setVisible(true);
            }
        };
        
        


        ButtonColumn selectButtonColumn = new ButtonColumn(categoryTable, select, 2);
        ButtonColumn deleteButtonColumn = new ButtonColumn(categoryTable, delete, 1);

        return categoryTable;
    }
    
    public void setSelectedCategoryID(int selectedCategoryID) {
        firePropertyChange("selectedParticipantID", this.selectedCategoryID, selectedCategoryID);
        this.selectedCategoryID = selectedCategoryID;
        
    }
    
    private void KeyPressed(java.awt.event.KeyEvent evt) {                                     
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
        	categoryController.addNewCategory(jTextField1.getText());
        	jTextField1.setText("Enter New Category");
            jTable1 = getCategoryListTable();
            jScrollPane1.setViewportView(jTable1);
            jTable1.scrollRectToVisible(jTable1.getCellRect(jTable1.getRowCount()-1, jTable1.getColumnCount(), true));
            jTextField1.setCaretPosition(0);
            jTextField1.requestFocusInWindow();
            jTextField1.selectAll();
        }
    }  
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
