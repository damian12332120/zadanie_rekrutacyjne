package zadanie.Rektutacyjne.service.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import zadanie.Rektutacyjne.dao.UserRepository;
import zadanie.Rektutacyjne.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient()
@SpringBootTest
public class UserServiceImplTest {

    private User user;

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        user = new User();
        user.setFirstName("Adam");
        user.setLastName("Nowak");
        user.setPhoneNo("111111111");
        user.setBirthDay(LocalDate.now());
    }


    @Test
    public void shouldCountUser() {
        int usersBefore = userService.countUsers();
        userRepository.save(user);
        int userAfter = userService.countUsers();
        assertNotEquals(usersBefore, userAfter);
        assertEquals(usersBefore + 1, userAfter);
    }

    @Test
    public void shouldSortByAge() {
        List<User> userList = userService.sortByAgee();
        User temp = new User();
        for (User user : userList) {
            if (temp.getBirthDay() != null) {
                assertTrue(temp.getBirthDay().isBefore(user.getBirthDay()));
                temp = user;
            }
        }
    }


    @Test
    public void shouldFindOldestUserWithTelephone() {

        List<User> birthDay = userRepository.findAll(Sort.by(Sort.Direction.ASC, "birthDay"));
        User userB = birthDay.get(0);
        Optional<User> user = userService.oldestUserWithTelephone();
        if (userB.getBirthDay() != null) {
            assertTrue(userB.equals(user.get()));
        }
    }

    @Test
    public void shouldFindByLastName() {
        userRepository.save(user);
        assertFalse(userService.lastNameSearch(user.getLastName()).isEmpty());
    }

    @Test
    public void shouldFindByPhoneNumber() {
        userRepository.save(user);
        assertTrue(userService.findByPhoneNumber(user.getPhoneNo()).isPresent());
    }

    @Test
    public void shouldAddUserWhenPhoneNumberIsUnique() {
        List<User> list = new ArrayList<>();
        list.add(user);
        userService.addUsers(list);
        assertTrue(userService.findByPhoneNumber(user.getPhoneNo()).isPresent());
    }

    @Test
    public void shouldDontAddUserWhenPhoneNumberInNotUnique() {
        List<User> all = userService.findAll();
        User user2 = all.get(0);
        User user3 = all.get(0);
        User user4 = all.get(0);
        List<User> listCloneUsers = new ArrayList<>();
        listCloneUsers.add(user2);
        listCloneUsers.add(user3);
        listCloneUsers.add(user4);
        userService.addUsers(listCloneUsers);

        List<User> collect = userRepository.findAll().stream().filter(e -> e.getPhoneNo().equals(user2.getPhoneNo())).collect(Collectors.toList());
        assertTrue(collect.size() == 1);
    }


    @After
    public void tearDown() throws Exception {
        userRepository.delete(user);
    }
}