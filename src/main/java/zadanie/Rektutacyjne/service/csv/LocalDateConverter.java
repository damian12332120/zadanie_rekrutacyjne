package zadanie.Rektutacyjne.service.csv;

import com.opencsv.bean.AbstractBeanField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class LocalDateConverter extends AbstractBeanField {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    protected Object convert(String s) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.M.d");
        LocalDate parse = null;
        try {
            parse = LocalDate.parse(s, formatter);
        } catch (DateTimeParseException ignored) {

        }
        return parse;
    }
}
