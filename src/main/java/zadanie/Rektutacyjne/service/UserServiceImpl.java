package zadanie.Rektutacyjne.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import zadanie.Rektutacyjne.dao.UserRepository;
import zadanie.Rektutacyjne.entity.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public UserServiceImpl() {
    }

    @Override
    public int countUsers() {
        return userRepository.findAll().size();
    }

    @Override
    public List<User> sortByAgee() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "birthDay"));
    }


    @Override
    public Optional<User> oldestUserWithTelephone() {
        return userRepository.findAll().stream().filter(e -> e.getPhoneNo().length() > 0).sorted(Comparator.comparing(User::getBirthDay)).findFirst();
    }

    @Override
    public List<User> lastNameSearch(String lastName) {
        return userRepository.findAll().stream().filter(l -> l.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAllPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void addUsers(List<User> users) {
        for (User user : users) {
            if (!findByPhoneNumber(user.getPhoneNo()).isPresent()) {
                userRepository.save(user);
            } else {
                System.out.println("user jest w bazie");
            }
        }
    }

    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return userRepository.findAll().stream().filter(e -> e.getPhoneNo().equals(phoneNumber)).findFirst();
    }
}

