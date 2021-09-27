package aplicacao.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean(){
        List<String> all = Collections.singletonList("*");

        CorsConfiguration configuracaoCors = new CorsConfiguration();
        configuracaoCors.setAllowedOrigins(all);
        configuracaoCors.setAllowedHeaders(all);
        configuracaoCors.setAllowedMethods(all);
        configuracaoCors.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuracaoCors);

        CorsFilter filtroCors = new CorsFilter(source);
        FilterRegistrationBean<CorsFilter> filtro = new FilterRegistrationBean<>(filtroCors);
        filtro.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filtro;
     }
}
