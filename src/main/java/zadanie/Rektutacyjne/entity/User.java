package zadanie.Rektutacyjne.entity;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "login nie może być pusty")
    @CsvBindByName
    private String firstName;

    @NotEmpty(message = "login nie może być pusty")
    @CsvBindByName
    private String lastName;

    @NotEmpty(message = "login nie może być pusty")
    @CsvBindByName
    private LocalDate birthDay;

    @Pattern(regexp = "[0-9]{9}")
    @CsvBindByName
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
