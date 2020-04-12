# Empirix_Test

Steps to Run the Automated Test Suite through Jenkins

1. First create a freestyle job with any name, say “AutomationTest” in Jenkins Dashboard

2. Then Go to Jenkins Dashboard -> Manage Jenkins -> Global Tool Configuration and Click on JDK installation.

3. Click on the button “JDK installation”.

4. Click on Add JDK, then give a suitable name say “Java” and in the JAVA_HOME field, give the path where JDK is present 
   in your machine. Remember to uncheck “Install Automatically” checkbox. Save the configuration

5. Then go back to Jenkins Dashboard and click the created job “AutomationTest” to change the configuration and click on the      “Configure” Link and do the following changes.
      
	a) Give a brief description of the Job
	b) On the Build Tab, Click on “Add build step” button and then choose “Execute Windows Batch command” or “Execute      	          Shell”, depending on the underlying operating system (Windows or Mac OS) and then click on Save button.

6. Go back to the created Job and click on the “Build Now” link on the left.

Result - Under the Build History, you will se the job in running state and on clicking the White Ball, you can see the Console Output of the job execution. 


----------------------------------------------------------------------------------------------------------------------------------------------------------

Alternatively, if the project involves Maven, following will be some of the changes in the above steps.

1.  Job created will be a Maven Job (ensure that Maven Plugin is installed in the Jenkins)

(Steps 2-4 will be same, as mentioned above)

5. In the configuration part of the job, following modifications will be needed.
	
	a) Give a brief description of the Job
	
	b) Choose GIT from the Source Code Management Tab and then give the following
	    details
		
		i) Give the Repository URL (https://github.com/dabasank/Empirix_Test.git)
	   	   and if the Repository is Private, then provide the
		   credentials also.
	           ii) Branch will be auto-populated with */master, change the value if you are
		   using a different branch.
	
	c) In the Build Triggers Tab, select the Poll SCM checkbox to change the 
	    schedule when Jenkins has to poll the GIT.
	   
	    e.g. * * * * *  -> This CRON Expression will poll the GIT every minute for any changes
			     in the Source Code.

	d) In the Build tab, provide the name of the XML Configuration file in the RooT POM
	    field, usually it is pom.xml and in the Goals and Options field, write the MAVEN Goal.
	    In this case, it should be “clean test”.	    
 



 
