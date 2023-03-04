package vn.edu.hcmuaf.fit.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import vn.edu.hcmuaf.fit.constant.GoogleConstant;
import vn.edu.hcmuaf.fit.model.GoogleModel;

import java.io.IOException;
public class GoogleUtil {
  public static String getToken(final String code) throws ClientProtocolException, IOException {
    String response = Request.Post(GoogleConstant.GOOGLE_LINK_GET_TOKEN)
        .bodyForm(Form.form().add("client_id", GoogleConstant.GOOGLE_CLIENT_ID)
            .add("client_secret", GoogleConstant.GOOGLE_CLIENT_SECRET)
            .add("redirect_uri", GoogleConstant.GOOGLE_REDIRECT_URI).add("code", code)
            .add("grant_type", GoogleConstant.GOOGLE_GRANT_TYPE).build())
        .execute().returnContent().asString();
      JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
      String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
      return accessToken;
  }
  public static GoogleModel getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
    String link = GoogleConstant.GOOGLE_LINK_GET_USER_INFO + accessToken;
    String response = Request.Get(link).execute().returnContent().asString();
    GoogleModel googlePojo = new Gson().fromJson(response, GoogleModel.class);
    System.out.println(googlePojo);
    return googlePojo;
  }
}
