package vn.edu.hcmuaf.fit.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import vn.edu.hcmuaf.fit.constant.GHNContent;

public class DistrictGHNUtils {
	public static int getDistrictId(String name) {
		int result = -1;
		try {
			URL url = new URL(GHNContent.LINK_GET_DISTRICT);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", GHNContent.CONTENT_TYPE);
			connection.setRequestProperty("Token", GHNContent.GHN_CLIENT_ID);
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();

			// Phân tích response để lấy DistrictID
			JSONObject json = new JSONObject(response.toString());
			JSONArray data = json.getJSONArray("data");

			for (int i = 0; i < data.length(); i++) {
				JSONObject district = data.getJSONObject(i);
				if (district.getString("DistrictName").equals(name)) {
					result = district.getInt("DistrictID");
					break;
				}
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

}
