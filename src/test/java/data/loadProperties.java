package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class loadProperties 
{
	// Load the properties file from the folder
	public static Properties userData = loadProperties(System.getProperty("user.dir")+ "\\src\\main\\java\\properties\\userData.properties");
	
	private static Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		// Stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error occured: "+ e.getMessage() );
		} catch (IOException e) {
			System.out.println("Error occured: "+ e.getMessage() );
		}
		return pro;
	}

}
