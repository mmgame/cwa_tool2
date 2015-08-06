package com.cwa.tool.creater.database;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * @author mali
 * 
 */
public class StarDatabase {
	public static void main(String[] a) {
		String[] args = { "propertiesconfig/log4j.xml", "propertiesconfig/wow/database.properties" };
		
		DOMConfigurator.configureAndWatch(args[0]);

		Resource[] props = new FileSystemResource[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			props[i - 1] = new FileSystemResource(args[i]);
		}
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setFileEncoding("UTF-8");
		ppc.setLocations(props);

		GenericApplicationContext ctx = new GenericApplicationContext();
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
		xmlReader.loadBeanDefinitions(new ClassPathResource("config/database.xml"));
		ppc.postProcessBeanFactory((ConfigurableListableBeanFactory) ctx.getDefaultListableBeanFactory());
		ctx.refresh();
	}
}
