package practice.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.springcoredemo.common.Coach;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    public DemoController(@Qualifier("cricketCoach") Coach myCoach,
                          @Qualifier("cricketCoach") Coach anotherCoach) {

        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach,  " + (myCoach == anotherCoach);
    }
}
