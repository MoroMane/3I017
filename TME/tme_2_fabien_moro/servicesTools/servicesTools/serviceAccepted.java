package servicesTools;

import org.json.JSONObject;

public class serviceAccepted {
	
	public static JSONObject serviceAccepted ()
	{
		JSONObject response=new JSONObject();
		try
		{
			response.put("status","ok");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}
}
