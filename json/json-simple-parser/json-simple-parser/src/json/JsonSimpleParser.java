package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import exception.ElementsNotFoundException;

public class JsonSimpleParser {
	
	public Long _findLong(JSONObject jsonData, String elements, int depth){
		
		Long result=null;
		result = (Long)findElements(jsonData, elements, depth, 1);
		if(result==null) {
			System.out.println("데이터가 없습니다.");
		}
		return result;
		
	}
	
	public String _findString(JSONObject jsonData, String elements, int depth) throws ElementsNotFoundException{
		
		String result=null;
		result = (String)findElements(jsonData, elements, depth, 1);
		if(result==null) {
			throw new ElementsNotFoundException();
		}
		return result;
		
	}
	
	public JSONObject _findJSONObject(JSONObject jsonData, String elements, int depth) throws ElementsNotFoundException{
		
		JSONObject result=null;
		result = (JSONObject)findElements(jsonData, elements, depth, 1);
		if(result==null) {
			throw new ElementsNotFoundException();
		}
		return result;
		
	}
	
	public JSONArray _findJSONArray(JSONObject jsonData, String elements, int depth) throws ElementsNotFoundException{
		
		JSONArray result=null;
		result = (JSONArray)findElements(jsonData, elements, depth, 1);
		if(result==null) {
			throw new ElementsNotFoundException();
		}
		return result;
		
	}
	
	public Object findElements( Object json, String elements, int depth, int roopCount ) {

		Object result=null;
		JSONArray	ja = null;
		JSONObject	jo = null;
		
		if(roopCount>depth) {
			return null;
			
		}else if(roopCount==depth) {
				JSONObject jsonObject;
				Object resultObject;
			try {
				jsonObject = (JSONObject) json;
			}catch(ClassCastException e){
				return null;
			}
			resultObject= (Object)jsonObject.get(elements);
			return resultObject;
			
		}else {
			try {
				jo=(JSONObject)json;
			}catch(ClassCastException e1) {
				try {
					ja=(JSONArray)json;
				}catch(ClassCastException e2) {
					return null;
				}
			}
			if(jo!=null) {
				
				Iterator<?> it = jo.keySet().iterator();
				
				while(it.hasNext()) {
					String key = (String) it.next();
					Object loopResult = null;
					loopResult = findElements(jo.get(key), elements, depth, roopCount+1);
					if(loopResult!=null) {
						result=loopResult;
						break;
					}
				}
				return result;
				
			}else{
				//jsonArray
				return null;
			}
		}
		
	}	
	
	
	public static void main(String[] args) throws ElementsNotFoundException {
	
		
//		Exception
//		[{
//			"aa": "bb"
//		}, {
//			"cc": "bb"
//		}]
		
		JsonSimpleParser t= new JsonSimpleParser();
		
		String aa=	"{\"timezone\": \"SEOUL\",\"activity\": "
				+ "											{\"stopTime\": \"200\","
				+ "																	\"detail\":";
			aa=aa+  "																			["
					+ "																				{\"startTime\": \"200\","
					+ "																			  	\"stopTime\": \"200\","
					+ "																				\"stepCnt\": \"200\","
					+ "																				\"distance\": \"200\","
					+ "																				\"mode\": \"Non-move\"}"
					+ "																				,";
			aa=aa+  "																				{\"startTime\": \"200\","
					+ "																				\"stopTime\": \"200\","
					+ "																				\"stepCnt\": \"200\","
					+ "																				\"distance\": \"200\","
					+ "																				\"mode\": \"Walking\"}"
					+ "																			]";
			aa=aa+  "											,\"statTime\": 200,";
			aa=aa+  "											\"calorie\": \"200\"}"
					+ "											}";
			
			JSONParser jp = new JSONParser();
			JSONObject bb=null;
			try {
				bb=(JSONObject) jp.parse(aa);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		JSONObject jo1 = new JSONObject();
		JSONObject jo2 = new JSONObject();
		JSONObject jo3 = new JSONObject();
		JSONObject jo4 = new JSONObject();
		JSONArray  ja	= new JSONArray();
		
		jo4.put("deep4", "deep4");
		jo4.put("deep5", "deep5");
		jo4.put("deep6", "deep6");
		
		jo3.put("deep1", 1);
		jo3.put("deep2", "deep2");
		jo3.put("deep3", "deep3");
		
		ja.add(jo3);
		ja.add(jo3);
		ja.add(jo3);
		
		jo2.put("test1", "test1");
		jo2.put("test2", ja);
		jo2.put("test3", jo4);
		
		jo1.put("root1", jo2);
		jo1.put("root2", "test4");

		System.out.println( t._findJSONArray(bb, "detail", 2));
		System.out.println( t._findString(bb, "stopTime", 2).equals("200"));
		System.out.println( t._findLong(bb, "statTime", 2));
	}
}