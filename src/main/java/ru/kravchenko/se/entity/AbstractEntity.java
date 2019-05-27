package ru.kravchenko.se.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

}
