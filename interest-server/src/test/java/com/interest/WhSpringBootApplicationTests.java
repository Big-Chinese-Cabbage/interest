package com.interest;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class WhSpringBootApplicationTests {

    @Test
    public void test(){

    }

	@Test
	public void QQOauth2Test(){
		try {
			String s = "callback( {\"client_id\":\"YOUR_APPID\",\"openid\":\"YOUR_OPENID\"} );";
			s = s.split("\\(")[1].split("\\)")[0];
			System.out.println(new JSONObject(s).get("openid"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
