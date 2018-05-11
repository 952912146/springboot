package com.mj.s.springboot;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@SpringBootApplication
@MapperScan("com.mj.s.springboot.mapper")
public class SpringbootApplication {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druid(){
		DruidDataSource d = new DruidDataSource();
		return d;
	}
	
	@Bean
	public ServletRegistrationBean statViewServlet(){
		ServletRegistrationBean  bean = new ServletRegistrationBean (new StatViewServlet(),"/druid/*");
		Map<String ,String> map = new HashMap<String,String>();
		map.put("loginUsername","admin");
		map.put("loginPassword","123456");
		map.put("allow",""); //允许哪些IP可以访问  为""时表示所有
		map.put("deny","33.31.51.88");//不允许哪些IP访问
		bean.setInitParameters(map);
		return bean;
	}
	

	//还需在springboot类配置过滤器
	//用于监听获取到的数据，filter用于收集数据，servlet用于展现数据
	@Bean
	public FilterRegistrationBean webStatFilter(){
			FilterRegistrationBean bean = new FilterRegistrationBean();
			bean.setFilter(new WebStatFilter()); //设置过滤器 	WebStatFilter为阿里提供的过滤器
			//bean.addUrlPatterns("/*");//拦截所有请求
			Map<String,String> param = new HashMap<String,String>();
			//排除静态资源		
			param.put("exclusions" , "*.png,*.woff,*.js,*.css,/druid/*");
			bean.setInitParameters(param);
			return bean;
		}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
