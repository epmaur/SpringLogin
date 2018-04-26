package com.login.training;

import com.login.model.UserBean;
import com.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
public class TrainingController {

    private TrainingService trainingService;
    @Autowired
    private UserRepository userRepository;


    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    /*
    @RequestMapping(value="/trainings/add", method= RequestMethod.POST)
    public Training addTraining(@RequestBody Training training) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        training.setCreator(userService.getUser(userDetails.getUsername()));
        return trainingService.addTraining(training);
    }
    */

    @CrossOrigin
    @RequestMapping(value="/trainings", method= RequestMethod.GET)
    public List<Training> getAllTrainings() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserBean user = userRepository.findByEmail(auth.getName());
        System.out.println("USER: " + user.getEmail());
        List<Training> response = trainingService.getAllTrainings();
        return response;
    }

    @RequestMapping(value = "/trainings/{id}", method= RequestMethod.GET, produces="application/json")
    public Training getTraining(@PathVariable("id") int trainingId) {
        return trainingService.getTrainingById(trainingId);
    }

    @RequestMapping(value="/trainings/delete", method= RequestMethod.POST,
            consumes = "application/json")
    public Long deleteTraining(@RequestBody long id) {
        return trainingService.deleteTrainingById(id);
    }

    @RequestMapping(value="/trainings/params", method= RequestMethod.POST,
            consumes = "application/json")
    public List<Training> filterTraining(@RequestBody TrainingHelper trainingHelper){
        System.out.println(trainingService.filterTraining(trainingHelper));
        return trainingService.filterTraining(trainingHelper);
    }


    @RequestMapping(value = "/test", method= RequestMethod.GET, produces="application/json")
    public String test() {
        return "Test";
    }

    @RequestMapping(value = "/google")
    public Principal google (Principal principal) {
        return principal;
    }

}
