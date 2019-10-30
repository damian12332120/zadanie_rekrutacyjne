package zadanie.Rektutacyjne.controller.userController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userData")
public class User {


    @GetMapping("/page")
    public String showMainPage(Model theModel) {
        return "main/MainPage";
    }
}
