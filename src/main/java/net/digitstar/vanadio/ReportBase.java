package net.digitstar.vanadio;

import java.io.OutputStream;
import java.util.Map;

/**
 * User: 908303
 * Date: 18-mar-2010
 */
public interface ReportBase
{

    boolean execute(Map<String, String[]> parameters, OutputStream out)
        throws Exception;

    void setReportOptions(ReportOptions reportOptions);

    ReportOptions getReportOptions();
}
