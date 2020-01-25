package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/*
 * Author: Nitin Shukla
 * Property manager class has been created to manage the items present in the configuration.properties file and use them for test 
 * executions 
 * 
 */
//Step 1: Define all the variables listed of the config file and the global objects and variables

public class PropertiesManager {
	private static String chromedriver;
	private static String chromepath;
	private static String uaturl;
	private static String uatusername;
	private static String uatpassword;
	Properties propobj=new Properties();
	static PropertiesManager  instance; //add the instance of this file for calling it in other test cases
	
	static String filepath= "C:\\Nitin Shukla\\MyProjects\\POMFramework\\mavenProject\\src\\test\\resources\\config\\configProperties.properties";
	
	//Step 2: Create a method that initializes the instance of the Properties Manager file
	
	public static PropertiesManager callPropInstance() {
		if (instance ==null)
		{
			synchronized(PropertiesManager.class)
			{
				instance=new PropertiesManager();
				instance.loaddata();
			}
		}
		return instance;
		
	}
	
	//Step 3: Create load data method to load input and assign all the values to the variable read from config file
	public void loaddata() {
		try {
			InputStream input=new FileInputStream(filepath);
			propobj.load(input);
			chromedriver=propobj.getProperty("chromedriver");
			chromepath=propobj.getProperty("chromepath");
			uaturl=propobj.getProperty("uaturl");
			uatusername=propobj.getProperty("uatusername");
			uatpassword=propobj.getProperty("uatpassword");
			}		
			
		 catch (Exception e) {
			System.out.println("Exception Occured: File location couldnot be found, check the filepath value  !!");
			e.printStackTrace();
		 	}
		
	}
	
	public String getUrl() {
		return uaturl;
	}
	
	public String getUatUser() {
		return uatusername;
	}
	
	public String getUatPassword() {
		return uatpassword;
	}
		
	public String getDriverName() {
		return chromedriver;
	}
	
	public String getDriverPath() {
		return chromepath;
	}
	
		
		public void fileCommands() {
		try {
			String fname= "C:\\\\Nitin Shukla\\\\MyProjects\\\\POMFramework\\\\mavenProject\\\\src\\\\test\\\\java\\\\config\\\\configProperties.properties";
			//passing the file name or the directory name to the file object
			File fyle = new File(fname);
			
			//applying the File class methods on the file object
			System.out.println("The name of the file is "+fyle.getName());
			System.out.println("The location path of the file is "+fyle.getPath());
			System.out.println("The absolute path of the file is "+fyle.getAbsolutePath());
			System.out.println("The Parent of the file is "+fyle.getParent());
			System.out.println("The Exists property of the file is "+fyle.exists());
			if (fyle.exists())
				//checking the permissions on the file
			System.out.println("Is the file Readable:  "+fyle.canRead());
			System.out.println("Is the file Writeable:  "+fyle.canWrite());
			System.out.println("Is the file directory:  "+fyle.isDirectory());
			System.out.println("File usable space in bytes:  "+fyle.getUsableSpace());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}	
		
		
		
}