package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadConfig {
	
	Properties props;
	Logger log = Logger.getLogger("ConfigLogger");;
	public ReadConfig() {
		File src = new File(".//ConfigurationFiles//config.properties");
		log.info("Config reader started");
		try {
			FileInputStream fis = new FileInputStream(src);
			props = new Properties();
			try {
				props.load(fis);
				log.info("Properties loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Properties file not found");
			 log = Logger.getLogger("ConfigLogger");
			log.info("Properties File Not found");
			
		}
		}
	public String getConfigProperty(String propName) {
		System.out.println(props.getProperty(propName) );

		return props.getProperty(propName);

		
		
	}
	}

