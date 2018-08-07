package com.zapi.base.TestJIRA;

import java.util.Map;

import com.zapi.base.ZapiBase;

public class TestJIRA {
	
	static String currentTest = "TC_01_Login_FreeCRM";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//ZapiBase zapiBase = new ZapiBase("TC_01_Login_FreeCRM");
		zapiUpdate("pass");
	}
	
	
	public static void zapiUpdate(String logstatus) throws Exception
	{

		if (true) {
//			if (logstatus.equals("pass")) {
//				status = Status.PASS.getValue();
//			} else if (logstatus.equals("fail")) {
//				status = Status.FAIL.getValue();
//			}
			ZapiBase zapi = new ZapiBase(currentTest);
			String issueKey = "TES-1";//getIssueKey();

			System.out.println("Key--" + issueKey + " currentTest--" + currentTest);
			String versionName = "Version 2.0";//getVersionName();
			String cycleName = "Pega Cycle";//getCycleName();
			Map<String, Map<String, String>> cycleList = zapi.getListOfCycles(versionName);
			System.out.println("cycleList "+cycleList);
			Map<String, String> testList = zapi.getTestList(cycleList, cycleName);
			System.out.println("testList "+testList);

//			if (status.equals("1")) {
//				comment = currentTest + " Passed";
//			} else 	if (status.equals("2")){
//				comment = currentTest + " Failed";
//			}
			zapi.cloneExecution(versionName, issueKey, "Updating TC", testList, cycleList, "1");
			zapi.addAttachment(testList, cycleList, "D:\\Users\\charanjeet.singh\\eclipse-workspace\\TestJIRA\\pom.xml", issueKey);
		}

	}

}
