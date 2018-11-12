package edu.harvard.hul.ois.jhove.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import edu.harvard.hul.ois.jhove.*;
import org.junit.Before;
import org.junit.Test;

public class WaveModuleTest {

	private WaveModule module;

	@Before
	public void setUp() throws Exception {
		module = new WaveModule();
		IJhoveBase je = new JhoveBase();
		module.setBase(je);
	}

	@Test
	public void testSample3() throws IOException {
		File f = new File("src/test/resources/wave/sample3.wav");
		IRepInfo info = new RepInfo(f.getName());

		// Parse
		module.parse(new FileInputStream(f), info, 0);

		// Check that JHOVE found this was NOT well formed:
		assertEquals("Should not be well formed. ", info.getWellFormed(),
                IRepInfo.FALSE);

		// Check that there is a message:
		assertTrue("There should be at least one message. ", info.getMessage()
				.size() > 0);

		// Go though messages looking for the expected error:
		boolean foundEofMessage = false;
		for( Message m : info.getMessage()) {
			if ("Unexpected end of file".equals(m.getMessage())
					&& m.getOffset() == 96) {
				foundEofMessage = true;
			}
			System.out.println("MESSAGE: " + m.getMessage() + " "
					+ m.getSubMessage()
					+ " @" + m.getOffset());
		}
		// Fail if the error was not found.
		assertTrue("The message 'Unexpected end of file'@96 was not found. ",
				foundEofMessage);
	}

}
