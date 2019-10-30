package zadanie.Rektutacyjne.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zadanie.Rektutacyjne.entity.User;
import zadanie.Rektutacyjne.service.UserService;

import java.util.Optional;

@Controller
@RequestMapping("/userData")
public class UserController {

    @Autowired
    UserService userService;

    public UserController() {
    }

    @GetMapping("/page")
    public String showMainPage(Model theModel) {
        return "user/User";
    }

    @GetMapping("/countUsers")
    public String countUsers(Model model) {

        model.addAttribute("count", userService.countUsers());
        return "user/CountUsers";
    }

    @GetMapping("/sortByAge")
    public String sortByAge(Model model) {
        model.addAttribute("users", userService.sortByAgee());
        return "user/ShowUsers";
    }


    @GetMapping("/oldestUserWithTelephone")
    public String oldestUserWithTelephone(Model model) {
        Optional<User> user = userService.oldestUserWithTelephone();
        model.addAttribute("user", userService.oldestUserWithTelephone());
        return "user/oldestUserWithTelephone";
    }


    @GetMapping("/lastNameSearch")
    public String lastNameSearchPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/LastNameSearch";
    }

    @GetMapping("/lastNameSearchCheck")
    public String lastNameSearch(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", userService.lastNameSearch(user.getLastName()));
        return "user/ShowUsers";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/DeleteUser";
    }

    @GetMapping("/deleteUserById")
    public String deleteUserById(@RequestParam("userId") int theId, Model model) {
        userService.deleteById(theId);
        return "user/User";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        userService.deleteAll();
        return "user/User";
    }


}
