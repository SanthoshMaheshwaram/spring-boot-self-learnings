What is maven:
**************


What is maven plugin:
*********************
Maven is actually a plugin execution framework where every task is actually done by plugins. Maven Plugins are generally used to −

-->create jar file
-->create war file
-->compile code files
-->unit testing of code
-->create project documentation
-->create project reports

A plugin generally provides a set of goals, which can be executed using the following syntax −

mvn [plugin-name]:[goal-name]
For example, a Java project can be compiled with the maven-compiler-plugin's compile-goal by running the following command.

mvn compiler:compile

maven plugin types:
*******************
-->Build plugins
They execute during the build process and should be configured in the <build/> element of pom.xml.
-->Reporting plugins
They execute during the site generation process and they should be configured in the <reporting/> element of the pom.xml.

below are few common plugins:
*****************************
1. clean
    Cleans up target after the build. Deletes the target directory.
2. compiler
    Compiles Java source files.
3. surefire
    Runs the JUnit unit tests. Creates test reports.
4. jar
    Builds a JAR file from the current project.
5. war
    Builds a WAR file from the current project.
6. javadoc
    Generates Javadoc for the project.
7. antrun
    Runs a set of ant tasks from any phase mentioned of the build.

below is the command to generate maven project:
***********************************************
--> maven uses archetype plugin to create a simple java application with structure as per its template
--> this also generates the project structure, src/main/resource, src/main/java, scr/test/java
--> maven-archetype-webapp, for creating a web application(which generates src/main/webapp/WEB-INF structure and so on)
mvn archetype:generate
-DgroupId = com.companyname.bank
-DartifactId = consumerBanking
-DarchetypeArtifactId = maven-archetype-quickstart
-DinteractiveMode = false


Brief on one command:
*********************
mvn clean package
    --> first command clean, cleans the target directory
    --> package command, first compiles the source code files, tests the source code files, and then run the test cases.
    --> then generates the jar

SNAPSHOT vs version:
********************
SNAPSHOT indicates the development is still going on
version, indicates a fixed version is available


Quick background on CI (Continuous Integration):
************************************************
Consider a team is developing a project bus-core-api on which two other projects app-web-ui and app-desktop-ui are dependent.
app-web-ui project is using 1.0-SNAPSHOT of bus-core-api project.
app-desktop-ui project is using 1.0-SNAPSHOT of bus-core-api project.

Now, teams of app-web-ui and app-desktop-ui projects require that their build process should kick off whenever bus-core-api project changes.
Using snapshot, ensures that the latest bus-core-api project should be used but to meet the above requirement we need to do something extra.

We can proceed with the following two ways −
Add a post-build goal in bus-core-api pom to kick-off app-web-ui and app-desktop-ui builds.
Use a Continuous Integration (CI) Server like Hudson to manage build automation automatically.

Using Continuous Integration Service with Maven:
************************************************
Using a CI Server is more preferable to developers. It is not required to update the bus-core-api project, every time a new project
(for example, app-mobile-ui) is added, as dependent project on bus-core-api project. Hudsion is a continuous integration tool written in java,
which in a servlet container, such as, Apache tomcat and glassfish application server. Hudson automatically manages build automation using
Maven dependency management. The following snapshot will define the role of Hudson tool.

Hudson considers each project build as job. Once a project code is checked-in to SVN (or any Source Management Tool mapped to Hudson), Hudson starts
its build job and once this job gets completed, it start other dependent jobs (other dependent projects) automatically.

In the above example, when bus-core-ui source code is updated in SVN, Hudson starts its build. Once build is successful, Hudson looks for dependent
projects automatically, and starts building app-web-ui and app-desktop-ui projects.


1. Transitive Dependencies
2. External Dependencies

Dependency Scope:
*****************
1. compile
    This scope indicates that dependency is available in classpath of project. It is default scope.
2. provided
    This scope indicates that dependency is to be provided by JDK or web-Server/Container at runtime.
3. runtime
    This scope indicates that dependency is not required for compilation, but is required during execution.
4. test
    This scope indicates that the dependency is only available for the test compilation and execution phases.
5. system
    This scope indicates that you have to provide the system path.
6. import
   This scope is only used when dependency is of type pom. This scope indicates that the specified POM should be replaced with the dependencies
   in that POM's <dependencyManagement> section.

Maven - Deployment Automation:
******************************
In project development, normally a deployment process consists of the following steps −

1. Check-in the code from all project in progress into the SVN (version control system) or source code repository and tag it.
2. Download the complete source code from SVN.
3. Build the application.
4. Store the build output either WAR or EAR file to a common network location.
5. Get the file from network and deploy the file to the production site.
6. Updated the documentation with date and updated version number of the application.

Problem Statement:
******************
There are normally multiple people involved in the above-mentioned deployment process. One team may handle check-in of code,
other may handle build and so on. It is very likely that any step may be missed out due to manual efforts involved and owing to multi-team environment.
For example, older build may not be replaced on network machine and deployment team deployed the older build again.

Solution:
*********
Automate the deployment process by combining the following −
1. Maven, to build and release projects.
2. SubVersion, source code repository, to manage source code.
3. Remote Repository Manager (Jfrog/Nexus) to manage project binaries.










Installation:
*************
download and unzip the maven zip file.

set below system environment variables

MAVEN_HOME = C:\Program Files\apache-maven-3.8.4-bin\apache-maven-3.8.4
path = %MAVEN_HOME%\bin;

mvn package (build package)
mvn clean install
mvn clean install -U
mvn spring-boot:run
.\mvnw spring-boot:run

mvn -B archetype:generate -DgroupId=com.sohamkamani -DartifactId=mvn-example -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
mvn compile
mvn package
java -jar target/mvn-example-1.0-SNAPSHOT.jar
mvn clean compile package
java -jar target/mvn-example-1.0-SNAPSHOT.jar

errors:
*******
log cannot be resolved --> in slf4j
https://www.youtube.com/watch?v=YWXcPaPO2ZM

STS:
****
https://spring.io/tools3/sts/all

https://www.youtube.com/watch?v=etSxiO7YCLE
https://github.com/spring-projects/toolsuite-distribution/wiki/Spring-Tool-Suite-3

mvn dependency:tree

lombok issues:
**************
https://stackoverflow.com/questions/56523530/lombok-installation-in-spring-tool-suite-4-for-windows

1) place the lombok in this STS.exx path
2) SpringToolSuite4  to sts 
3) prior to this, also deleted .jar and jar_some_file from the regedit "HKEY_CURRENT_USER"

adding local jar file into the POM.file:
****************************************
https://intellipaat.com/community/6786/how-to-add-local-jar-files-to-a-maven-project

2nd approach is working in my local when tested.


How to add local jar files into files which are generated by one POM.xml maven projectt into another POM.xml maven project??
****************************************************************************************************************************
link: https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html

1) build the latest jar using "mvn clean install" command for primary maven project.
	
	primary pom contains below:
	***************************
	<groupId>com.datafoundry</groupId>
    <artifactId>rr-java</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    <name>rr-java</name>
	
2) now below command as a single line, in local or jenkins/maven repository.
	mvn install:install-file 
	-Dfile=C:\Users\Admin\Desktop\Msafety\newRepositories\SSH\rr-java\target\rr-java-1.0-SNAPSHOT.jar 
	-DgroupId=com.datafoundry 
	-DartifactId=rr-java 
	-Dversion=1.0-SNAPSHOT 
	-Dpackaging=jar 
	-DgeneratePom=true
3) after this now, add this primary dependency in main POM.xml
	<dependency>
		<groupId>com.datafoundry</groupId>
		<artifactId>rr-java</artifactId>
		<version>1.0-SNAPSHOT</version>
<!--		<scope>system</scope>
			<systemPath>${basedir}/lib/rr-java-1.0-SNAPSHOT.jar</systemPath>  -->
	</dependency>
4) NOTE: The above commented lines are only required, if we manually places the primary jar within the "lib" folder of our project.
5) now build the main project jar by running (mvn clean install)
6) this will generate a target directory with a jar (which contains BOOT-INF and META-INFO)
7) BOOT-INF interns conatins the "/lib" folder which contains all dependent jars including the primary jar as well

8) 

9)

10)

11)



