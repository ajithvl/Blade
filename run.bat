mvn clean assembly:assembly
java -cp target/Blade-1.0-jar-with-dependencies.jar org.testng.TestNG config/testng.xml