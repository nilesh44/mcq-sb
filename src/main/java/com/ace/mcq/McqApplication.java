package com.ace.mcq;

import java.io.File;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class McqApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(McqApplication.class, args);
	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(McqApplication.class); }
	 */
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

	 //String configlocation = System.getProperty("global.appconf.dir"); //get the default config directory location

	    // String configpath = configlocation + File.separator + "springapplication"  + File.separator + "application.yml"; //set the configpath of this application instance exclusively
         String configpath="${catalina.base}/props/application.yml";
	     log.info("configpath: " + configpath);
	     log.info("starting to run spring boot app...");

	     if(configpath != null && !configpath.isEmpty()) {
	     Properties props = new Properties();
	     System.setProperty("spring.config.location", configpath); //set the config file to use    
	     application.application().setDefaultProperties(props);
	     }else{
	     log.info("no global.appconf.dir property found, starting with default on classpath");
	     }

	 return application.sources(McqApplication.class);
	 }

}
