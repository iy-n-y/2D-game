Before you can build the program, make sure you have the latest version of the java jdk and jre installed, along with the latest version of maven. If running on windows, make sure you have properly configured your environment variables.
Specifically you want to make sure your PATH variable contains a path to the jdk bin, and you need to make sure you're JAVA_HOME variable is set to the folder which contains your jdk (this is necessary for the javadoc to be generated).

• Running the program:

First of all to build the jar, first run,

    mvn package
    
from the mavenBuild directory, then simply run,

	java -jar target/group7project-1.0.0.jar
	
on terminal or command prompt to execute the program. If you wish to run the program by clicking on the jar directly, the src folder must be in the same directory as the jar file, or else java will throw an IIOException, as it will be unable to locate the resources.

If you want to run test on our program, then simply run,

    mvn test
    
Additionally, to generate javadocs for the program, run,

    mvn install

