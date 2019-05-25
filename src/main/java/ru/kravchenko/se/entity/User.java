package ru.kravchenko.se.entity;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User{

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Nullable
    @Column(name = "login")
    private String login;

    @Nullable
    @Column(name = "passwordHash")
    private String passwordHash;

    @Nullable
    @Column(name = "role")
    private Status role = Status.USER;

    @Nullable
    @Column(name = "locked")
    boolean locked;

//    @Override
//    public String toString() {
//        return "login: " + login + " password: " + passwordHash + " userStatus: " + role +
//                " id: " + getId();
//    }

}
