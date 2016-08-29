package com.csmckelvey.vrhq.core;

public class Constants {

	public static final String VERSION = "1.0";
	
	public static final String APPLICATION_NAME = "VRHQ";
	public static final String SERVER_NAME = "VRHQServer";
	public static final String CLIENT_NAME = "VRHQClient";
	
	public static final String PROPERTY_FILENAME = "config.properties";
	
	public static final int SC_PING = 0;
	public static final int SC_TRACE = 1;
	public static final int SC_STATUS = 2;
	public static final int SC_NETWORK_INFO = 3;
	public static final int SC_SCAN_NETWORK = 4;
	public static final int SC_LIST_NETWORKS = 5;
	public static final int SC_CONNECT_NETWORK = 6;
	
	private Constants() { throw new IllegalAccessError("Utility class"); }
}
