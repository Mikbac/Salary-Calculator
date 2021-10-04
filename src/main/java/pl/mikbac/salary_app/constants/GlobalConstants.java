package pl.mikbac.salary_app.constants;

/**
 * Created by MikBac on 04.10.2021
 */

public interface GlobalConstants {

    interface Package {
        String BASE = "pl.mikbac.salary_app";
        String MODEL = BASE + ".model";
        String SPRING = BASE + ".spring";
        String CONTROLLER = SPRING + ".controller";
    }

    interface Regex {
        String ONLY_BIG_LETTERS = "^[A-Z]+$";
        String MONEY = "^([0-9]+|([0-9]+(\\.|\\,)[0-9]+))$";
    }

}
