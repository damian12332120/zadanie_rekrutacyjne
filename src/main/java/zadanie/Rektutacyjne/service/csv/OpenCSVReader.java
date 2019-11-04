package zadanie.Rektutacyjne.service.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import zadanie.Rektutacyjne.entity.User;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


@Service
public class OpenCSVReader {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<User> open(Path fileNameAndPath) throws DateTimeParseException {
        List<User> correctUserList = new ArrayList<>();
        List<User> uncorrectUserList = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(String.valueOf(fileNameAndPath)));
        ) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(User.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .withSeparator(';')
                    .build();
            for (Object o : csvToBean) {

                User userInCsv = (User) o;
                if (validation(userInCsv)) {
                    correctUserList.add(userInCsv);
                } else {
                    uncorrectUserList.add(userInCsv);
                }
            }
            logger.info(uncorrectUserList.size() +" objects did not meet the requirements "+ this.getClass()+"method open");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return correctUserList;
    }


    private boolean validation(User user) {
        if (user.getFirstName().isEmpty()) {
            return false;
        } else {
            user.setFirstName(user.getFirstName().trim());
            user.setFirstName(Character.toUpperCase(user.getFirstName().charAt(0)) + user.getFirstName().substring(1));
        }
        if (user.getLastName().isEmpty()) {
            return false;
        } else {
            user.setLastName(user.getLastName().trim());
            user.setLastName(Character.toUpperCase(user.getLastName().charAt(0)) + user.getLastName().substring(1));
        }
        if (user.getBirthDay() == null) {
            return false;
        }
        if (!user.getPhoneNo().isEmpty()) {
            return user.getPhoneNo().matches("^[0-9]+$");
        }
        return true;
    }
}