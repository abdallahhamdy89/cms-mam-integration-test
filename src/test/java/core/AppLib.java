package core;

import com.plutotv.core.configUtils.PropertiesHolder;
import com.plutotv.test.lib.LogUtils;
import com.plutotv.test.lib.WaitUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppLib {
	public static int waitTimeSec = 60;


	public String getHomePageLink() {
		String baseUrl;
		baseUrl = PropertiesHolder.getInstance().getClientUrl();
		return baseUrl;
	}

	public void reportPreTestDetails(String env, String baseUrl) {
		LogUtils.logInfoMessage("Running tests for environment: [" + env + "] - Url: " + baseUrl);
	}

	public void displayMapValues(HashMap<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			LogUtils.logInfoMessage(entry.getKey() + " - " + entry.getValue());
		}
	}

	public static void sleep(int time) {
		LogUtils.logInfoMessage("Sleeping for [" + time + "] ms");
		WaitUtils.sleep(time);
	}
	
	public static String getUniqueDateString() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		String dateStamp = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss").format(new Date(cal.getTimeInMillis()));
		return dateStamp;
	}
	
}
