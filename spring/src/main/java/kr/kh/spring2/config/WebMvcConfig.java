package kr.kh.spring2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.kh.spring2.interceptor.AutoLoginInterceptor;
import kr.kh.spring2.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.kh.spring2") 
public class WebMvcConfig implements WebMvcConfigurer {				//5.1.8버젼으로 pom.xml 수정해야 이상x

	@Autowired
	LoginInterceptor loginInterceptor;
	@Autowired
	AutoLoginInterceptor autoLoginInterceptor;
	
	//new 해서 그냥 호출하면 안되기 때문에 여기서 호출해서 autowired로
	
    @Bean
    public InternalResourceViewResolver viewResolver() {				//기본 뷰리졸버
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {		//맵핑
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/download/**").addResourceLocations("file:///D:/uploads/","file:///D:/uploads2/");
    }
    
	// TilesViewResolver 설정
    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(1); // ViewResolver의 우선순위 설정
        return tilesViewResolver;
    }
    // Tiles 설정
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/spring/tiles.xml");					//얘까지 xml java코드로 대체할 수 있긴 한데 좀 많이 복잡해져서...그냥 얘만 xml로 쓰자
        tilesConfigurer.setCheckRefresh(true); // 변경 사항을 자동으로 감지하여 갱신
        return tilesConfigurer;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 인터셉터 추가 및 URL 패턴 설정
        registry.addInterceptor(loginInterceptor)	//추가할 인터셉터명
                .addPathPatterns("/login");  // 로그인 할때만 인터셉터 적용 -> 제외될 경로는 딱히 x
        /*		.addPathPatterns("/**")  // 모든 경로에 대해 인터셉터 적용
        		.excludePathPatterns("/post/list", "/post/detail"); //제외할 경로  //이런 식으로 로그인 안 해도 볼 수 있는 화면만 제외 가능	*/
        //registry.addInterceptor() 해서 인터셉터 여러개 추가 가능
        
        //autologininterceptor 추가
        registry.addInterceptor(autoLoginInterceptor)	//추가할 인터셉터명
        .addPathPatterns("/**");
        //.excludePathPatterns("/signup","/login","/logout");			//굳이 안 해도 되는애들
        
    }
    
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();  // BCryptPasswordEncoder 빈 등록
	}
	
	@Bean(name="multipartResolver")		//빈에 multipartResolver 등록
	public CommonsMultipartResolver multipartResolver() {			//파일 업로드 위한 빈 등록 
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(10 * 1024 * 1024);
		return resolver;
	}

}