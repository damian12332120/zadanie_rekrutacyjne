package zadanie.Rektutacyjne.service;

import org.springframework.stereotype.Service;
import zadanie.Rektutacyjne.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService  {


    int countUsers();

    List<User> sortByAgee();

    Optional<User> oldestUserWithTelephone();

    List<User> lastNameSearch(String lastName);

    void deleteAll();



    void deleteById(int id);

    List<User> findAll();
}
