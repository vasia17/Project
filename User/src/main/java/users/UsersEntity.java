package users;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sirius on 05.09.2015.
 */
@Entity
@Table(name = "users", schema = "", catalog = "users")
public class UsersEntity{
    private int userId;
    private String firstName;
    private String surName;
    private String number;

    public UsersEntity(ResultSet rs) throws SQLException {
        setUserId(rs.getInt(1));
        setFirstName(rs.getString(2));
        setNumber(rs.getString(3));
        setSurName(rs.getString(4));
    }

    public UsersEntity() {
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "surName")
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (surName != null ? !surName.equals(that.surName) : that.surName != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
