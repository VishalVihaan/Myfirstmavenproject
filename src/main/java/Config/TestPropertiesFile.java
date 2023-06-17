package Config;

import java.util.Properties;
import utils.PropConfig;

public class TestPropertiesFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir");
//		String filePath = path + "\\src\\main\\java\\config\\enviornment_config.properties";
//		
		//File file = new File(filePath);
//		
//		
//		Properties prop = new Properties();
//		try {
//			FileInputStream fis = new FileInputStream(file);
//			prop.load(fis);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(prop.get("username"));
//		System.out.println(prop.get("url"));
//		
//		prop.put("parallel", true);
//		
//		System.out.println("parallel");
//		
		
		Properties prop = PropConfig.init_prop("UAT");
		System.out.println(prop.get("username"));
		System.out.println(prop.get("url"));
		
	}


	}


