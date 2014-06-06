package view;

import controller.ParticipantTableController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ParticipantTableView.java
 * Created by Rick Sullivan on 5/27/2014.
 * COEN 160 Labs 7 and 8
 *
 * The ParticipantTableView creates and manages the UI for displaying the Model.Participant table.
 * It scales according to the size of the user's screen.
 */
public class ParticipantGUI extends javax.swing.JFrame {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static Font biggerFont = new Font("Bigger font", Font.PLAIN, screenSize.height/60);
    public static Dimension textFieldDimension = new Dimension(biggerFont.getSize() * 10, biggerFont.getSize() + 10);

    private ParticipantTableController participantTableController;

    private JPanel viewPanel;

    private JTable table;

    private JTextField idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField roleTextField;

    public ParticipantGUI() {
        this.participantTableController = new ParticipantTableController(this);
        createTableGUI();
    }

    public static void main(String[] args) {
        ParticipantGUI gui = new ParticipantGUI();
    }

    private void createTableGUI() {
        JFrame window = new JFrame();
        window.setSize(screenSize.width/2, screenSize.height/3);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        viewPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        viewPanel.setLayout(layout);

        window.setContentPane(viewPanel);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        addJTable(tablePanel);
        viewPanel.add(tablePanel, c);

        JPanel textFieldPanel = new JPanel();
        addTextFields(textFieldPanel);

        JPanel buttonPanel = new JPanel();
        addButtons(buttonPanel);

        c.gridy = 1;
        viewPanel.add(textFieldPanel, c);
        c.gridy = 2;
        viewPanel.add(buttonPanel, c);

        window.pack();
        window.setVisible(true);
    }

    private void addJTable(JPanel tablePanel) {
        table = new JTable(participantTableController.getTableModel());
        table.getSelectionModel().addListSelectionListener(participantTableController);
        table.setFont(biggerFont);
        table.getTableHeader().setFont(biggerFont);
        table.setRowHeight(biggerFont.getSize() + 5);

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
    }

    private void addTextFields(JPanel textFieldPanel) {
        JPanel idPanel = new JPanel();
        idTextField = new JTextField();
        idTextField.setFont(biggerFont);
        idTextField.setPreferredSize(new Dimension(biggerFont.getSize() * 4, (int) textFieldDimension.getHeight()));
        JLabel idLabel = new JLabel("id");
        idLabel.setFont(biggerFont);
        idPanel.add(idLabel);
        idPanel.add(idTextField);

        JPanel firstNamePanel = new JPanel();
        firstNameTextField = new JTextField();
        firstNameTextField.setFont(biggerFont);
        firstNameTextField.setPreferredSize(textFieldDimension);
        JLabel firstNameLabel = new JLabel("first name");
        firstNameLabel.setFont(biggerFont);
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameTextField);

        JPanel lastNamePanel = new JPanel();
        lastNameTextField = new JTextField();
        lastNameTextField.setFont(biggerFont);
        lastNameTextField.setPreferredSize(textFieldDimension);
        JLabel lastNameLabel = new JLabel("last name");
        lastNameLabel.setFont(biggerFont);
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameTextField);

        JPanel rolePanel = new JPanel();
        roleTextField = new JTextField();
        roleTextField.setFont(biggerFont);
        roleTextField.setPreferredSize(textFieldDimension);
        JLabel roleLabel = new JLabel("role");
        roleLabel.setFont(biggerFont);
        rolePanel.add(roleLabel);
        rolePanel.add(roleTextField);

        textFieldPanel.add(idPanel);
        textFieldPanel.add(firstNamePanel);
        textFieldPanel.add(lastNamePanel);
        textFieldPanel.add(rolePanel);

    }

    private void addButtons(JPanel buttonPanel) {
        JButton clearButton = new JButton("clear");
        JButton addButton = new JButton("add");
        JButton deleteButton = new JButton("delete");
        JButton updateButton = new JButton("update");

        clearButton.setFont(biggerFont);
        addButton.setFont(biggerFont);
        deleteButton.setFont(biggerFont);
        updateButton.setFont(biggerFont);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIdTextField("");
                setFirstNameTextField("");
                setLastNameTextField("");
                setRoleTextField("");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] array = new String[4];
                array[0] = getIdTextField().getText();
                array[1] = getFirstNameTextField().getText();
                array[2] = getLastNameTextField().getText();
                array[3] = getRoleTextField().getText();
                participantTableController.addRow(array);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = table.getSelectedRow();
                //String id = getIdTextField().getText();
                participantTableController.removeRow(rowIndex);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] array = new String[4];
                array[0] = getIdTextField().getText();
                array[1] = getFirstNameTextField().getText();
                array[2] = getLastNameTextField().getText();
                array[3] = getRoleTextField().getText();
                int rowIndex = table.getSelectedRow();
                participantTableController.updateRow(rowIndex, array);
            }
        });

        buttonPanel.add(clearButton);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
    }

    public void updateTable() {
        table.setModel(participantTableController.getTableModel());
        table.revalidate();
    }

    public JPanel getViewPanel() {
        return viewPanel;
    }

    public void setViewPanel(JPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(String text) {
        idTextField.setText(text);
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(String text) {
        lastNameTextField.setText(text);
    }

    public JTextField getRoleTextField() {
        return roleTextField;
    }

    public void setFirstNameTextField(String text) {
        firstNameTextField.setText(text);
    }

    public void setRoleTextField(String text) {
        roleTextField.setText(text);
    }

    public ParticipantTableController getParticipantTableController() {
        return participantTableController;
    }

    public void setParticipantTableController(ParticipantTableController participantTableController) {
        this.participantTableController = participantTableController;
    }
}

