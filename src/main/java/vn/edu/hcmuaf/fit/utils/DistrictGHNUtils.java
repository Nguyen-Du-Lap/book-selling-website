package vn.edu.hcmuaf.fit.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();
			// Phân tích response để lấy DistrictID
			JSONObject jsonObject = new JSONObject(response.toString());

			JSONArray data = jsonObject.getJSONArray("data");

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
	public static int getDistrictIdOfWard(String name, int huyen) {
		int result = -1;
		try {
			URL url = new URL("https://online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Token", GHNContent.GHN_CLIENT_ID);
			conn.setDoOutput(true);

			JSONObject jsonInput = new JSONObject();
			jsonInput.put("district_id", huyen);

			String jsonInputString = jsonInput.toString();

			conn.getOutputStream().write(jsonInputString.getBytes());

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();
			// Phân tích response để lấy DistrictID
			JSONObject jsonObject = new JSONObject(response.toString());

			JSONArray data = jsonObject.getJSONArray("data");
			for (int i = 0; i < data.length(); i++) {
				JSONObject district = data.getJSONObject(i);
				if (district.getString("WardName").equals(name)) {
					result =district.getInt("WardCode");
					break;
				}
			}

			return  result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


}
