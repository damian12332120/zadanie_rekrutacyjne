package zadanie.Rektutacyjne.controller.documentController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zadanie.Rektutacyjne.OpenCSVReader;

@Controller
@RequestMapping("/document")
public class Document {

    @Autowired
    OpenCSVReader openCSVReader;


    public Document() {
    }

    @GetMapping("/addPage")
    public String addDocument(Model theModel) {
        System.out.println("aaaaa");
        ;
        openCSVReader.open();
        System.out.println("bbbbbb");
        return "add/Document";
    }
}
