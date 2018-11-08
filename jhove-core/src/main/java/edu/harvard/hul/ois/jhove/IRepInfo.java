package edu.harvard.hul.ois.jhove;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IRepInfo extends Cloneable {
    /** Values for _valid */
    int
        TRUE = 1;
    int FALSE = 0;
    int UNDETERMINED = -1;

    Object clone();

    void copy(RepInfo info);

    List<Checksum> getChecksum();

    Date getCreated();

    String getFormat();

    Date getLastModified();

    List<Message> getMessage();

    String getMimeType();

    Module getModule();

    List<String> getProfile();

    Map<String, Property> getProperty();

    Property getProperty(String name);

    long getSize();

    String getUri();

    boolean getURLFlag();

    boolean isConsistent();

    int getWellFormed();

    int getValid();

    String getVersion();

    String getNote();

    List<String> getSigMatch();

    Property getByName(String name);

    void setChecksum(Checksum checksum);

    void setConsistent(boolean consistent);

    void setCreated(Date created);

    void setFormat(String format);

    void setLastModified(Date lastModified);

    void setMessage(Message message);

    void setMimeType(String mimeType);

    void setModule(Module module);

    void setProfile(String profile);

    void setProperty(Property property);

    void setSize(long size);

    void setURLFlag(boolean flag);

    void setWellFormed(boolean wellFormed);

    void setWellFormed(int wellFormed);

    void setValid(boolean valid);

    void setValid(int valid);

    void setVersion(String version);

    void setNote(String note);

    void setSigMatch(String modname);

    void setSigMatch(List<String> modnames);

    void show(OutputHandler handler);
}
