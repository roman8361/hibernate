package ru.kravchenko.se.entity;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_Project")
public class Project extends AbstractEntity {

    @Nullable
    @Column(name = "name")
    private String name;

    @Nullable
    @Column(name = "description")
    private String description;

    @Nullable
    @Column(name = "dateBegin")
    private Date dateBegin;

    @Nullable
    @Column(name = "dateEnd")
    private Date dateEnd;

    @Nullable
    @Column(name = "userId")
    private String userId;

    @NotNull
    @Column(name = "status")
    private StatusProjectTask status = StatusProjectTask.PLANNED;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        @NotNull final String pattern = "dd.MM.yyyy";
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        @NotNull final String dateBering = simpleDateFormat.format(this.dateBegin);
        @NotNull final String dateEnd = simpleDateFormat.format(this.dateEnd);

        return "PROJECT NAME: \"" + this.name + "\" DESCRIPTION PROJECT: \"" + this.description + "\" "
                + "PROJECT ID: \"" + super.getId() + "\" DATE BEGIN: \"" + dateBering + "\" DATE END: \""
                + dateEnd + "\"" + " STATUS: " + this.status + " USER ID: " + this.userId;
    }

}
