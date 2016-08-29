package com.csmckelvey.vrhq.core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class VRHQLogger {

	private static boolean debug = false;
	private static boolean outputToFile = false;
	private static String outputFileName = null;
	private static String exceptionOutputFileName = null;

	private static VRHQLogger instance = new VRHQLogger();
	
	private VRHQLogger() {}
	
	public static VRHQLogger getLogger() {
		if (instance == null) {
			instance = new VRHQLogger();
		}
		return instance;
	}
	
	public void log(String message) {
		instance.log(message, 0, 0);
	}
		
	public void log(String message, int tabs, int extraNewLines) {
		log(message, tabs, extraNewLines, debug);
	}

	public void log(String message, int tabs, int extraNewlines, boolean override) {
		if (debug || override) {
			StringBuilder output = new StringBuilder();
			
			output.append(LocalDate.now()).append(" ").append(LocalTime.now()).append(" ");
			
			for (int i = 0; i < tabs; i++) { 
				output.append("\t"); 
			}
			
			output.append(message);
			
			for (int i = 0; i < extraNewlines; i++) { 
				output.append("\n"); 
			}
			
			System.out.println(output.toString());
			
			if (outputToFile && outputFileName != null) {
				try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName, true)))) {
					out.println(output.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void logException(Exception exception) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(exceptionOutputFileName, true)))) {
			exception.printStackTrace(out);
			exception.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isDebug() {
		return debug;
	}

	public static void setDebug(boolean debug) {
		VRHQLogger.debug = debug;
	}

	public static boolean isOutputToFile() {
		return outputToFile;
	}

	public static void setOutputToFile(boolean outputToFile) {
		VRHQLogger.outputToFile = outputToFile;
	}
	
	public static String getOutputFileName() {
		return outputFileName;
	}

	public static void setOutputFileName(String outputFileName) {
		VRHQLogger.outputFileName = outputFileName;
	}
	
	public static String getExceptionOutputFileName() {
		return exceptionOutputFileName;
	}

	public static void setExceptionOutputFileName(String exceptionOutputFileName) {
		VRHQLogger.exceptionOutputFileName = exceptionOutputFileName;
	}

}
