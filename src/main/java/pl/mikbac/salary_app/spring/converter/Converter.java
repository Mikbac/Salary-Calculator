package pl.mikbac.salary_app.spring.converter;

import pl.mikbac.salary_app.data.Data;
import pl.mikbac.salary_app.model.Model;

/**
 * Created by MikBac on 07.09.2019
 */

public interface Converter<D extends Data, M extends Model> {

    D convert(M model);

    M inverseConvert(D data);

}
