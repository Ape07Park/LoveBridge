package com.example.LoveBridge.util;

import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
// 별도로 파일을 빼냄, 여기 위치에 있는 파일을 불러오겠다 
@PropertySource("classpath:static/data/myKeys.properties")
public class AsideUtil {
	@Value("${roadAddrKey}")
	private String roadAddrKey;
	@Value("${kakaoApiKey}")
	private String kakaoApiKey;
	
	public String getTodayQuote(String filename) {
		String result = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename), 1024);
			int index = (int) Math.floor(Math.random() * 100); // 0 ~ 99
			for (int i = 0; i <= index; i++) { // index = 10
				result = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 행안부 도로명주소
	 */
	public String getRoadAddr(String keyword) {

		String roadAddr = null;

		try {
			keyword = URLEncoder.encode(keyword, "utf-8");
			String apiUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do" + "?confmKey=" + roadAddrKey + "&keyword="
					+ keyword + "&currentPage=1&countPerPage=5&resultType=json";
			System.out.println(apiUrl);

			URL url = new URL(apiUrl);

			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String line = null, result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}

			br.close();

			/*
			 * 응답결과 JSON 저장
			 */
			// JSON 데이터에서 원하는 값 추출하기
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(result.toString());
			JSONObject results = (JSONObject) object.get("results");
			JSONArray juso = (JSONArray) results.get("juso");
			JSONObject jusoItem = (JSONObject) juso.get(0);
//	    	System.out.println(jusoItem.keySet()); 
			roadAddr = (String) jusoItem.get("roadAddr");
			System.out.println(roadAddr);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roadAddr;
	}

	/*
	 * 카카오
	 */
	public Map<String, String> getGeocode(String addr) {
		Map<String, String> map = new HashMap<>();
		try {
			String query = URLEncoder.encode(addr, "utf-8");
			String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json" + "?query=" + query;
			
			System.out.println("apiUrl");
			System.out.println(apiUrl);
			
			URL url = new URL(apiUrl);

			// Header setting
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "KakaoAK " + kakaoApiKey);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line = null, result = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			
			System.out.println("result");
			System.out.println(result);
			br.close();
			
			// JSON 데이터에서 원하는 값 추출하기
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(result);
			JSONArray documents = (JSONArray) object.get("documents");
			JSONObject item = (JSONObject) documents.get(0);
			String lon = (String) item.get("x");
			String lat = (String) item.get("y");

			System.out.println(lon + ", " + lat);

			map.put("lon", lon);
			map.put("lat", lat);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	
	

}
