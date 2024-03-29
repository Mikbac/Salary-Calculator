package pl.mikbac.salary_app.spring.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static pl.mikbac.salary_app.constants.AttributeConstants.ModelAttributes.AllPages;

/**
 * Created by MikBac on 21.08.2019
 */

@Log4j2
public class CountryInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) {
        if (modelAndView != null) {
            modelAndView.addObject(AllPages.LANGUAGE, Locale.getDefault());
        }
    }

}
