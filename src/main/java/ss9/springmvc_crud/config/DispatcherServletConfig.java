package ss9.springmvc_crud.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // cấu hình khng lien quan đến mvc
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // cấu hình lien quan tới mvc
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    // câu hình tiếng svieet utf-8

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        return new Filter[]{filter};
    }


}
