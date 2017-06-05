package org.xsris.addons.xsroster.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class HelperUtils {

	public static final String getPrintStackTrace(Throwable t) {
		if (t != null) {
			final Writer result = new StringWriter();
			final PrintWriter printWriter = new PrintWriter(result);
			t.printStackTrace(printWriter);
			return result.toString();
		} else {
			return null;
		}
	}
}
