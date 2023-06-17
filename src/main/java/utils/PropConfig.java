package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropConfig {
public static Properties prop;
	
	public static Properties init_prop(String env)
	{
		String path = System.getProperty("user.dir");
		String filePath="";
		if(env.equals("SIT"))
		{
		 filePath = path + "\\src\\main\\java\\config\\env_SIT.properties";
		}
		else if (env.equals("UAT"))
		{
			filePath = path + "\\src\\main\\java\\config\\env_UAT.properties";
		}
		else
		{
			System.out.println("Please provide correct Env Name [SIT,UAT]");
			System.exit(0);
		}
		File file = new File(filePath);
		 prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;

	}

}

