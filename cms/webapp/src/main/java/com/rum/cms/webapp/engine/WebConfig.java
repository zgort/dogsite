package com.rum.cms.webapp.engine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Hikmat
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 
	 */
	@Value("${image.dir}")
	private String imageDir;
	/**
	 * 
	 */
	@Value("${report.dir}")
	private String reportDir;
	/**
	 * 
	 */
	@Value("${XRayImage.dir}")
	private String xrayImageDir;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/adminResources/**").addResourceLocations("/WEB-INF/adminResources/bootstrapTheme/");
		registry.addResourceHandler("/image/**").addResourceLocations("file:"+imageDir);
		registry.addResourceHandler("/report/**").addResourceLocations("file:"+reportDir);
		registry.addResourceHandler("/xrayImage/**").addResourceLocations("file:"+xrayImageDir);
	}
	
}
