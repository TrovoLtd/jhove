package com.mcgath.jhove.module.png;

import edu.harvard.hul.ois.jhove.*;

/** The hIST (Histogram) chunk */
public class HistChunk extends PNGChunk {

	/** Constructor */
	public HistChunk(int sig, long leng) {
		chunkType = sig;
		length = leng;
		ancillary = true;
		duplicateAllowed = false;
	}
	
	/** Process the data in the chunk. All we do is note the
	 *  presence of the chunk in a property.  */
	public void processChunk(IRepInfo info) throws Exception {
		final String badChunk = "Bad hIST chunk";
		processChunkCommon(info);
		ErrorMessage msg = null;
		if (!_module.isPlteSeen()) {
			msg = new ErrorMessage ("hIST chunk found without preceding PLTE chunk");
		}
		else if (_module.isIdatSeen()) {
			msg = new ErrorMessage ("hIST chunk is not allowed after IDAT chunk");
		}
		if (msg != null) {
			info.setMessage (msg);
			info.setWellFormed (false);
			throw new PNGException (badChunk);
		}
		Property prop = new Property ("Histogram",
				PropertyType.STRING,
				"present");
		info.setProperty (prop);
		for (int i = 0; i < length; i++) {
			readUnsignedByte();
		}
	}
}
