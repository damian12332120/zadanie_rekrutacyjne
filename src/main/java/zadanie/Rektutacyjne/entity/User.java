package zadanie.Rektutacyjne.entity;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import zadanie.Rektutacyjne.service.csv.LocalDateConverter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CsvBindByPosition(position = 0)
    private String firstName;

    @CsvBindByPosition(position = 1)
    private String lastName;

    @CsvCustomBindByPosition(position = 2, converter = LocalDateConverter.class)
    private LocalDate birthDay;

    @CsvBindByPosition(position = 3)
    private String phoneNo;


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(birthDay, user.birthDay) &&
                Objects.equals(phoneNo, user.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDay, phoneNo);
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", firstName='" + firstName +
                        ", lastName='" + lastName +
                        ", birthDay=" + birthDay +
                        ", phoneNo='" + phoneNo
                ;
    }
}
