package edu.harvard.hul.ois.jhove;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IJhoveBase {
    String _name = "JhoveBase";

    void init(String configFile, String saxClass) throws JhoveException;

    void setCallback(Callback callback);

    void dispatch(App app, Module module, OutputHandler aboutHandler,
                  OutputHandler handler, String outputFile, String[] dirFileOrUri)
            throws Exception;

    boolean process(App app, Module module, OutputHandler handler,
                    String dirFileOrUri) throws Exception;

    File connToTempFile(URLConnection conn, IRepInfo info)
                            throws IOException;

    void abort();

    boolean processFile(App app, Module module, boolean verbose,
                        File file, IRepInfo info) throws Exception;

    File tempFile() throws IOException;

    boolean getAbort();

    int getBufferSize();

    String getConfigFile();

    Date getDate();

    String getEncoding();

    Map<String, String> getExtension();

    String getExtension(String name);

    OutputHandler getHandler(String name);

    Map<String, OutputHandler> getHandlerMap();

    List<OutputHandler> getHandlerList();

    String getJhoveHome();

    Module getModule(String name);

    Map<String, Module> getModuleMap();

    List<Module> getModuleList();

    String getName();

    String getOuputFile();

    String getRelease();

    String getRights();

    String getSaxClass();

    String getTempDirectory();

    int getSigBytes();

    File getSaveDirectory();

    boolean getChecksumFlag();

    boolean getShowRawFlag();

    boolean getSignatureFlag();

    String getMixVersion();

    void setBufferSize(int bufferSize);

    void setEncoding(String encoding);

    void setTempDirectory(String tempDir);

    void setLogLevel(String level);

    void setChecksumFlag(boolean checksum);

    void setShowRawFlag(boolean raw);

    void setSignatureFlag(boolean signature);

    void setSaveDirectory(File dir);

    void setCurrentThread(Thread t);

    void resetAbort();

    File newTempFile() throws IOException;
}
