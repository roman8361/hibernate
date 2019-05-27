package ru.kravchenko.se.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

//@Entity
//@Getter
//@Setter
//@Table(name = "task")
public class Task {

    private String id = UUID.randomUUID().toString();

    private String name;

}
