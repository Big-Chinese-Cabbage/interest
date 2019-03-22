package com.interest.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="interest.paths-properties")
@Configuration
public class PathsProperties {

	/**
	 * 域名
	 */
	private String domainName;

	/**
	 * 图片的本地存储地址
	 */
	private String image;
	
	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
