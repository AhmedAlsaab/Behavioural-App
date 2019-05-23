## SCRIPT

The Schema and the population script are in one file called "Group_11_Schema_and_Script", perform a runall in your SQL
WorkBench and you should be good to go. Due to a small set of tables and sample data the order has already been established and there are
no further instructions to follow.


## RUN

When running through boot-run you might be prompted with a "cannot establish database" error -> Please clean/build or rebuild through
Gradle and then run the main class so that the database driver gets picked up. 

## UNIT TESTS

I have pulled down the project a few times to ensure it all works and it does. There are three unit tests that test out
different components:

		PatientServiceTest:
			1)getAllPatients - Should retrieve 12 records, ensuring that the correct amount of records is 
			being fetched from the database.
			2)getPatientByName - Should return a patient with the inserted first and surname. I've written
			this to ensure that I am getting the correct patient record from my database

		MissedActivityLoggerTest:
			1)cronTest - The test will show the last execution and the next execution on a hardcoded Monday
			I left it on a Monday because I did not really care about the day as it did not really mean anything
			I was interested in ensuring that no matter when the app boots up, the next time the scheduler 
			executes a task is on the following minute, exactly on the spot. This was important because  
			otherwise, the same activity foundd would print multiple times -> This would cause multiple 
			notifications for the same activity to appear at the end-point which would be a problem.


## Checking it works

			Access:	 http://localhost:8080/patient/1/index 
	
The above URL is the starting point for the web app. 1 is the pathvariable for the patient id. The data presented belong to that patient. You can
change it to a 2 as well to see the different data for patient 2. 

1)The index acts as the homepage. You can click on the upcoming tile to see the patients upcoming activities, the same can be done for favourites.
2)Hovering over the graphs should present you with further information about the data presented.
3)Go to Activities to be create,edit,favourite,complete activities.
4)To check the notifications out create an activity for the current date and time plus 10 minutes. Ideally create an activity due in 11 minutes to
get it right the first time
5)To look at missed-notifications do the same as above but this time subtract 2 hours from the current time and on the. Ideally 1hr59 mins and
watch the countdown. On the following minute when it hits 2 hours exactly you should get prompted with a notifcation where you can edit or delete
the activity


				 http://localhost:8080/gp/patients 

Starting point for the Gp's side of the webapp.

1) Use the arrows to navigate through the sections that are present for gps
2) Once you are at patient activiteis you can click the buttons present to be prompted with patient-graphs.
