package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {
	public static boolean isAdminMode;
	

	public boolean isAdminMode() {
		return isAdminMode;
	}

	public void setAdminMode(boolean isAdminMode) {
		this.isAdminMode = isAdminMode;
	}

	public String getProjectPath(){
    	String value ="";
    	try {
			File file = new File("project.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			value = properties.getProperty("destinationPath");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return value;
    }
	
	public static String getDirectory(String parentPath, String dirName) {
		String dirPath = parentPath+"\\" + dirName;
		  File dir = new File(dirPath);

		  if(!dir.exists()){
		   boolean success = dir.mkdir();
		   if (!success) {
		    System.out.println("Directory creation failed");
		    return null;
		   }
		  }
		  return dirPath;
	}
	
	public String getAbsolutePath(){
		return new File("").getAbsolutePath();
	}
}
