package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.eclipse.persistence.transaction.jotm.JotmTransactionController;

import model.Category;
import model.Participant;
import model.Project;
import model.ProjectFile;
import controller.FileController;
import controller.ProjectController;
import controller.ProjectProperties;

/**
 *
 * @author Soumya
 */
public class ProjectView extends javax.swing.JInternalFrame implements Printable, PropertyChangeListener {
	private ProjectController projectController;
	private FileController fileController;
	Set<String> projectFiles = new HashSet<String>();
	private ProjectProperties prop = new ProjectProperties();
	//Variables for adding and updating project dependencies
	Set<Integer> deletedParticipantIds = new HashSet<Integer>();
	Set<Integer> deletedCategoryIds = new HashSet<Integer>();
	Set<Integer> newParticipantIds = new HashSet<Integer>();
	Set<Integer> newCategoryIds = new HashSet<Integer>();
	Set<Integer> deletedFileIds = new HashSet<Integer>();
	List<String> deletedFileNames = new ArrayList<String>();
	String directoryPath ="";
	HashMap<String, ProjectFile> p = new HashMap<String, ProjectFile>();
	private Project project;
	private JDesktopPane desktop;
	JTable jt,categoryTable,participantTable;
	List<Participant> participants;
	int initCounter;
    /**
     * Creates new form NewJInternalFrame
     */
    public ProjectView(JDesktopPane desktop) {
        initComponents();
        this.desktop = desktop;
        projectController = new ProjectController(desktop);
        fileController = new FileController();
        projectTableinitializer();
        loadFileListTable(new ArrayList<ProjectFile>());
        initCounter =0;
        btnDeleteProject.setVisible(false);
        btnPrint.setVisible(false);
        btnOpenProject.setVisible(false);
    }

    public ProjectView(Project project) {
        initComponents();
        this.project = project;
        setProjectValues(project);
        fileController = new FileController();
        projectController = new ProjectController(project.getProjectFiles(),desktop);
        projectTableinitializer();
        List<ProjectFile> existingFiles = project.getProjectFiles();
        for(ProjectFile file :existingFiles){
        	p.put(file.getFileName(), file);
        }
        List<ProjectFile> list = new ArrayList<ProjectFile>();
		    for(String key:p.keySet())
		    	list.add(p.get(key));
 		loadFileListTable(list);
        participants = new ArrayList<Participant>();
        participants.addAll(project.getParticipants());
        loadParticipantListTable(participants);
        initCounter =0;
        btnDeleteProject.setVisible(false);
        btnPrint.setVisible(true);
    	btnOpenProject.setVisible(true);
        if(ProjectProperties.isAdminMode){
        	btnAddProjCat.setVisible(true);
        	btnAddProjFiles.setVisible(true);
        	btnAddProjHyperlinks.setVisible(true);
        	btnSaveProject.setVisible(true);
        	btnAddProjPart.setVisible(true);
        }else{
        	btnAddProjCat.setVisible(false);
        	btnAddProjFiles.setVisible(false);
        	btnAddProjHyperlinks.setVisible(false);
        	btnSaveProject.setVisible(false);
        	btnAddProjPart.setVisible(false);
        }
        	
    }
    
    public void projectTableinitializer(){
    	jt =  new JTable();
    	categoryTable = new JTable();
    	participantTable = new JTable();
    	JScrollPane scrollpane = new JScrollPane(jt);
    	projResourcePane.setLayout(new FlowLayout());
    	projResourcePane.add(scrollpane);
    	JScrollPane catScrollpane = new JScrollPane(categoryTable);
    	projCategoryPane.setLayout(new FlowLayout());
    	projCategoryPane.add(catScrollpane);
     	JScrollPane pScrollpane = new JScrollPane(participantTable);
     	projParticipantPane.setLayout(new FlowLayout());
     	projParticipantPane.add(pScrollpane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        basicProjPanel = new javax.swing.JPanel();
        lblProjectName = new javax.swing.JLabel();
        lblProjectStatus = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblStreetAddress = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblZip = new javax.swing.JLabel();
        lblOutcome = new javax.swing.JLabel();
        txtProjectName = new javax.swing.JTextField();
        comboStatus = new javax.swing.JComboBox();
        startDate = new com.toedter.calendar.JDateChooser();
        endDate = new com.toedter.calendar.JDateChooser();
        txtStreetAddress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtZipCode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaOutcome = new javax.swing.JTextArea();
        projectOptionsPanel = new javax.swing.JPanel();
        btnAddProjPart = new javax.swing.JButton();
        btnAddProjCat = new javax.swing.JButton();
        btnAddProjFiles = new javax.swing.JButton();
        btnAddProjHyperlinks = new javax.swing.JButton();
        btnOpenProject = new javax.swing.JButton();
        btnSaveProject = new javax.swing.JButton();
        btnDeleteProject = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        lblCity1 = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        txtProjectId = new javax.swing.JTextField();
        projDependencyTab = new javax.swing.JTabbedPane();
        projResourcePane = new javax.swing.JPanel();
        projCategoryPane = new javax.swing.JPanel();
        projParticipantPane = new javax.swing.JPanel();

        setClosable(true);
        setResizable(true);

        basicProjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Project Details"));
        basicProjPanel.setName(""); // NOI18N

        lblProjectName.setText("Name");

        lblProjectStatus.setText("Staus");

        lblStartDate.setText("Start Date");

        jLabel4.setText("End Date");

        lblStreetAddress.setText("Street Address");

        lblCity.setText("City");

        lblCountry.setText("Country");

        lblZip.setText("Zip");

        lblOutcome.setText("Outcome");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Completed", "Suspended", "Aborted" }));

        txtAreaOutcome.setColumns(20);
        txtAreaOutcome.setRows(5);
        jScrollPane1.setViewportView(txtAreaOutcome);

        btnAddProjPart.setIcon(new javax.swing.ImageIcon("images/participant.png"));
        btnAddProjPart.setText("Add Participant");
        btnAddProjPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjPartActionPerformed(evt);
            }
        });

        btnAddProjCat.setIcon(new javax.swing.ImageIcon("images/category.png"));
        btnAddProjCat.setText("Add Category");
        btnAddProjCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjCatActionPerformed(evt);
            }
        });

        btnAddProjFiles.setIcon(new javax.swing.ImageIcon("images/file.png"));
        btnAddProjFiles.setText("Add Files");
        btnAddProjFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjFilesActionPerformed(evt);
            }
        });

        btnAddProjHyperlinks.setIcon(new javax.swing.ImageIcon("images/hyperlink.png"));
        btnAddProjHyperlinks.setText("Add Hyperlinks");
        btnAddProjHyperlinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProjHyperlinksActionPerformed(evt);
            }
        });

        btnSaveProject.setIcon(new javax.swing.ImageIcon("images/save.png"));
        btnSaveProject.setText("Save Project");
        btnSaveProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProjectActionPerformed(evt);
            }
        });

        
        btnDeleteProject.setText("Delete Project");
        btnDeleteProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProjectActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon("images/print.png"));
        btnPrint.setText("Print Project Profile");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        
        btnOpenProject.setIcon(new javax.swing.ImageIcon("images/open.png"));
        btnOpenProject.setText("Open Project Folder");
        btnOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenProjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout projectOptionsPanelLayout = new javax.swing.GroupLayout(projectOptionsPanel);
        projectOptionsPanel.setLayout(projectOptionsPanelLayout);
        projectOptionsPanelLayout.setHorizontalGroup(
            projectOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProjCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddProjFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddProjHyperlinks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddProjPart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpenProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        projectOptionsPanelLayout.setVerticalGroup(
            projectOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddProjPart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddProjCat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddProjFiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddProjHyperlinks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteProject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrint)
                .addComponent(btnOpenProject)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        lblCity1.setText("State");

        txtProjectId.setVisible(false);

        javax.swing.GroupLayout basicProjPanelLayout = new javax.swing.GroupLayout(basicProjPanel);
        basicProjPanel.setLayout(basicProjPanelLayout);
        basicProjPanelLayout.setHorizontalGroup(
            basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicProjPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblProjectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStartDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCountry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblZip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblOutcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCity1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProjectId, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtProjectName)
                        .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtStreetAddress)
                        .addComponent(txtCity)
                        .addComponent(txtCountry)
                        .addComponent(txtZipCode)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                        .addComponent(txtState)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(projectOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        basicProjPanelLayout.setVerticalGroup(
            basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basicProjPanelLayout.createSequentialGroup()
                .addComponent(txtProjectId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basicProjPanelLayout.createSequentialGroup()
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProjectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblZip, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicProjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout projResourcePaneLayout = new javax.swing.GroupLayout(projResourcePane);
        projResourcePane.setLayout(projResourcePaneLayout);
        projResourcePaneLayout.setHorizontalGroup(
            projResourcePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        projResourcePaneLayout.setVerticalGroup(
            projResourcePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );

        projDependencyTab.addTab("Resources", projResourcePane);

        javax.swing.GroupLayout projCategoryPaneLayout = new javax.swing.GroupLayout(projCategoryPane);
        projCategoryPane.setLayout(projCategoryPaneLayout);
        projCategoryPaneLayout.setHorizontalGroup(
            projCategoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        projCategoryPaneLayout.setVerticalGroup(
            projCategoryPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );

        projDependencyTab.addTab("Category", projCategoryPane);

        javax.swing.GroupLayout projParticipantPaneLayout = new javax.swing.GroupLayout(projParticipantPane);
        projParticipantPane.setLayout(projParticipantPaneLayout);
        projParticipantPaneLayout.setHorizontalGroup(
            projParticipantPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        projParticipantPaneLayout.setVerticalGroup(
            projParticipantPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );

        projDependencyTab.addTab("Participants", projParticipantPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projDependencyTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(basicProjPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(basicProjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projDependencyTab, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnAddProjFilesActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          //open a dialog box to select files 
          File file = chooser.getSelectedFile();
          System.out.println(file.getPath());

	          // update the title of the image
	          System.out.println(file.getName());
	          ProjectProperties prop = new ProjectProperties();
	          //Project project = projectController.getProjectById(Integer.parseInt(txtProjectId.getText()));
  			//Project project = projectController.getProjectById(1);
	        
  			String dirPath;
  			if(project == null){
  				dirPath = prop.getDirectory(prop.getProjectPath(),"tempProject");
  				File destinationPath = new File(dirPath);
  				if(initCounter==0){
  					for(File previousFiles: destinationPath.listFiles()) 
  						previousFiles.delete();
  					initCounter++;
  				}
  			}else{
  				dirPath = project.getProjectLocation();
  			}
  			System.out.println(dirPath);
  			File destinationPath = new File(dirPath);
  			directoryPath = dirPath;
  		    if ((destinationPath.isDirectory()) && (file.isFile()))
  		    //both source and destination paths are available 
  		    {
  		        //creating object for File class
  		        File statusFileNameObject = new File(dirPath + "\\" + file.getName());
  		        try {
					Files.copy(file.toPath(), statusFileNameObject.toPath(),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
  		        
  		        System.out.println("add file"+file.getName());
  		        if(p.get(file.getName())==null){
  		        	p.put(file.getName(),new ProjectFile(0, dirPath, file.getName(), null, null));
  		        	projectFiles.add(file.getName());
  		        }
  		        
  		    }
  		    List<ProjectFile> list = new ArrayList<ProjectFile>();
  		    for(String key:p.keySet())
  		    	list.add(p.get(key));
  		  ProjectController pc = new ProjectController(list, desktop);
  		  loadFileListTable(list);
  		  
        }
    }   
    
    public void deleteFile(String fileName,String rootDirectory){
    	 try{
    		 
     		File file = new File(rootDirectory + "\\" + fileName);
     		List<ProjectFile> list = new ArrayList<ProjectFile>();
   		    for(String key:p.keySet())
   		    	list.add(p.get(key));
     		loadFileListTable(list);
     		if(file.delete()){
     			System.out.println(file.getName() + " is deleted!");
     		}else{
     			System.out.println("Delete operation is failed.");
     		}
  
     	}catch(Exception e){
  
     		e.printStackTrace();
  
     	}
    }
    private void btnOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	File projectPath = new File (project.getProjectLocation());
        Desktop explorer = Desktop.getDesktop();
        try {
			explorer.open(projectPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 

    private void btnAddProjPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProjPartActionPerformed
        SearchParticipantView view = new SearchParticipantView(true);
        view.addPropertyChangeListener("selectedParticipantID", this);
        view.setVisible(true);
        this.getParent().add(view);
        view.moveToFront();
    }//GEN-LAST:event_btnAddProjPartActionPerformed

    private void btnAddProjCatActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnAddProjHyperlinksActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    	showAddHyperlink();
    }                                                    

    private void btnSaveProjectActionPerformed(java.awt.event.ActionEvent evt) { 
    	System.out.println(newParticipantIds.size());
    	if(returnNullIfEmpty(txtProjectName.getText())==null){
    		JOptionPane.showMessageDialog(this, "Enter project name");
    	}else if(returnNullIfEmpty(txtZipCode.getText())!=null){
    		try { 
    	        Integer.parseInt(txtZipCode.getText()); 
    	        if(txtProjectId.getText().equals("")){
    	    		Project project = projectController.addNewProject(txtProjectName.getText(), comboStatus.getSelectedItem().toString(), returnNullIfEmpty(txtAreaOutcome.getText()),returnNullIfEmpty(txtState.getText()), returnNullIfEmpty(txtStreetAddress.getText()), returnNullIfEmpty(txtCity.getText()), returnNullIfEmpty(txtCountry.getText()), returnNullIfEmpty(txtZipCode.getText())==null?null:Integer.parseInt(txtZipCode.getText()), startDate.getDate(), endDate.getDate(),prop.getProjectPath(),projectFiles,newParticipantIds,newCategoryIds);
    	    		createFinalProjectDir(project.getProjectID(), project.getProjectName());
    	    		JOptionPane.showMessageDialog(this, "Project Saved");
    	    		this.hide();
        		}else{
        			System.out.println("before update"+deletedFileIds.size());
        			System.out.println("before update"+projectFiles.size());
        			Project project = projectController.updateProject(Integer.parseInt(txtProjectId.getText()),txtProjectName.getText(), comboStatus.getSelectedItem().toString(), returnNullIfEmpty(txtAreaOutcome.getText()),returnNullIfEmpty(txtState.getText()), returnNullIfEmpty(txtStreetAddress.getText()), returnNullIfEmpty(txtCity.getText()), returnNullIfEmpty(txtCountry.getText()), returnNullIfEmpty(txtZipCode.getText())==null?null:Integer.parseInt(txtZipCode.getText()), startDate.getDate(), endDate.getDate(),directoryPath,projectFiles,deletedFileIds,deletedParticipantIds,newParticipantIds,deletedCategoryIds,newCategoryIds);
        			System.out.println("after update "+project.getProjectFiles().size());
        			for(String filename :deletedFileNames){
        				try{
        		    		 
        		     		File file = new File(directoryPath + "\\" + filename);
        		     		if(file.delete()){
        		     			System.out.println(file.getName() + " is deleted!");
        		     		}else{
        		     			System.out.println("Delete operation is failed.");
        		     		}
        		  
        		     	}catch(Exception e){
        		  
        		     		e.printStackTrace();
        		  
        		     	}
        			}
        			JOptionPane.showMessageDialog(this, "Project Updated");
    	    		this.hide();
    	    	}
    	    } catch(NumberFormatException e) { 
    	    	JOptionPane.showMessageDialog(this, "Enter number for zip code");
    	    }
    		
    	}else{
    		if(txtProjectId.getText().equals("")){
    			System.out.println("new participant  "+newParticipantIds.size());
	    		Project project = projectController.addNewProject(txtProjectName.getText(), comboStatus.getSelectedItem().toString(), returnNullIfEmpty(txtAreaOutcome.getText()),returnNullIfEmpty(txtState.getText()), returnNullIfEmpty(txtStreetAddress.getText()), returnNullIfEmpty(txtCity.getText()), returnNullIfEmpty(txtCountry.getText()), returnNullIfEmpty(txtZipCode.getText())==null?null:Integer.parseInt(txtZipCode.getText()), startDate.getDate(), endDate.getDate(),prop.getProjectPath(),projectFiles,newParticipantIds,newCategoryIds);
	    		createFinalProjectDir(project.getProjectID(), project.getProjectName());
	    		JOptionPane.showMessageDialog(this, "Project Saved");
	    		this.hide();
    		}else{
    			System.out.println("before update"+deletedFileIds.size());
    			System.out.println("before update"+projectFiles.size());
    			Project project = projectController.updateProject(Integer.parseInt(txtProjectId.getText()),txtProjectName.getText(), comboStatus.getSelectedItem().toString(), returnNullIfEmpty(txtAreaOutcome.getText()),returnNullIfEmpty(txtState.getText()), returnNullIfEmpty(txtStreetAddress.getText()), returnNullIfEmpty(txtCity.getText()), returnNullIfEmpty(txtCountry.getText()), returnNullIfEmpty(txtZipCode.getText())==null?null:Integer.parseInt(txtZipCode.getText()), startDate.getDate(), endDate.getDate(),directoryPath,projectFiles,deletedFileIds,deletedParticipantIds,newParticipantIds,deletedCategoryIds,newCategoryIds);
    			System.out.println("after update "+project.getProjectFiles().size());
    			JOptionPane.showMessageDialog(this, "Project Updated");
	    		this.hide();
	    	}
    	}

    }  
    
    public void updateProjectDir(){
    	
    }

    private void btnDeleteProjectActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                 job.print();
            } catch (PrinterException ex) {
            
            }
        }
    }  
    
    public String returnNullIfEmpty(String value){
    	return value.trim().equals("")?null:value;
    }
    public void loadFileListTable(List<ProjectFile> flist){
    	jt.setModel(getProjectFileTable(flist));
    	 if (ProjectProperties.isAdminMode) {
             Action delete = new AbstractAction() {
                 public void actionPerformed(ActionEvent e) {
                     JTable table = (JTable) e.getSource();
                     int modelRow = Integer.valueOf(e.getActionCommand());
                     int id = ((Integer) table.getValueAt(modelRow, 0));
                     String filename = ((String) table.getValueAt(modelRow, 2));
                     System.out.println("delete file called "+id);
                     if(id!=0){
                      	deletedFileIds.add(id);
                      	deletedFileNames.add(filename);
                      	System.out.println("deleted file "+deletedFileIds.size());
                     }else{
                     	projectFiles.remove(filename);
                     }
                     deleteFile(filename,p.get(filename).getFilePath());
                     ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                 }
             };

             ButtonColumn deleteButtonColumn = new ButtonColumn(jt, delete, 4);
         }
    	System.out.println(flist.size());
    }
    
    public DefaultTableModel getProjectFileTable(List<ProjectFile> flist){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("Path");
        columnNames.add("Name");
        columnNames.add("Type");
        if (ProjectProperties.isAdminMode) {
            columnNames.add("Delete");
        }
        final Vector<Vector> projectFileList = new Vector<Vector>();

        for(final ProjectFile file: flist){
            Vector<Object> rowData = new Vector<Object>();
            rowData.add(file.getFileID());
            rowData.add(file.getFilePath());
            rowData.add(file.getFileName());
            rowData.add(file.getFileType());
            if(ProjectProperties.isAdminMode){
                rowData.add("Delete");
            } 
            projectFileList.add(rowData);
        }

        DefaultTableModel model = new DefaultTableModel(projectFileList, columnNames);
        return model;
    }
    
    public void loadCategoryListTable(List<ProjectFile> flist){
    	categoryTable.setModel(getProjectFileTable(flist));
    	 if (ProjectProperties.isAdminMode) {
             Action delete = new AbstractAction() {
                 public void actionPerformed(ActionEvent e) {
                     JTable table = (JTable) e.getSource();
                     int modelRow = Integer.valueOf(e.getActionCommand());
                     int id = ((Integer) table.getValueAt(modelRow, 0));
                     if(id!=0){
                    	 deletedCategoryIds.add(id);
                    	 p.remove(((String) table.getValueAt(modelRow, 2)));
                     }else{
                     	projectFiles.remove(((String) table.getValueAt(modelRow, 2)));
                     	p.remove(((String) table.getValueAt(modelRow, 2)));
                     	System.out.println("file number"+p.size());
                     	deleteFile(((String) table.getValueAt(modelRow, 2)),prop.getDirectory(prop.getProjectPath(),"tempProject"));
                     }
                     ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                 }
             };

             ButtonColumn deleteButtonColumn = new ButtonColumn(categoryTable, delete, 2);
         }
    	System.out.println(flist.size());
    }
    
    public DefaultTableModel getCategoryTable(List<Category> list){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("Name");
        if (ProjectProperties.isAdminMode) {
            columnNames.add("Delete");
        }
        final Vector<Vector> vlist = new Vector<Vector>();

        for(final Category c: list){
            Vector<Object> rowData = new Vector<Object>();
            rowData.add(c.getId());
            rowData.add(c.getCategoryName());
            if(ProjectProperties.isAdminMode){
                rowData.add("Delete");
            } 
            vlist.add(rowData);
        }

        DefaultTableModel model = new DefaultTableModel(vlist, columnNames);
        return model;
    }
    
    public void loadParticipantListTable(List<Participant> list){
    	participantTable.setModel(getParticipantTable(list));
    	 if (ProjectProperties.isAdminMode) {
             Action delete = new AbstractAction() {
                 public void actionPerformed(ActionEvent e) {
                     JTable table = (JTable) e.getSource();
                     int modelRow = Integer.valueOf(e.getActionCommand());
                     int id = ((Integer) table.getValueAt(modelRow, 0));
                     if(id!=0){
                     }else{
                     	projectFiles.remove(((String) table.getValueAt(modelRow, 2)));
                     	deleteFile(((String) table.getValueAt(modelRow, 2)),prop.getDirectory(prop.getProjectPath(),"tempProject"));
                     }
                     ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                 }
             };

             ButtonColumn deleteButtonColumn = new ButtonColumn(participantTable, delete, 4);
         }
    	System.out.println(list.size());
    }
    
    public DefaultTableModel getParticipantTable(List<Participant> list){
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("First Name");
        columnNames.add("Last Name");
        columnNames.add("Role");
        if (ProjectProperties.isAdminMode) {
            columnNames.add("Delete");
        }
        final Vector<Vector> vlist = new Vector<Vector>();

        for(final Participant p: list){
            Vector<Object> rowData = new Vector<Object>();
            rowData.add(p.getId());
            rowData.add(p.getFirstName());
            rowData.add(p.getLastName());
            rowData.add(p.getRole());
            if(ProjectProperties.isAdminMode){
                rowData.add("Delete");
            } 
            vlist.add(rowData);
        }

        DefaultTableModel model = new DefaultTableModel(vlist, columnNames);
        return model;
    }
    
    
    public int print(Graphics g, PageFormat pf, int page) throws
    PrinterException {

		if (page > 0) {
			return NO_SUCH_PAGE;
		}
		BufferedImage picture = null;
	    try {
	      picture = ImageIO.read(new File(prop.getAbsolutePath()+"\\images\\frigal_logo.jpg"));
	    } catch (IOException e) {    
	      System.out.println("An error has occurred while reading image file. Check that file exists and is in the correct directory.");
	       System.exit(1);
	    }
		
		/* User (0,0) is typically outside the imageable area, so we must
		* translate by the X and Y values in the PageFormat to avoid clipping
		*/
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		
		/* Now we perform our rendering */
		g.setFont(new Font("TimesRoman", Font.BOLD, 16));
		int x = (int)(pf.getImageableWidth()/4);
		int y = 150;
		g.drawImage(picture,x, 50,null);
		g.drawString("Project Profile", x, y);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
		x = 100;
		//Project project = projectController.getProjectById(Integer.parseInt(txtProjectId.getText()));
		g.drawString("Project Name :", x, y+=30);
		g.drawString(project.getProjectName(), 200, y);
		g.drawString("Status :", x, y+=30);
		g.drawString(project.getStatus(), 200, y);
		g.drawString("Start Date :", x, y+=30);
		g.drawString((project.getStartDate()==null?"Not available":project.getStartDate())+"",200, y);
		g.drawString("End Date :", x, y+=30);
		g.drawString((project.getEndDate()==null?"Not available":project.getEndDate())+"", 200, y);
		if(project.getParticipants()!=null){
			g.drawString("Participants : ", x, y+=40);
			for(Participant p :project.getParticipants()){
				g.drawString(p.getFirstName()+" "+p.getLastName(), x, y+=20);
			}
		}
		
		/* tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}
    
    public void createFinalProjectDir(int projectId,String projectName){
    	ProjectProperties prop = new ProjectProperties();
		String sourceDirPath = prop.getDirectory(prop.getProjectPath(),"tempProject");
		File dir = new File(sourceDirPath);  
        File destDir = new File(prop.getDirectory(prop.getProjectPath(),projectName+"_"+projectId));  
        if ( dir.isDirectory() && destDir.isDirectory()) { 
        	destDir.delete();
                dir.renameTo(destDir);  
                System.out.println("renamed");
        }
    }

    public void setProjectValues(Project proj){
    	txtProjectId.setText(Integer.toString(proj.getProjectID()));
    	txtProjectName.setText(proj.getProjectName());
    	comboStatus.setSelectedItem(proj.getStatus());
    	startDate.setDate(proj.getStartDate()!=null?new Date(proj.getStartDate().getTime()):null);
    	endDate.setDate(proj.getEndDate()!=null?new Date(proj.getEndDate().getTime()):null);
    	txtState.setText(proj.getState());
    	txtStreetAddress.setText(proj.getStreetAddress());
    	txtCity.setText(proj.getCity());
    	txtCountry.setText(proj.getCountry());
    	txtZipCode.setText(proj.getZipCode()!=null?Integer.toString(proj.getZipCode()):null);
    }
    
    public void showAddHyperlink(){
       
        String result = JOptionPane.showInputDialog(this, "Hyperlink","Enter Hyperlink");
        if (result != null) {
        	
           System.out.println("y value: " + result);
           if(isValidURL(result)){
        	   projectFiles.add("#"+result);
        	   p.put(result,new ProjectFile(0, "", result, "hyperlink", null));
       		 	List<ProjectFile> list = new ArrayList<ProjectFile>();
     		    for(String key:p.keySet())
     		    	list.add(p.get(key));
       		loadFileListTable(list);
           }else
        	   
        	   JOptionPane.showMessageDialog(this, "Invalid hyperlink.Retry!!");
        	}
    }
    public boolean isValidURL(String url){
    	 URL u = null;
         try {
             u = new URL(url);
         } catch (MalformedURLException e) {
             return false;
         }
         try {
             u.toURI();
         } catch (URISyntaxException e) {
             return false;
         }
         return true;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object source = evt.getSource();
        if (source instanceof SearchParticipantView) {
            int selectedID = ((Integer) evt.getNewValue());
            /* Add participant with corresponding ID now */
            System.out.println("selected participant "+selectedID);
            newParticipantIds.add(selectedID);
        }
    }
    // Variables declaration - do not modify                     
    private javax.swing.JPanel basicProjPanel;
    private javax.swing.JButton btnAddProjCat;
    private javax.swing.JButton btnAddProjFiles;
    private javax.swing.JButton btnAddProjHyperlinks;
    private javax.swing.JButton btnAddProjPart;
    private javax.swing.JButton btnDeleteProject;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSaveProject;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JButton btnOpenProject;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaOutcome;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCity1;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblOutcome;
    private javax.swing.JLabel lblProjectName;
    private javax.swing.JLabel lblProjectStatus;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStreetAddress;
    private javax.swing.JLabel lblZip;
    private javax.swing.JPanel projCategoryPane;
    private javax.swing.JTabbedPane projDependencyTab;
    private javax.swing.JPanel projParticipantPane;
    private javax.swing.JPanel projResourcePane;
    private javax.swing.JPanel projectOptionsPanel;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtProjectId;
    private javax.swing.JTextField txtProjectName;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreetAddress;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration                   
}
