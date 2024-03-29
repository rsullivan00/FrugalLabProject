package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * model.Role.java
 * Created by Rick Sullivan on 5/30/2014.
 *
 * Entity class for roles of participant.
 * Corresponds to the role table
 */
@Entity(name = "role")
public class Role {
    @Id
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String name;

    public Role(int i) {
        id = i;
    }

    public Role() {
    }

    // return number of columns in the table
   public int getNumberOfColumns() {
	   return 2;
   }

   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return Integer.toString(getId());
	   else if (i == 1)
		   return getName();
	   else
		   throw new Exception("Error: invalid column index in role table");
   }

   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0)
		   colName = "role_id";
	   else if (i == 1)
		   colName = "role_name";
	   else
		   throw new Exception("Access to invalid column number in role table");

	   return colName;
   }

   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0)
		   id = Integer.parseInt((String) value);
	   else if (i == 1)
		   name = (String) value;
	   else
		   throw new Exception("Error: invalid column index in role table");
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
