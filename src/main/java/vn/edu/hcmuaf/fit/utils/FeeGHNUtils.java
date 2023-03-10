package vn.edu.hcmuaf.fit.utils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import vn.edu.hcmuaf.fit.constant.GHNContent;

public class FeeGHNUtils {
	public static int getFeeGHN(String name) throws IOException {

		int to_district_id = DistrictGHNUtils.getDistrictId(name);
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://online-gateway.ghn.vn/shiip/public-api/v2/shipping-order/fee");
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.addHeader("Token", GHNContent.GHN_CLIENT_ID);

		String requestBody = "{\"service_type_id\": 2," + "\"from_district_id\": 3695," + "\"to_district_id\":"+ to_district_id+","
				+ "\"to_ward_code\": \"21012\"," + "\"weight\": 1000," + "\"length\": 20," + "\"width\": 10,"
				+ "\"height\": 5," + "\"insurance_value\": 10000}";

		StringEntity entity = new StringEntity(requestBody);
		httpPost.setEntity(entity);

		HttpResponse response = httpClient.execute(httpPost);
		String responseJson = EntityUtils.toString(response.getEntity());
		String jsonString = responseJson;
		JSONObject jsonObject = new JSONObject(jsonString);
		int totalFee = jsonObject.getJSONObject("data").getInt("total");
		return totalFee;
	}
	
}