package zadanie.Rektutacyjne.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zadanie.Rektutacyjne.entity.User;
import zadanie.Rektutacyjne.service.UserService;

import java.util.List;

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
    public String getEmployees(@PageableDefault(size = 5) Pageable pageable,
                               Model model) {
        model.addAttribute("users", userService.findAllPage(pageable));
        return "user/ShowUsers";
    }

    @GetMapping("/oldestUserWithTelephone")
    public String oldestUserWithTelephone(Model model) {
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
    public String lastNameSearch(@PageableDefault(size = 5) Pageable pageable,
                                 @ModelAttribute("user") User user, Model model) {
        List<User> list = userService.lastNameSearch(user.getLastName());
        Page<User> page = new PageImpl<>(list, pageable, list.size());
        model.addAttribute("users", page);
        return "user/ShowUsers";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("users", userService.findAllPage(pageable));
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
