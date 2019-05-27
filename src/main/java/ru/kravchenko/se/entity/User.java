package ru.kravchenko.se.entity;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_User")
public class User extends AbstractEntity{

    @Nullable
    @Column(name = "login")
    private String login;

    @Nullable
    @Column(name = "passwordHash")
    private String passwordHash;

    @Nullable
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Status role = Status.USER;

//    @Nullable
//    @OneToMany
//    private Project projects;

    @Override
    public String toString() {
        return "login: " + login + " password: " + passwordHash + " userStatus: " + role +
                " id: " + getId();
    }

}
