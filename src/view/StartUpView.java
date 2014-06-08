 package view;
 
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soumya
 */
public class StartUpView extends javax.swing.JFrame {
    private LoginView alv = new LoginView();
    private ProjectView pv = new ProjectView();
    private JButton btn = new JButton();
    private boolean isAdminMode = false;
    
    
    public boolean isAdminMode() {
		return isAdminMode;
	}
	public void setAdminMode(boolean isAdminMode) {
		this.isAdminMode = isAdminMode;
		changeMode(isAdminMode);
	}
	/**
     * Creates new form StartUpView
     */
    public StartUpView() {
        initComponents();
         Toolkit tk = Toolkit.getDefaultToolkit();//see Cay Horstman, p. 273 , Core Java I
        Dimension d = tk.getScreenSize(); //Gets the user screen size
        int scrnHigh = d.height; //Pulls out the High
        int scrnWide = d.width; //Pulls out the Wide 
        //setSize(scrnWide *9/10, scrnHigh *9/10);//sets screen to 0.9 size
        setSize(scrnWide, scrnHigh);//sets screen to FULL size
        //setLocation(scrnWide *1/20, scrnHigh *1/20);//CENTER it for 9/10th size
        setLocation(0, 0);
        desktop.setSize(getSize(d));
         try {
			setIconImage(ImageIO.read(new File("images/3_dots.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        changeMode(isAdminMode());
        SearchProjectView sv = new SearchProjectView();
        desktop.add(sv);
        sv.show();
         
    }
    public void removeAllInternalFrame(){
        for(Component c:desktop.getComponents()){
            System.out.println(c.getName());
            c.hide();
            desktop.remove(c);
        }
    }
    
    public void changeMode(boolean mode){
    	optionPane.setEnabledAt(1, mode);
    	optionPane.setEnabledAt(2, mode);
    	
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        desktop = new javax.swing.JDesktopPane();
        optionPane = new javax.swing.JTabbedPane();
        projectPane = new javax.swing.JPanel();
        btnSearchProject = new javax.swing.JButton();
        btnAddProject = new javax.swing.JButton();
        participantPane = new javax.swing.JPanel();
        btnSearchParticipant = new javax.swing.JButton();
        btnAddParticipant = new javax.swing.JButton();
        categoryPane = new javax.swing.JPanel();
        btnSearchCategory = new javax.swing.JButton();
        btnAddCategory = new javax.swing.JButton();
        adminPane = new javax.swing.JPanel();
        btnLoginMenu = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();

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

        desktop.setBackground(new java.awt.Color(255, 255, 255));
        desktop.setMinimumSize(new java.awt.Dimension(100, 100));

        optionPane.setBackground(new java.awt.Color(204, 204, 204));

        btnSearchProject.setText("Search");
        btnSearchProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProjectActionPerformed(evt);
            }
        });

        btnAddProject.setText("Add New");
        btnAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout projectPaneLayout = new javax.swing.GroupLayout(projectPane);
        projectPane.setLayout(projectPaneLayout);
        projectPaneLayout.setHorizontalGroup(
            projectPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectPaneLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnSearchProject)
                .addGap(69, 69, 69)
                .addComponent(btnAddProject)
                .addContainerGap(387, Short.MAX_VALUE))
        );
        projectPaneLayout.setVerticalGroup(
            projectPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchProject)
                    .addComponent(btnAddProject))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        optionPane.addTab("Project", projectPane);

        btnSearchParticipant.setText("Search");
        btnSearchParticipant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchParticipantActionPerformed(evt);
            }
        });

        btnAddParticipant.setText("Add New");
        btnAddParticipant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddParticipantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout participantPaneLayout = new javax.swing.GroupLayout(participantPane);
        participantPane.setLayout(participantPaneLayout);
        participantPaneLayout.setHorizontalGroup(
            participantPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantPaneLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnSearchParticipant)
                .addGap(49, 49, 49)
                .addComponent(btnAddParticipant)
                .addContainerGap(408, Short.MAX_VALUE))
        );
        participantPaneLayout.setVerticalGroup(
            participantPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(participantPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchParticipant)
                    .addComponent(btnAddParticipant))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        optionPane.addTab("Participant", participantPane);

        btnSearchCategory.setText("Search");
        btnSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCategoryActionPerformed(evt);
            }
        });

        btnAddCategory.setText("Add New");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout categoryPaneLayout = new javax.swing.GroupLayout(categoryPane);
        categoryPane.setLayout(categoryPaneLayout);
        categoryPaneLayout.setHorizontalGroup(
            categoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPaneLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnSearchCategory)
                .addGap(54, 54, 54)
                .addComponent(btnAddCategory)
                .addContainerGap(391, Short.MAX_VALUE))
        );
        categoryPaneLayout.setVerticalGroup(
            categoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(categoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchCategory)
                    .addComponent(btnAddCategory))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        optionPane.addTab("Category", categoryPane);

        adminPane.setMaximumSize(new java.awt.Dimension(100, 100));

        btnLoginMenu.setText("Login");
        btnLoginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginMenuActionPerformed(evt);
            }
        });

        btnlogout.setText("Logout");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminPaneLayout = new javax.swing.GroupLayout(adminPane);
        adminPane.setLayout(adminPaneLayout);
        adminPaneLayout.setHorizontalGroup(
            adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPaneLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnLoginMenu)
                .addGap(99, 99, 99)
                .addComponent(btnlogout)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        adminPaneLayout.setVerticalGroup(
            adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlogout)
                    .addComponent(btnLoginMenu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        optionPane.addTab("Admin Mode", adminPane);

        lblLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Soumya\\workspace\\FrugalLabProject\\FrugalLabProject\\src\\images\\frigal_logo.jpg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionPane, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogo))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(optionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnLoginMenuActionPerformed(java.awt.event.ActionEvent evt) {                                             
        removeAllInternalFrame();
        desktop.add(alv);   
        alv.show();
    }                                            

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {                                          
        System.out.println(desktop.getComponentCount());
        alv.hide();
        removeAllInternalFrame();
    }                                         

    private void btnSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void btnSearchParticipantActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void btnAddParticipantActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void btnSearchProjectActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        removeAllInternalFrame();
        SearchProjectView sv = new SearchProjectView();
        desktop.add(sv);
        sv.show();
    }                                                

    private void btnAddProjectActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	removeAllInternalFrame();
        desktop.add(pv);
        pv.show();
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
            java.util.logging.Logger.getLogger(StartUpView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartUpView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartUpView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartUpView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartUpView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    protected javax.swing.JPanel adminPane;
    protected javax.swing.JButton btnAddCategory;
    protected javax.swing.JButton btnAddParticipant;
    protected javax.swing.JButton btnAddProject;
    protected javax.swing.JButton btnLoginMenu;
    protected javax.swing.JButton btnSearchCategory;
    protected javax.swing.JButton btnSearchParticipant;
    protected javax.swing.JButton btnSearchProject;
    protected javax.swing.JButton btnlogout;
    protected javax.swing.JPanel categoryPane;
    protected javax.swing.JDesktopPane desktop;
    protected javax.swing.JDialog jDialog1;
    protected javax.swing.JFrame jFrame1;
    protected javax.swing.JLabel lblLogo;
    protected javax.swing.JTabbedPane optionPane;
    protected javax.swing.JPanel participantPane;
    private javax.swing.JPanel projectPane;
    // End of variables declaration                   
}
