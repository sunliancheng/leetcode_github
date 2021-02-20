package LeetCodeUtils.Calculater;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Http {

    public static JSONObject getHttpResponseJson(String url, Map<String,String> param){
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        JSONObject jsonObject = null;

        try {
            //请求发起客户端
            httpclient = HttpClients.createDefault();
            //参数集合
            List postParams = new ArrayList();
            //遍历参数并添加到集合
            for(Map.Entry<String, String> entry:param.entrySet()){
                postParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            //通过post方式访问
            //HttpPost post = new HttpPost(url);
            //HttpEntity paramEntity = new UrlEncodedFormEntity(postParams,"UTF-8");
            //post.setEntity(paramEntity);
            HttpGet get = new HttpGet(url);
            response = httpclient.execute(get);
            HttpEntity valueEntity = response.getEntity();
            String content = EntityUtils.toString(valueEntity);
            jsonObject = JSONObject.parseObject(content);

            return jsonObject;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(httpclient != null){
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonObject;
    }

}
