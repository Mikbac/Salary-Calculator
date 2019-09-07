/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.spring.converter;

import pl.MikBac.salaryApp.data.Data;
import pl.MikBac.salaryApp.model.Model;

public interface Converter<D extends Data, M extends Model> {

    D convert(M model);

    M inverseConvert(D data);

}
