package zadanie.Rektutacyjne.entity;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

//@Entity
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CsvBindByName
    //@NotEmpty(message = "login nie może być pusty")
    private String first_name;
  //  @NotEmpty(message = "login nie może być pusty")
    @CsvBindByName
    private String last_name;
  //  @NotEmpty(message = "login nie może być pusty")
    @CsvBindByName
    private LocalDate birth_date;
  //  @Pattern(regexp = "[0-9]{9}")
    @CsvBindByName
    private Long phone_no;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public Long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(Long phone_no) {
        this.phone_no = phone_no;
    }
}
