package ru.kravchenko.se.entity;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

}
