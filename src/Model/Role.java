package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Rick on 5/30/2014.
 */
@Entity(name = "role")
public class Role {
    @Id
    @Column(name = "login_username")
    private String username;

    @Column(name = "login_password")
    private String password;


   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 4;
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
		   colName = "login_username";
	   else if (i == 1)
		   colName = "login_password";
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
                "login_username='" + username + '\'' +
                ", login_password='" + password + '\'' +
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
