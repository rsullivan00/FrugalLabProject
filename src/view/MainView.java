/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.*;
import java.util.Arrays;

/**
 *
 * @author Soumya
 */
public class MainView extends javax.swing.JFrame {

    private static boolean isAdminMode = false;
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        changeMode(false);
    }
    
    public static boolean getAdminMode() {
		return isAdminMode;
	}

	public static void setAdminMode(boolean isAdminMode) {
		MainView.isAdminMode = isAdminMode;
	}

	public void changeMode(boolean mode){
        setAdminMode(mode);
		System.out.println(mode);
		categoryMenu.setVisible(mode);
        projectAddMenu.setVisible(mode);
        projectModifyMenu.setVisible(mode);
        participantMenu.setVisible(mode);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        mainPanel = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        adminMenu = new javax.swing.JMenu();
        loginMenu = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenuItem();
        categoryMenu = new javax.swing.JMenu();
        categoryAddMenu = new javax.swing.JMenuItem();
        categoryModifyMenu = new javax.swing.JMenuItem();
        categoryViewMenu = new javax.swing.JMenuItem();
        participantMenu = new javax.swing.JMenu();
        participantAddMenu = new javax.swing.JMenuItem();
        participantModifyMenu = new javax.swing.JMenuItem();
        participantViewMenu = new javax.swing.JMenuItem();
        projectMenu = new javax.swing.JMenu();
        projectAddMenu = new javax.swing.JMenuItem();
        projectModifyMenu = new javax.swing.JMenuItem();
        projectViewMenu = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        mainMenuBar.setAutoscrolls(true);

        adminMenu.setText("Admin Mode");
        adminMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminMenuActionPerformed(evt);
            }
        });

        loginMenu.setText("Login");
        loginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuActionPerformed(evt);
            }
        });
        adminMenu.add(loginMenu);

        logoutMenu.setText("Logout");
        logoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuActionPerformed(evt);
            }
        });
        adminMenu.add(logoutMenu);

        mainMenuBar.add(adminMenu);
        adminMenu.getAccessibleContext().setAccessibleParent(this);

        categoryMenu.setText("Category");

        categoryAddMenu.setText("Add");
        categoryAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryAddMenuActionPerformed(evt);
            }
        });
        categoryMenu.add(categoryAddMenu);

        categoryModifyMenu.setText("Modify");
        categoryModifyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryModifyMenuActionPerformed(evt);
            }
        });
        categoryMenu.add(categoryModifyMenu);

        categoryViewMenu.setText("view");
        categoryViewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryViewMenuActionPerformed(evt);
            }
        });
        categoryMenu.add(categoryViewMenu);

        mainMenuBar.add(categoryMenu);

        participantMenu.setText("Participants");
        participantMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantMenuActionPerformed(evt);
            }
        });

        participantAddMenu.setText("Add");
        participantAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantAddMenuActionPerformed(evt);
            }
        });
        participantMenu.add(participantAddMenu);

        participantModifyMenu.setText("Modify");
        participantModifyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantModifyMenuActionPerformed(evt);
            }
        });
        participantMenu.add(participantModifyMenu);

        participantViewMenu.setText("view");
        participantViewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantViewMenuActionPerformed(evt);
            }
        });
        participantMenu.add(participantViewMenu);

        mainMenuBar.add(participantMenu);

        projectMenu.setText("Projects");

        projectAddMenu.setText("Add");
        projectAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectAddMenuActionPerformed(evt);
            }
        });
        projectMenu.add(projectAddMenu);

        projectModifyMenu.setText("Modify");
        projectModifyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectModifyMenuActionPerformed(evt);
            }
        });
        projectMenu.add(projectModifyMenu);

        projectViewMenu.setText("view");
        projectViewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectViewMenuActionPerformed(evt);
            }
        });
        projectMenu.add(projectViewMenu);

        mainMenuBar.add(projectMenu);
        
        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void categoryAddMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void categoryViewMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void adminMenuActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
    }                                         

    private void participantAddMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void categoryModifyMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void participantMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void participantModifyMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void participantViewMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.out.println("Participant view clicked");
    	System.out.println(Arrays.toString(mainPanel.getComponents()));
    	mainPanel.removeAll();
    	mainPanel.repaint();
        mainPanel.revalidate();
        JInternalFrame participantView = new SearchParticipantView();

        mainPanel.add(participantView);
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.setVisible(true);
    }                                                   

    private void projectAddMenuActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void projectModifyMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void projectViewMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                
        System.out.println("Project view clicked");
    	System.out.println(mainPanel.getComponents());
    	mainPanel.removeAll();
    	mainPanel.repaint();
        mainPanel.revalidate();
    	JInternalFrame projectView =  new ProjectView();

        projectView.pack();
        projectView.setVisible(true);

        mainPanel.add(projectView);
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.setVisible(true);
    }                                               

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	System.out.println("login clicked");
    	System.out.println(mainPanel.getComponents());
    	mainPanel.removeAll();
    	mainPanel.repaint();
        mainPanel.revalidate();
    	JInternalFrame loginView =  new LoginView();
        loginView.pack();
        loginView.setVisible(true);
        mainPanel.add(loginView);
        mainPanel.repaint();
        mainPanel.revalidate();
        mainPanel.setVisible(true);
    }

    private void logoutMenuActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JMenu adminMenu;
    private javax.swing.JMenuItem categoryAddMenu;
    private javax.swing.JMenu categoryMenu;
    private javax.swing.JMenuItem categoryModifyMenu;
    private javax.swing.JMenuItem categoryViewMenu;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenuItem loginMenu;
    private javax.swing.JMenuItem logoutMenu;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem participantAddMenu;
    private javax.swing.JMenu participantMenu;
    private javax.swing.JMenuItem participantModifyMenu;
    private javax.swing.JMenuItem participantViewMenu;
    private javax.swing.JMenuItem projectAddMenu;
    private javax.swing.JMenu projectMenu;
    private javax.swing.JMenuItem projectModifyMenu;
    private javax.swing.JMenuItem projectViewMenu;
    // End of variables declaration                   
}