package com.itview.testcases.selenium_aug_batch;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadValueFromPropertiesFiles {

	public static void main(String[] args) throws Exception{


		FileInputStream fi=new FileInputStream(".\\config.properties");
		
		Properties p=new Properties();		
		p.load(fi);
		
		String browserName=p.getProperty("browser");
		String url=p.getProperty("baseUrl");
		
		System.out.println(browserName);
		System.out.println(url);
		
		fi.close();
		

	}

}
