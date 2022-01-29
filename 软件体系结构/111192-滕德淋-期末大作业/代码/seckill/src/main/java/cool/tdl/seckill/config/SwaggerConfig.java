package cool.tdl.seckill.config;


import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.schema.AlternateTypeRules.newRule;


/**
 * @Author tdl
 * @Date 2022/1/10 3:07
 * @description swagger配置类
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{
    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket productApi(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cool.tdl.seckill.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("tdl")
                .enable(flag)
                .apiInfo(metaData())
                //自定义规则，如果遇到DeferredResult，则把泛型类转成json
                .alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class)));
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("小滕API测试")
                .description("慢慢学，会很快")
                .version("1.0.0")
                .contact(new Contact("小滕", "15884113649", "1357388630@qq.com"))
                .build();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
}
