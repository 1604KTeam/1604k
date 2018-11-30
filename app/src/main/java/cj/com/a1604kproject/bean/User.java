package cj.com.a1604kproject.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "user_info",indexes = {@Index(value = "name DESC", unique = true)})
public class User {
    @Id
    private Long id;

    @Property(nameInDb = "USERNAME") @NotNull
    private String name;

    @Transient
    private int tempUsageCount; // not persisted

    @Generated(hash = 1709734220)
    public User(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // getters and setters for id and user ...
}

