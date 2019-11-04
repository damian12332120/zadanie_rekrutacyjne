package zadanie.Rektutacyjne.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<User> findAllPage(Pageable pageable);

    void addUsers(List<User> users);

    Optional<User> findByPhoneNumber(String value);
}
