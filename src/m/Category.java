package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Rick on 5/30/2014.
 */
@Entity(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;

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
           throw new Exception("Error: invalid column index in category table");
    }

    // return the name of column i
    public String getColumnName(int i) throws Exception {
       String colName = null;
       if (i == 0)
           colName = "category_id";
       else if (i == 1)
           colName = "category_name";
       else
           throw new Exception("Access to invalid column number in category table");

       return colName;
    }

    // set data column i to value
    public void setColumnData(int i, Object value) throws Exception {
       if (i == 0)
           id = Integer.parseInt((String) value);
       else if (i == 1)
           name = (String) value;
       else
           throw new Exception("Error: invalid column index in category table");
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
