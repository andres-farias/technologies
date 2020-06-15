package cl.azulprofundo.technologies.javamelody;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Controller
public class FactorialMS {

    @RequestMapping(value = "/factorial")
    public Result factorialMS(@RequestParam(name = "number", defaultValue = "0") long number) {
        if (number >= 0){
            return new Result(factorial(number));
        }

        return new Result(-1L);
    }

    public Long factorial(Long number) {
        if (number == 0 || number == 1) {
            return 1L;
        } else {
            return number * factorial(number - 1);
        }

    }
}
