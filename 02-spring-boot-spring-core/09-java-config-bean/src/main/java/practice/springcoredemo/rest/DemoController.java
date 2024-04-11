package practice.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.springcoredemo.common.Coach;

@RestController
public class DemoController {

    private Coach myCoach;

    public DemoController(@Qualifier("swimCoach") Coach myCoach) {

        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
