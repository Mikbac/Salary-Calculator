/**
 * Created by MikBac on 07.09.2019
 */

package pl.MikBac.salaryApp.model;

import pl.MikBac.salaryApp.constants.EntityConstants;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EntityConstants.Model.PK)
    protected Long pk;

}
