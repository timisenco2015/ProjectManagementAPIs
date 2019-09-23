package ca.timisencotech.projectmanagementapis.validation;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CustomJSONObject{
	
	private HashMap<String, Object> map;
	
	public CustomJSONObject()
	{
		map = new HashMap<String, Object>();
	}
	
	

	
	public Object getString(String key) {
		
		return map.get(key);
	}

	

	public void put(String key, Object object) {
		map.put(key, object);
	}



	public Object remove(String key) {
		return map.remove(key);
	}




	

	

	

}
