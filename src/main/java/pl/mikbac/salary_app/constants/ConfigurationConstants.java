package pl.mikbac.salary_app.constants;

/**
 * Created by MikBac on 05.10.2019
 */

public interface ConfigurationConstants {

    interface Profiles {
        String DEVELOPMENT = "development";
        String PRODUCTION = "production";
    }

    interface AntPatterns {
        String ROOT = "/";
        String RESOURCES = "/resources/**";
        String ASSETS = "/assets/**";
        String CSS = "/static/css/**";
        String LESS = "/static/less/**";
        String JS = "/static/js/**";
        String IMAGES = "/static/img/**";
        String FONTS = "/fonts/**";
        String JSON = "/static/json/**";
    }
}
