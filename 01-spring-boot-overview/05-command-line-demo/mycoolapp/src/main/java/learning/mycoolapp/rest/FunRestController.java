package learning.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/working")
    public String workHard(){
        return "Work Harder My Nigga!!!";
    }

    @GetMapping("/fortune")
    public String workForFortune(){
        return "Work Harder My Nigga for the fortune that awaits u!!!";
    }
}
