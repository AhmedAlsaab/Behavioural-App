package team11.project.behaviorapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team11.project.behaviorapp.Entities.Activities;
import team11.project.behaviorapp.Entities.Patient;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.ActivityCreationService;
import team11.project.behaviorapp.Services.PatientService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/patient")
public class APIController {

    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;
    @Autowired
    ActivityCreationService activityCreationService;

    @RequestMapping(path = "/activity/create", method = RequestMethod.POST)
    public String createActivity(@RequestParam final String activityName, @RequestParam final String date) throws ParseException {
        System.out.println("Activity Name: " + activityName + "\nDate: " + date);

        //Source adapted from https://stackoverflow.com/questions/4496359/how-to-parse-date-string-to-date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");

        System.out.println(dateFormat.parse(date).toString());
        activityCreationService.createActivity(1, activityName, dateFormat.parse(date));
        return "boo";
    }

    @RequestMapping(path = "/All")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @RequestMapping(path = "/activities/all")
    public List<Activities> getAllActivities(){
        return activityRepository.findAll();
    }

    @RequestMapping(path = "/{id}/activities")
    public List<Activities> getActivity(@PathVariable Long id){
        return activityRepository.findActivitiesById(id);
    }

//
//    @RequestMapping("/table")
//    public String listPatients(Model model){
//        model.addAttribute("patients", patientService.getAllPatients());
//
//        return "patients";
    }

//    @RequestMapping(path = "/gp/index")
//    public String index(){
//        return "index";
//    }
//}
