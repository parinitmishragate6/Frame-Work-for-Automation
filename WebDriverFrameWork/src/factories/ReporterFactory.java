package factories;

import java.io.IOException;

import reporter.TextReporter;

public class ReporterFactory {

	private static TextReporter reporter = null;
	
	public static TextReporter getReporter() {
		
		if (reporter == null) {
			try {
				reporter = new TextReporter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reporter;
	}
}
