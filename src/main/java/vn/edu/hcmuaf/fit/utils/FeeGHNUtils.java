package vn.edu.hcmuaf.fit.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.hc.core5.net.URIBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;
import vn.edu.hcmuaf.fit.constant.GHNContent;

public class FeeGHNUtils {

	public static String registerShipForDeliver(String height, String lenght, String with, String weght, int from_district_id, int from_ward_id, String tenHuyen, String tenXa) {
		String apiUrl = "http://140.238.54.136/api/registerTransport";
		String authToken = token();
		ArrayList<String> result = new ArrayList<>();
		try {
			int districtId_to = DistrictGHNUtils.getDistrictId(tenHuyen);
			int ward_id_to = DistrictGHNUtils.getDistrictIdOfWard(tenXa, districtId_to);
			Map<String, String> params = new HashMap<>();
			params.put("height", height);
			params.put("length", lenght);
			params.put("width", with);
			params.put("weight", weght);
			params.put("from_district_id", from_district_id + "");
			params.put("from_ward_id", from_ward_id + "");
			params.put("to_district_id", districtId_to + "");
			params.put("to_ward_id", ward_id_to + "");
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, String> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(param.getValue(), "UTF-8"));
			}
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + authToken);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Content-Length", Integer.toString(postData.toString().getBytes().length));
			con.setDoOutput(true);
			con.getOutputStream().write(postData.toString().getBytes(StandardCharsets.UTF_8));
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Parse the JSON response to get the cost and time

			JSONObject jsonObject = new JSONObject(response.toString());
			JSONObject transportObject = jsonObject.getJSONObject("Transport");
			String id = transportObject.getString("id");

			return id;


		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public static String token() {
		try {
			HttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("http://140.238.54.136/api/auth/login");

			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("email", "sosinhsv1b@gmail.com"));
			params.add(new BasicNameValuePair("password", "123456"));

			httpPost.setEntity(new UrlEncodedFormEntity(params));
			httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");

			HttpEntity httpEntity = httpClient.execute(httpPost).getEntity();
			String response = EntityUtils.toString(httpEntity);
			String token = response.replace("{\"access_token\":\"", "");
			String tokenResponse = token;
			int startIndex = tokenResponse.indexOf("token\":") + 1;
			int endIndex = tokenResponse.indexOf(",\"token_type\"") - 1;
			String token1 = tokenResponse.substring(startIndex, endIndex);
			return token1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	public static double getFeeShip(int height, int lenght, int with, int weght, int from_district_id, int from_ward_id, String tenHuyen, String tenXa) {
		String apiUrl = "http://140.238.54.136/api/calculateFee";
		String authToken = token();
		double result = 0.0;
		try {
			int districtId_to = DistrictGHNUtils.getDistrictId(tenHuyen);
			int ward_id_to = DistrictGHNUtils.getDistrictIdOfWard(tenXa, districtId_to);
			Map<String, String> params = new HashMap<>();
			params.put("height", String.valueOf(height));
			params.put("length", String.valueOf(lenght));
			params.put("width", String.valueOf(with));
			params.put("weight", String.valueOf(weght));
			params.put("from_district_id", from_district_id + "");
			params.put("from_ward_id", from_ward_id + "");
			params.put("to_district_id", districtId_to + "");
			params.put("to_ward_id", ward_id_to + "");
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, String> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(param.getValue(), "UTF-8"));
			}
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + authToken);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Content-Length", Integer.toString(postData.toString().getBytes().length));
			con.setDoOutput(true);
			con.getOutputStream().write(postData.toString().getBytes(StandardCharsets.UTF_8));
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Parse the JSON response to get the cost and time
			JSONObject jsonObject = new JSONObject(response.toString());
			JSONArray dataArray = jsonObject.getJSONArray("data");
			JSONObject dataObject = dataArray.getJSONObject(0);
			double cost = dataObject.getDouble("service_fee");


			result = cost;
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;

	}

	public static String getDateShip(int height, int lenght, int with, int weght, int from_district_id, int from_ward_id, String tenHuyen, String tenXa) {
		String apiUrl = "http://140.238.54.136/api/leadTime";
		String authToken = token();
		String result = "";
		try {
			int districtId_to = DistrictGHNUtils.getDistrictId(tenHuyen);
			int ward_id_to = DistrictGHNUtils.getDistrictIdOfWard(tenXa, districtId_to);
			Map<String, String> params = new HashMap<>();
			params.put("height", height + "");
			params.put("length", lenght + "");
			params.put("width", with + "");
			params.put("weight", weght + "");
			params.put("from_district_id", from_district_id + "");
			params.put("from_ward_id", from_ward_id + "");
			params.put("to_district_id", districtId_to + "");
			params.put("to_ward_id", ward_id_to + "");
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, String> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(param.getValue(), "UTF-8"));
			}
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Bearer " + authToken);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setRequestProperty("Content-Length", Integer.toString(postData.toString().getBytes().length));
			con.setDoOutput(true);
			con.getOutputStream().write(postData.toString().getBytes(StandardCharsets.UTF_8));
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
			JSONObject jsonObject = new JSONObject(response.toString());
			JSONArray dataArray = jsonObject.getJSONArray("data");
			JSONObject dataObject = dataArray.getJSONObject(0);

			int time = dataObject.getInt("timestamp");
			Date dateTime = new Date(time * 1000L); // Convert seconds to milliseconds
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Format the date
			String formattedDate = dateFormat.format(dateTime); // Format the date as a string
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateTime);
			calendar.add(Calendar.DATE, 3); // Add 3 days
			Date newdateTime = (Date) calendar.getTime();
			SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd"); // Format the date
			String newFormattedDate = newDateFormat.format(newdateTime); // Format the date as a string
			result = (formattedDate + " - " + newFormattedDate);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static String getID(String id) {
		String apiUrl = "http://140.238.54.136/api/allTransports ";
		String authToken = token();
		try {

			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "Bearer " + authToken);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			return response.toString();


		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public static String getTrangThaiDonhang(String id) {
		String apiUrl = "http://140.238.54.136/api/auth/getInfoTransport";
		String authToken = token();
		String orderId = id;

		try {
			// Tạo URI với query parameters
			URIBuilder builder = new URIBuilder(apiUrl);
			builder.setParameter("id", orderId);
			URI uri = builder.build();

			// Tạo yêu cầu HTTP POST
			HttpPost httpPost = new HttpPost(uri);
			httpPost.setHeader("Authorization", "Bearer " + authToken);

			// Gửi yêu cầu và nhận phản hồi
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpResponse response = httpClient.execute(httpPost);

			// Xử lý phản hồi
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String responseBody = EntityUtils.toString(entity);
				System.out.println(responseBody);
				// Thực hiện xử lý dữ liệu phản hồi theo yêu cầu của bạn
			}

			// Đóng HttpClient khi không sử dụng nữa
			httpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}