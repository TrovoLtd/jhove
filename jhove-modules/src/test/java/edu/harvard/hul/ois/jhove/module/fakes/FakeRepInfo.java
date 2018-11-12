package edu.harvard.hul.ois.jhove.module.fakes;

import edu.harvard.hul.ois.jhove.*;

import java.util.*;

public class FakeRepInfo implements IRepInfo {

    private int _wellFormed;
    private String _format;
    private String _mimeType;
    private int _valid;

    private List<Message> _message;

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public void copy(RepInfo info) {

    }

    @Override
    public List<Checksum> getChecksum() {
        return null;
    }

    @Override
    public Date getCreated() {
        return null;
    }

    @Override
    public String getFormat() {
        return this._format;
    }

    @Override
    public Date getLastModified() {
        return null;
    }

    @Override
    public List<Message> getMessage() {
        return _message;
    }

    @Override
    public String getMimeType() {
        return this._mimeType;
    }

    @Override
    public Module getModule() {
        return null;
    }

    @Override
    public List<String> getProfile() {
        return null;
    }

    @Override
    public Map<String, Property> getProperty() {
        return null;
    }

    @Override
    public Property getProperty(String name) {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public String getUri() {
        return null;
    }

    @Override
    public boolean getURLFlag() {
        return false;
    }

    @Override
    public boolean isConsistent() {
        return false;
    }

    @Override
    public int getWellFormed() {
        return this._wellFormed;
    }

    @Override
    public int getValid() {

        return this._valid;
    }

    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public String getNote() {
        return null;
    }

    @Override
    public List<String> getSigMatch() {
        return null;
    }

    @Override
    public Property getByName(String name) {
        return null;
    }

    @Override
    public void setChecksum(Checksum checksum) {

    }

    @Override
    public void setConsistent(boolean consistent) {

    }

    @Override
    public void setCreated(Date created) {

    }

    @Override
    public void setFormat(String format) {
        this._format = format;
    }

    @Override
    public void setLastModified(Date lastModified) {

    }

    @Override
    public void setMessage(Message message) {
        this._message.add(message);
    }

    @Override
    public void setMimeType(String mimeType) {
        this._mimeType = mimeType;
    }

    @Override
    public void setModule(Module module) {

    }

    @Override
    public void setProfile(String profile) {

    }

    @Override
    public void setProperty(Property property) {

    }

    @Override
    public void setSize(long size) {

    }

    @Override
    public void setURLFlag(boolean flag) {

    }

    @Override
    public void setWellFormed(boolean wellFormed) {
        this._wellFormed = wellFormed ? TRUE : FALSE;
    }

    @Override
    public void setWellFormed(int wellFormed) {
        this._wellFormed = wellFormed;
    }

    @Override
    public void setValid(boolean valid) {
        this._valid = valid ? TRUE : FALSE;
    }

    @Override
    public void setValid(int valid) {
        this._valid = valid;
    }

    @Override
    public void setVersion(String version) {

    }

    @Override
    public void setNote(String note) {

    }

    @Override
    public void setSigMatch(String modname) {

    }

    @Override
    public void setSigMatch(List<String> modnames) {

    }

    @Override
    public void show(OutputHandler handler) {

    }
}
