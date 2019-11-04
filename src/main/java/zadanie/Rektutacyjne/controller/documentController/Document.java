package zadanie.Rektutacyjne.controller.documentController;

import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import zadanie.Rektutacyjne.service.csv.OpenCSVReader;
import zadanie.Rektutacyjne.service.user.UserService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
@RequestMapping("/document")
public class Document {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OpenCSVReader openCSVReader;
    @Autowired
    UserService userService;

    public Document() {
    }

    @GetMapping("/addPage")
    public String addDocument(Model theModel) {
        return "add/Document";
    }

    @RequestMapping("/upload")
    public String upload(Model model, @RequestParam("file") MultipartFile[] files) throws IOException {
        File convFile;
        for (MultipartFile file : files) {
            convFile = convertMultiPartToFile(file);
            if (!Files.getFileExtension(convFile.getName()).equals("csv")) {
                logger.error("file " + convFile.getName() + " is not compatible "+" method upload");
            } else {
                userService.addUsers(openCSVReader.open(Paths.get(convFile.getAbsolutePath())));
            }
        }

      return "main/MainPage";
    }

    private File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
                multipartFile.getOriginalFilename());
        multipartFile.transferTo(convFile);
        return convFile;
    }
}
