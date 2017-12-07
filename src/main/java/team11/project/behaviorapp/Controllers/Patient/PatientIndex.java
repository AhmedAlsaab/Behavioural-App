package team11.project.behaviorapp.Controllers.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import team11.project.behaviorapp.Repositories.ActivityRepository;
import team11.project.behaviorapp.Repositories.PatientRepository;
import team11.project.behaviorapp.Services.PatientService;

/**
 * Created by c1443907 on 04/12/2017.
 */

@Controller
public class PatientIndex {


    @Autowired
    PatientService patientService;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    PatientRepository patientRepository;


    @RequestMapping(path = "/patient/{id}/index")
    public String patientIndex(@PathVariable Long id, Model model) {

        String topBarTitleForIndex = "Dashboard";

        model.addAttribute("patientName", patientService.getPatientFirstLastName(id));

        model.addAttribute("activities", patientService.getActivityList(id));

        double numCompleted = activityRepository.getActivitiesByName();
        double total = activityRepository.getActivitiesByNameAndIsDeleted();
        int percent = (int) Math.round((numCompleted / total) * 100);

        model.addAttribute("topBarTitle", topBarTitleForIndex);

        model.addAttribute("favourite", patientService.getFavouritedActivities(id, true, false));
        model.addAttribute("upcoming", patientService.getUpcomingActivities(id, false, false));
        model.addAttribute("history", patientService.getUpcomingActivities(id, true, false));

        // stats
        model.addAttribute("favouriteCount", activityRepository.getActivitiesByNameAndIsFavourite());
        model.addAttribute("percent", percent);
        model.addAttribute("completedCount", activityRepository.getActivitiesByName());
        model.addAttribute("avgRating", activityRepository.getActivitiesByRatingAfter());
        model.addAttribute("totalCreated", total);
        model.addAttribute("upcomingActivities", activityRepository.getActivitiesByNameAndIsDeletedAndIsCompleted());


        return "patientIndex";
    }
}