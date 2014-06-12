package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Rick on 5/30/2014.
 */
@Entity(name = "login")
public class Login implements Serializable {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 2;
   }

   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return getUsername();
	   else if (i == 1)
		   return getPassword();
	   else
		   throw new Exception("Error: invalid column index in login table");
   }

   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0)
		   colName = "username";
	   else if (i == 1)
		   colName = "password";
	   else
		   throw new Exception("Access to invalid column number in login table");

	   return colName;
   }

   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0)
		   username = (String) value;
	   else if (i == 1)
		   password = (String) value;
	   else
		   throw new Exception("Error: invalid column index in login table");
   }

    @Override
    public String toString() {
        return "Model.Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
