package com.alkan.flightsearch.library.rest;// package com.alkan.flightsearch.library.rest;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {
    @Id
    @Column
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }
}
