package controller;

import model.ParticipantTableModel;
import view.ParticipantGUI;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;


/**
 * controller.ParticipantTableController.java
 * Created by Rick Sullivan on 5/27/2014.
 * COEN 160 Labs 7 and 8
 *
 * Glue between the view (CourseListGUI) and the model (CourseListTableModel).
 * No database specific code here. Contains a reference to both the TableModel and the graphical user interface.
 * Modified from R. Grover's CourseListTableController.
 */
public class ParticipantTableController implements ListSelectionListener, TableModelListener{
	private ParticipantTableModel tableModel;
	private ParticipantGUI gui;
	
	public ParticipantTableController(ParticipantGUI gui) {
		this.gui = gui;   
		tableModel = new ParticipantTableModel();
		tableModel.addTableModelListener(this);
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		gui.setIdTextField((String) tableModel.getValueAt(firstIndex, 0));
		gui.setFirstNameTextField((String) tableModel.getValueAt(firstIndex, 1));
		gui.setLastNameTextField((String) tableModel.getValueAt(firstIndex, 2));
		gui.setRoleTextField((String) tableModel.getValueAt(firstIndex, 3));
	}
	
	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new ParticipantTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	        // update the JTable with the data
	    	gui.updateTable();
	    
	        // read the data in each column using getValueAt and display it on corresponding textfield
			gui.setIdTextField((String) tableModel.getValueAt(firstIndex, 0));
			gui.setFirstNameTextField((String) tableModel.getValueAt(firstIndex, 1));
			gui.setLastNameTextField((String) tableModel.getValueAt(firstIndex, 2));
			gui.setRoleTextField((String) tableModel.getValueAt(firstIndex, 3));
        } catch(Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
        }
	}

	public void addRow(String[] array) {
		tableModel.addRow(array);
        gui.updateTable();
	}

    public void removeRow(int rowIndex) {
        tableModel.removeRow(rowIndex);
        gui.updateTable();
    }

    public void updateRow(int rowIndex, String[] array) {
        tableModel.updateRow(rowIndex, array);
        gui.updateTable();
    }
}


