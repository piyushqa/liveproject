//package utilities;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import javax.json.Json;
//import javax.json.JsonObject;
//
////import com.google.gson.JsonObject;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
//
//
//public class JiraIntegration {
//	
//	public void jiraSendRequest() {
//        try {
//            //URL url = new URL("https://xxxxxx:xxxxx@jira.pl/rest/api/2/issue/");
//        	URL url = new URL("https://eyecareleaders.atlassian.net/rest/api/3/issue/");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//
//            String encodedData = getJSON_Body();
//            System.out.println(encodedData);
//
//            System.out.println(getJSON_Body());
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("LxNwl6nifiBts92rkczl3641", "Basic " + Base64.encode(url.getUserInfo().getBytes()));
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.getOutputStream().write(encodedData.getBytes());
//
//            try {
//                InputStream inputStream = conn.getInputStream();
//                System.out.println(inputStream);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String getJSON_Body() {
//        JsonObject createIssue = Json.createObjectBuilder()
//                .add("fields",
//                        Json.createObjectBuilder().add("project",
//                                Json.createObjectBuilder().add("key", "xxxx"))
//                                .add("summary", "Test issue")
//                                .add("description", "Test Issue")
//                                .add("issuetype",
//                                        Json.createObjectBuilder().add("name", "Bug"))
//                ).build();
//
//        return createIssue.toString();
//    }
//}
//
//
