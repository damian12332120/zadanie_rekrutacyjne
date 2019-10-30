package zadanie.Rektutacyjne.controller.mainWindowController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainPage {


    public MainPage() {
    }

    @GetMapping("/page")
    public String showMainPage(Model theModel) {
        return "main/MainPage";
    }
}
