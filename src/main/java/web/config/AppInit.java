package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }


    /* Данный метод указывает url, на котором будет базироваться приложение */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerHiddenFieldFilter(servletContext);
    }

    private void registerHiddenFieldFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic hiddenFieldFilter = servletContext.addFilter("hiddenFieldFilter", new HiddenHttpMethodFilter());
        hiddenFieldFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}