import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class XMLAnalyzerIT {

    private static ArrayList<String> _result;

    /**
     * This class-level setup wraps up the command line to call JHOVE with a given set of
     * parameters, then writes the output to an ArrayList<String>, so that individual pieces
     * of output can be tested depending upon given inputs.
     *
     * This page was very helpful when working out how Java Process classes work:
     * https://www.developer.com/java/data/understanding-java-process-and-java-processbuilder.html
     *
     * This is an Integration Test, so it's intended as a check that the application is still
     * hanging together OK. It's not intended to test all the functionality. Functional tests
     * like that should be covered by Unit Tests that can be run much closer to the code under test.
     *
     * However - it's going to be hard to refactor JHOVE to get those sorts of tests in place, so
     * Integration Tests like this are part of the safety net that checks such refactorings haven't
     * broken anything major. So a good set of 'happy path tests' for each module and output handler
     * combination at this Integration Testing point should be put in place before too much refactoring
     * goes on, as well as some of the more obvious errors (e.g. pointing it at a missing file, using a
     * module for one format for a file of another, etc).
     *
     * @throws IOException because the output of the command line wrapping Process object is an
     * InputStream. However - this is a test class, so the last thing you should ever do with
     * a test is swallow any unexpected exceptions.
     *
     * (Actually, that's the second-last thing - the last thing you should do is push them into
     * version control when they're failing...)
     */

    @BeforeClass
    public static void setupClass() throws IOException {

        String javaExe =  new StringBuilder()
                .append(System.getProperty("java.home"))
                .append(File.separator)
                .append("bin")
                .append(File.separator)
                .append("java")
                .toString();

        /*
            The StringBuilder below is for example purposes only -
            it is based on the assumption that there is an Ant task
            that copies the output JAR from jhove-app to the resources directory
            in jhove-integration-tests/src/test

            Other that that, I've tried to make it cross-platform compatible etc
         */

        String jarLocation = new StringBuilder()
                .append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("test")
                .append(File.separator)
                .append("resources")
                .append(File.separator)
                .append("jhove-apps-it.jar")
                .toString();

        String test_xml_file_location = new StringBuilder()
                .append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("test")
                .append(File.separator)
                .append("resources")
                .append(File.separator)
                .append("simple_xml.xml")
                .toString();

        /*
            This debug config file location variable is also completely inelegant and
            only exists because of issues explained in more depth here:
            http://www.dpoc.ac.uk/2018/08/09/jhove-running-in-a-debugger/
         */

        String debug_config_file_location = new StringBuilder()
                .append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("test")
                .append(File.separator)
                .append("resources")
                .append(File.separator)
                .append("jhove_debug.conf")
                .toString();

        ProcessBuilder pb = new ProcessBuilder(javaExe,
                "-jar",
                jarLocation,
                "-m",
                "xml-hul",
                "-h",
                "text",
                test_xml_file_location,
                "-c",
                debug_config_file_location);

        final Process p = pb.start();

        InputStreamReader isr = new InputStreamReader(p.getInputStream());

        BufferedReader br = new BufferedReader(isr);

        _result = new ArrayList<String>();

        String line;

        while((line = br.readLine()) != null) {
            _result.add(line);
        }

    }

    @Test
    public void testXMLAnalyzerReturnsAFileSizeOf4709OnLine6() {
        assertTrue(_result.get(5).contains("Size: 4709"));
    }

    @Test
    public void testXMLAnalyzerReturnsAFormatOfXMLOnLine7() {
        assertTrue(_result.get(6).contains("Format: XML"));
    }

    @Test
    public void testXMLAnalyzerReturnsAVersionOf1_0OnLine8() {
        assertTrue(_result.get(7).contains("Version: 1.0"));
    }

    // ... etc etc etc

}
