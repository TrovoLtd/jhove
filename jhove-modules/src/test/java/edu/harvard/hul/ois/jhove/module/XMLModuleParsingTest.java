package edu.harvard.hul.ois.jhove.module;

import edu.harvard.hul.ois.jhove.IRepInfo;
import edu.harvard.hul.ois.jhove.module.fakes.FakeJhoveBase;
import edu.harvard.hul.ois.jhove.module.fakes.FakeRepInfo;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class XMLModuleParsingTest {

    private XmlModule testXMLModule;
    private FakeRepInfo fakeRepInfo;
    private InputStream testInputStream;

    @Before
    public void setUp() throws Exception {

        testXMLModule = new XmlModule();
        testXMLModule.setBase(new FakeJhoveBase());
        fakeRepInfo = new FakeRepInfo();

        testInputStream = this._loadXMLIntoStream(this._generatePathToXMLFile());

    }

    @Test
    public void testParse() throws IOException {

        testXMLModule.parse(testInputStream, fakeRepInfo, 0);

        IRepInfo result = testXMLModule.get_info();

        assertEquals("XML", result.getFormat());
    }

    private String _generatePathToXMLFile() {

        String test_xml_file_location = new StringBuilder()
                .append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("test")
                .append(File.separator)
                .append("resources")
                .append(File.separator)
                .append("XML")
                .append(File.separator)
                .append("simple_xml.xml")
                .toString();

        return  test_xml_file_location;
    }

    private InputStream _loadXMLIntoStream(String fileLocation) throws FileNotFoundException {

        File xmlFile = new File(fileLocation);
        InputStream result = new FileInputStream(xmlFile);
        return result;

    }

}
