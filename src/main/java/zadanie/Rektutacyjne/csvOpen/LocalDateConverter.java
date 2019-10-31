package zadanie.Rektutacyjne.csvOpen;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateConverter extends AbstractBeanField {
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
