package view;

import java.awt.Dimension;

import controller.LoginController;

/**
 * Created by Rick on 5/30/2014.
 */
public class LoginView extends javax.swing.JPanel {

	    /**
	     * Creates new form LoginView1
	     */
	private MainView mv;
	    public LoginView() {
	        initComponents();
	        mv = new MainView();
	        lblError.setVisible(false);
	        setSize(new Dimension(750, 750));
	    }

	    /**
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        loginPanel = new javax.swing.JPanel();
	        lblUsername = new javax.swing.JLabel();
	        lblPassword = new javax.swing.JLabel();
	        txtUserName = new javax.swing.JTextField();
	        txtPassword = new javax.swing.JTextField();
	        btnLogin = new javax.swing.JButton();
	        btnCancel = new javax.swing.JButton();
	        lblError = new javax.swing.JLabel();

	        loginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin Login"));

	        lblUsername.setText("Username");

	        lblPassword.setText("Password");

	        txtUserName.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                txtUserNameActionPerformed(evt);
	            }
	        });

	        btnLogin.setText("Login");
	        btnLogin.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnLoginActionPerformed(evt);
	            }
	        });

	        btnCancel.setText("Cancel");
	        btnCancel.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnCancelActionPerformed(evt);
	            }
	        });

	        lblError.setForeground(new java.awt.Color(255, 0, 0));

	        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
	        loginPanel.setLayout(loginPanelLayout);
	        loginPanelLayout.setHorizontalGroup(
	            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(loginPanelLayout.createSequentialGroup()
	                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(loginPanelLayout.createSequentialGroup()
	                        .addGap(55, 55, 55)
	                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
	                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addGap(28, 28, 28)
	                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(loginPanelLayout.createSequentialGroup()
	                                .addComponent(btnLogin)
	                                .addGap(26, 26, 26)
	                                .addComponent(btnCancel))
	                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(loginPanelLayout.createSequentialGroup()
	                        .addGap(36, 36, 36)
	                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(34, Short.MAX_VALUE))
	        );
	        loginPanelLayout.setVerticalGroup(
	            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(loginPanelLayout.createSequentialGroup()
	                .addGap(31, 31, 31)
	                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(txtUserName))
	                .addGap(26, 26, 26)
	                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(30, 30, 30)
	                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnLogin)
	                    .addComponent(btnCancel))
	                .addGap(37, 37, 37)
	                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 10, Short.MAX_VALUE))
	        );
	    }// </editor-fold>                        

	    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {                                            
	        // TODO add your handling code here:
	    }                                           

	    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
	       LoginController lc = new LoginController();
	       if(lc.validateUser(txtUserName.getText(), txtPassword.getText())){
	    	  mv.setAdminMode(true);
	    	  lblError.setVisible(false);
	       }else{
	    	   mv.setAdminMode(false);
	    	   lblError.setText("Invalid credentials.Try Again!!");
	    	   lblError.setVisible(true);
	       }
	    }                                        

	    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {   
	    	mv.removeAll();
	        mv.repaint();
	        mv.revalidate();
	    }                                         

	    // Variables declaration - do not modify                     
	    private javax.swing.JButton btnCancel;
	    private javax.swing.JButton btnLogin;
	    private javax.swing.JLabel lblError;
	    private javax.swing.JLabel lblPassword;
	    private javax.swing.JLabel lblUsername;
	    private javax.swing.JPanel loginPanel;
	    private javax.swing.JTextField txtPassword;
	    private javax.swing.JTextField txtUserName;
	    // End of variables declaration                   
	}
