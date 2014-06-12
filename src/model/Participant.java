package model;

import javax.persistence.*;

import java.io.*;
import java.util.Set;


/**
 * Model.Participant.java
 * Created by Rick Sullivan on 5/27/2014.
 * COEN 160 Labs 7 and 8
 *
 * Entity class for participants in projects.
 * Corresponds to the participant table
 * Modified from R. Grover's CourseList.
 */
@Entity(name = "participant")
public class Participant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    private int role;

    @Column(name = "participant_photo_url")
    private String photoURL;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="participants")
    private Set<Project> projects;

    @Transient
    private String roleName;

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    // return number of columns in the table
    public int getNumberOfColumns() {
        return 4;
    }

    // return the data in column i
    public String getColumnData(int i) throws Exception {
        if (i == 0)
            return Integer.toString(id);
        else if (i == 1)
            return getFirstName();
        else if (i == 2)
            return getLastName();
        else if (i == 3)
            return Integer.toString(getRole());
        else
            throw new Exception("Error: invalid column index in participants table");
    }

    // return the name of column i
    public String getColumnName(int i) throws Exception {
        String colName = null;
        if (i == 0)
            colName = "id";
        else if (i == 1)
            colName = "first_name";
        else if (i == 2)
            colName = "last_name";
        else if (i == 3)
            colName = "role";
        else
            throw new Exception("Access to invalid column number in participants table");

        return colName;
    }

    // set data column i to value
    public void setColumnData(int i, Object value) throws Exception {
        if (i == 0)
            id = Integer.parseInt((String) value);
        else if (i == 1)
            firstName = (String) value;
        else if (i == 2)
            lastName =  (String) value;
        else if (i == 3)
            role = Integer.parseInt((String) value);
        else
            throw new Exception("Error: invalid column index in participants table");
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String participant_first_name) {
        this.firstName = participant_first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String participant_last_name) {
        this.lastName = participant_last_name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int participant_role) {
        this.role = participant_role;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

