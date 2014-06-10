package view;

import javax.swing.JOptionPane;

import controller.LoginController;
import controller.ProjectController;
import controller.ProjectProperties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soumya
 */
public class LoginView extends javax.swing.JInternalFrame {
    private static final LoginController loginController = new LoginController();
    /**
     * Creates new form LoginForm
     */
    public LoginView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        loginPanel1 = new javax.swing.JPanel();
        lblUsername1 = new javax.swing.JLabel();
        lblPassword1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnAdminLogin = new javax.swing.JButton();
        btnLoginCancel = new javax.swing.JButton();
        lblError1 = new javax.swing.JLabel();

        setBorder(null);

        loginPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin Login"));

        lblUsername1.setText("Username");

        lblPassword1.setText("Password");


        btnAdminLogin.setText("Login");
        btnAdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoginActionPerformed(evt);
            }
        });

        btnLoginCancel.setText("Cancel");
        btnLoginCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginCancelActionPerformed(evt);
            }
        });

        lblError1.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout loginPanel1Layout = new javax.swing.GroupLayout(loginPanel1);
        loginPanel1.setLayout(loginPanel1Layout);
        loginPanel1Layout.setHorizontalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsername1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(lblPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdminLogin)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoginCancel))
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblError1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        loginPanel1Layout.setVerticalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdminLogin)
                    .addComponent(btnLoginCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(loginPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                                                                   

    private void btnAdminLoginActionPerformed(java.awt.event.ActionEvent evt) {    
    	if(txtUserName.getText().trim().equals("")|| txtPassword.getText().trim().equals("")){
    		lblError1.setText("Username and password both are required fileds");
    		lblError1.setVisible(true);
    		
    		ProjectProperties.isAdminMode = false;
    	}else if(loginController.validateUser(txtUserName.getText(), txtPassword.getText())){
    		lblError1.setVisible(false);
    		txtUserName.setText("");
    		txtPassword.setText("");
    		JOptionPane.showMessageDialog(this, "Login Successful!!");
    		this.hide();
            ProjectProperties.isAdminMode = false;
    	}else{
    		lblError1.setText("Invalid Login details.Try again!!");
    		lblError1.setVisible(true);
    		txtUserName.setText("");
    		txtPassword.setText("");
            ProjectProperties.isAdminMode = false;
    	}

    }                                             

    private void btnLoginCancelActionPerformed(java.awt.event.ActionEvent evt) { 
		lblError1.setVisible(false);
    	txtUserName.setText("");
		txtPassword.setText("");
        ProjectProperties.isAdminMode = false;
        this.hide();
    }                                              

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdminLogin;
    private javax.swing.JButton btnLoginCancel;
    private javax.swing.JLabel lblError1;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JPanel loginPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration                   
}
