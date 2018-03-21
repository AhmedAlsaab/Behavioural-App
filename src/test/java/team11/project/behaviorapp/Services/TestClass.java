package team11.project.behaviorapp.Services;

/**
 * Created by c1443907 on 21/03/2018.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestClass {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);

        String message = "The result is : " + result;
        logger.info(message);

    }

    @Test
    public void cronTest(){
        // import the cron scheduler
        org.springframework.scheduling.support.CronTrigger trigger =
                // Setting it to run at every minute of every hour of everyday ....
                new CronTrigger("0 0/1 * * * *");

        // Use the calendar to set the days
        Calendar today = Calendar.getInstance();
        today.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss EEEE");

        final Date yesterday = today.getTime();

        logger.info("Last Execution : " + df.format(yesterday));

        Date nextExecutionTime = trigger.nextExecutionTime(
                new TriggerContext() {

                    @Override
                    public Date lastScheduledExecutionTime() {
                        return yesterday;
                    }

                    @Override
                    public Date lastActualExecutionTime() {
                        return yesterday;
                    }

                    @Override
                    public Date lastCompletionTime() {
                        return yesterday;
                    }
                });

        String message = "Next Execution : " + df.format(nextExecutionTime);
        logger.info(message);

    }

}