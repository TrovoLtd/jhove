package edu.harvard.hul.ois.jhove.module.fakes;

import edu.harvard.hul.ois.jhove.*;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FakeJhoveBase implements IJhoveBase {
    @Override
    public void init(String configFile, String saxClass) throws JhoveException {

    }

    @Override
    public void setCallback(Callback callback) {

    }

    @Override
    public void dispatch(App app, Module module, OutputHandler aboutHandler, OutputHandler handler, String outputFile, String[] dirFileOrUri) throws Exception {

    }

    @Override
    public boolean process(App app, Module module, OutputHandler handler, String dirFileOrUri) throws Exception {
        return false;
    }

    @Override
    public File connToTempFile(URLConnection conn, IRepInfo info) throws IOException {
        return null;
    }

    @Override
    public void abort() {

    }

    @Override
    public boolean processFile(App app, Module module, boolean verbose, File file, IRepInfo info) throws Exception {
        return false;
    }

    @Override
    public File tempFile() throws IOException {
        return null;
    }

    @Override
    public boolean getAbort() {
        return false;
    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public String getConfigFile() {
        return null;
    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public String getEncoding() {
        return null;
    }

    @Override
    public Map<String, String> getExtension() {
        return null;
    }

    @Override
    public String getExtension(String name) {
        return null;
    }

    @Override
    public OutputHandler getHandler(String name) {
        return null;
    }

    @Override
    public Map<String, OutputHandler> getHandlerMap() {
        return null;
    }

    @Override
    public List<OutputHandler> getHandlerList() {
        return null;
    }

    @Override
    public String getJhoveHome() {
        return null;
    }

    @Override
    public Module getModule(String name) {
        return null;
    }

    @Override
    public Map<String, Module> getModuleMap() {
        return null;
    }

    @Override
    public List<Module> getModuleList() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getOuputFile() {
        return null;
    }

    @Override
    public String getRelease() {
        return null;
    }

    @Override
    public String getRights() {
        return null;
    }

    @Override
    public String getSaxClass() {
        return null;
    }

    @Override
    public String getTempDirectory() {
        return null;
    }

    @Override
    public int getSigBytes() {
        return 0;
    }

    @Override
    public File getSaveDirectory() {
        return null;
    }

    @Override
    public boolean getChecksumFlag() {
        return false;
    }

    @Override
    public boolean getShowRawFlag() {
        return false;
    }

    @Override
    public boolean getSignatureFlag() {
        return false;
    }

    @Override
    public String getMixVersion() {
        return null;
    }

    @Override
    public void setBufferSize(int bufferSize) {

    }

    @Override
    public void setEncoding(String encoding) {

    }

    @Override
    public void setTempDirectory(String tempDir) {

    }

    @Override
    public void setLogLevel(String level) {

    }

    @Override
    public void setChecksumFlag(boolean checksum) {

    }

    @Override
    public void setShowRawFlag(boolean raw) {

    }

    @Override
    public void setSignatureFlag(boolean signature) {

    }

    @Override
    public void setSaveDirectory(File dir) {

    }

    @Override
    public void setCurrentThread(Thread t) {

    }

    @Override
    public void resetAbort() {

    }

    @Override
    public File newTempFile() throws IOException {
        return null;
    }
}
