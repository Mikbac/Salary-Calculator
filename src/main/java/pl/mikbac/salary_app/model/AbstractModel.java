package pl.mikbac.salary_app.model;

import pl.mikbac.salary_app.constants.EntityConstants;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by MikBac on 07.09.2019
 */

@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EntityConstants.Model.PK)
    protected Long pk;

}
