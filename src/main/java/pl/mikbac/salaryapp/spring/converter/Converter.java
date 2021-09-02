package pl.mikbac.salaryapp.spring.converter;

import pl.mikbac.salaryapp.data.Data;
import pl.mikbac.salaryapp.model.Model;

/**
 * Created by MikBac on 07.09.2019
 */

public interface Converter<D extends Data, M extends Model> {

    D convert(M model);

    M inverseConvert(D data);

}
