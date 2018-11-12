package edu.harvard.hul.ois.jhove.module;

import edu.harvard.hul.ois.jhove.module.fakes.FakeRepInfo;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class XMLModuleParsingTest {

    private XmlModule testXMLModule;
    private FakeRepInfo fakeRepInfo;
    private InputStream testInputStream;

    @Before
    public void setUp() throws Exception {

        testXMLModule = new XmlModule();
        fakeRepInfo = new FakeRepInfo();

        testInputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

    }

    @Ignore
    @Test
    public void testParse() throws IOException {

        testXMLModule.parse(testInputStream, fakeRepInfo, 0);

        String result = testXMLModule.get_info().getFormat();

        assertEquals("XML", result);
    }
}
