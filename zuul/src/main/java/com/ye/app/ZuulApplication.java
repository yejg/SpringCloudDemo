package com.ye.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * @author yejg
 *
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
//		Integer tmp;
		Pattern pattern = Pattern.compile("_crh_user=(.+?);");
		Matcher matcher = pattern.matcher("_crh_user=fdsaafsagagafgfgfdgfagad");
		System.out.println(matcher.find());
		System.out.println("testtest1111");
		SpringApplication.run(ZuulApplication.class, args);
	}
}
