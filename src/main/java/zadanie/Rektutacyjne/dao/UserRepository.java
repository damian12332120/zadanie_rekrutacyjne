package zadanie.Rektutacyjne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zadanie.Rektutacyjne.entity.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

}
