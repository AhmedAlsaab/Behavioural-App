//package team11.project.behaviorapp.Component;
//
///**
// * Created by c1443907 on 01/01/2018.
// */
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.TriggerContext;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import team11.project.behaviorapp.AbstractTest;
//import team11.project.behaviorapp.Entities.Patient;
//import static org.hamcrest.Matchers.hasProperty;
//
//
//import javax.transaction.Transactional;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.allOf;
//import static org.hamcrest.CoreMatchers.hasItems;
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//public class MissedActivityLoggerTest extends AbstractTest {
//
//    // A test to verify that the Cron trigger does indeed work on the schedule i have set it to
//    @Test
//    public void cronTest(){
//        // import the cron scheduler
//        org.springframework.scheduling.support.CronTrigger trigger =
//                // Setting it to run at every minute of every hour of everyday ....
//                new CronTrigger("0 0/1 * * * *");
//
//        // Use the calendar to set the days
//        Calendar today = Calendar.getInstance();
//        today.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss EEEE");
//
//        final Date yesterday = today.getTime();
//
//        logger.info("Last Execution : " + df.format(yesterday));
//
//        Date nextExecutionTime = trigger.nextExecutionTime(
//                new TriggerContext() {
//
//                    @Override
//                    public Date lastScheduledExecutionTime() {
//                        return yesterday;
//                    }
//
//                    @Override
//                    public Date lastActualExecutionTime() {
//                        return yesterday;
//                    }
//
//                    @Override
//                    public Date lastCompletionTime() {
//                        return yesterday;
//                    }
//                });
//
//        String message = "Next Execution : " + df.format(nextExecutionTime);
//        logger.info(message);
//
//    }
//
//    // https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html
//    // https://stackoverflow.com/questions/17327956/testing-scheduled-in-spring Taken and adapted
//
//}
