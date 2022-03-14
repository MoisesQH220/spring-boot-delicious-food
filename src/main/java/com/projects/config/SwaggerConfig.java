package com.projects.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  
  private final InfoProperties infoProperties;
  
  public SwaggerConfig(InfoProperties infoProperties) {
    this.infoProperties = infoProperties;
  }
  
  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2).select()
      .apis(RequestHandlerSelectors.basePackage("com.projects"))
      .paths(PathSelectors.any()).build()
      .apiInfo(apiInfo());
  }
  
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title(infoProperties.getTittle())
      .description(infoProperties.getDescription())
      .version(infoProperties.getVersion())
      .build();
  }
  
  
}
