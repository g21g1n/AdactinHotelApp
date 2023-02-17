package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Gugan
 * @date 18-12-2022
 * @see to create jvm report
 *
 */
public class Reporting extends BaseClass {

	/**
	 * @see to create jvm report using json report
	 * @param jsonfile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void generateJvmReport(String jsonfile) throws FileNotFoundException, IOException {

		File file = new File(getProjectPath() + getPropertyFileValue("jvmpath"));
		Configuration configuration = new Configuration(file, "OMRBranchAdactinAutomation");

		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("version", "108");
		configuration.addClassifications("Platform", "Windows");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonfile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
	}

}
