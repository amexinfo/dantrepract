package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepartmentException extends Exception{

    public DepartmentException(String Massage) {
        super(Massage);

    }
}
