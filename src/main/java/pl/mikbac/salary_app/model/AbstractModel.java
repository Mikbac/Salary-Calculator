package pl.mikbac.salary_app.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

import static pl.mikbac.salary_app.constants.EntityConstants.Model;

/**
 * Created by MikBac on 07.09.2019
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Model.PK)
    protected Long pk;

    @CreatedDate
    @Column(name = Model.CREATION_TIME)
    protected LocalDateTime creationTime;

    @LastModifiedDate
    @Column(name = Model.UPDATE_TIME)
    protected LocalDateTime updateTime;

}
