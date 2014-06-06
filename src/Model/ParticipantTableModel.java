package model;

import service.ParticipantService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Comparator;
import java.util.List;

/**
 * model.ParticipantTableModel.java
 * Created by Rick Sullivan on 5/27/2014.
 * COEN 160 Labs 7 and 8
 *
 * Uses the service.ParticipantService to make changes to the participant
 * table model.
 * Modified from R. Grover's CourseListTableModel.
 */
public class ParticipantTableModel extends AbstractTableModel {

	  List<Participant> participants;   // stores the model data in a List collection of type CourseList
	  private static final String PERSISTENCE_UNIT_NAME = "participant";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private Participant participant;			    // represents the entity participant
	  private ParticipantService participantService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	 public ParticipantTableModel() {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    participant = new Participant();
	    participantService = new ParticipantService(manager);
	    
	    // read all the records from participant
	    participants = participantService.readAll();
	    
	    // update the number of rows and columns in the model
	    numrows = participants.size();
	    numcols = participant.getNumberOfColumns();
      }

	 // returns a count of the number of rows
	 public int getRowCount() {
		return numrows;
	 }
	
	 // returns a count of the number of columns
	 public int getColumnCount() {
		return numcols;
	 }
	
	 // returns the data at the given row and column number
	 public Object getValueAt(int row, int col) {
		try {
		  return participants.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	 }
	
	 // table cells are not editable
	 public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
	
	 public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
	
	 // returns the name of the column
	 public String getColumnName(int col) {
		   try {
				return participant.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   Participant element = participants.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<Participant> getList() {
		 return participants;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public ParticipantTableModel(List<Participant> list, EntityManager em)  {
	    participants = list;
	    numrows = participants.size();
	    participant = new Participant();
	   	numcols = participant.getNumberOfColumns();
		manager = em;  
		participantService = new ParticipantService(manager);
	 }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		//data[rowIndex][columnIndex] = (String) aValue;
			
	    // add row to database
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		Participant newRecord = participantService.createParticipant(java.lang.Integer.parseInt((String) array[0]), (String) array[1], (String) array[2], Integer.parseInt((String) array[3]));
		userTransaction.commit();
		 
		// set the current row to rowIndex
        participants.add(newRecord);
        int row = participants.size();
        int col = 0;

        // update the data in the model to the entries in array
         for (Object data : array) {
          	 setValueAt((String) data, row-1, col++);
         }
         
         numrows++;
         sortParticipants();
	}

    public void removeRow(int rowIndex) {
        int id = participants.get(rowIndex).getId();

 		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
        Participant participantToDelete = participantService.readParticipant(id);
        participantService.deleteParticipant(id);
		userTransaction.commit();

		// set the current row to rowIndex
        participants.remove(participantToDelete);
        int row = participants.size();
        int col = 0;

        numrows--;
    }

    public void updateRow(int rowIndex, Object[] array) {
        /* Ignore id from input; we can't change ids */
        int id = participants.get(rowIndex).getId();

  		EntityTransaction userTransaction = manager.getTransaction();
		userTransaction.begin();
        /* Ignore array[0] */
        String firstName = (String) array[1];
        String lastName = (String) array[2];
        int role = Integer.parseInt((String)array[3]);

        Participant updatedParticipant = participantService.updateParticipant(id, firstName, lastName, role);
		userTransaction.commit();

		// set the current row to rowIndex
        participants.set(rowIndex, updatedParticipant);
        sortParticipants();
    }

    public void sortParticipants() {
         participants.sort(new Comparator<Participant>() {
            @Override
            public int compare(Participant o1, Participant o2) {
                if (o1.getId() < o2.getId()) {
                    return -1;
                } else if (o1.getId() == o2.getId()) {
                    return 0;
                } else {
                    return 1;
                }

            }
        });
    }
}

