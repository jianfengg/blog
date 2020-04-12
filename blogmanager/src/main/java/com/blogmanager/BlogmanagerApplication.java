package com.blogmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import java.util.Collections;

@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableTransactionManagement
@ServletComponentScan
@MapperScan({"com.blogmanager.*.mapper"})
@SpringBootApplication
@EnableCaching
public class BlogmanagerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BlogmanagerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogmanagerApplication.class, args);
		System.out.println("ヾ(◍°∇°◍)ﾉﾞ    blog启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
				" ______                    _   ______            \n" +
				"|_   _ \\                  / |_|_   _ `.          \n" +
				"  | |_) |   .--.    .--. `| |-' | | `. \\  .--.   \n" +
				"  |  __'. / .'`\\ \\/ .'`\\ \\| |   | |  | |/ .'`\\ \\ \n" +
				" _| |__) || \\__. || \\__. || |, _| |_.' /| \\__. | \n" +
				"|_______/  '.__.'  '.__.' \\__/|______.'  '.__.'  ");
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new ServletContextInitializer() {
			public void onStartup(ServletContext servletContext) throws ServletException {
				servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE) );
			}
		};
	}
}
