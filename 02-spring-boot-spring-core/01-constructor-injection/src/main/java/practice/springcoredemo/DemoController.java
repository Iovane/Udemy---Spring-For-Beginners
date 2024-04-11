package practice.springcoredemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
