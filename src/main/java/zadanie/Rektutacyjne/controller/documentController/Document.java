package zadanie.Rektutacyjne.controller.documentController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zadanie.Rektutacyjne.csvOpen.OpenCSVReader;
import zadanie.Rektutacyjne.service.UserService;

@Controller
@RequestMapping("/document")
public class Document {

    @Autowired
    OpenCSVReader openCSVReader;
    @Autowired
    UserService userService;


    public Document() {
    }

    @GetMapping("/addPage")
    public String addDocument(Model theModel) {

        userService.addUsers(openCSVReader.open());

        return "add/Document";
    }
}
