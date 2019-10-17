package com.mitthsb.qa.testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.mitthsb.qa.base.TestBase;

public class UserHashMap extends TestBase{
	
	public static HashMap<String , String> getCredentialsMap() {
		
		HashMap<String , String> userMap=new HashMap<String , String>();
		userMap.put("admin", "198109231665:asd00asd!");
		userMap.put("Grund", "192101031686:asd00asd!");
		userMap.put("Maklare", "198806011642:asd00asd!");
		return userMap;		
				
		
	}
	
	public static String getUserName(String role) {
		return getCredentialsMap().get(role).split(":")[0];
		
	}
	
	public static String getPassword(String role) {
		return getCredentialsMap().get(role).split(":")[1];
		
	}
	
	

}
