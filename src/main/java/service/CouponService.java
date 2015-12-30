package service;

import java.io.File;
import java.util.List;

import utils.HttpUtil;
import utils.PropertiesUtil;
import vo.Token;
import config.Config;

public class CouponService {
	
	public static String createCoupon(String json, Token token){
		String URL = Config.join(Config.CREATE_CPOPON_URL, token);
		return HttpUtil.post(URL, json);
	}
	
	public static String importCode(String json,Token token){
		String URL = Config.join(Config.IMPORT_CODE_URL, token);
		return HttpUtil.post(URL, json);
	}
	
	public static String importCode(String cardId, List<String> codelist,Token token){
		String URL = Config.join(Config.IMPORT_CODE_URL, token);
		int count = codelist.size() / Config.IMPORT_CODE_MAX;
		for(int i=0; i<count; i++){
			int fromIndex = i*Config.IMPORT_CODE_MAX;
			int toIndex = fromIndex+Config.IMPORT_CODE_MAX;
			List<String> list = codelist.subList(fromIndex, toIndex);
			System.out.println("Size:"+list.size()+" | FromIndex:"+fromIndex + " | ToIndex:"+toIndex);
			String json = getImportCodeJson(cardId, list);
			System.out.println(json);
			String result = HttpUtil.post(URL, json);
			System.out.println(result+"\n------------------------------------");
		}
		
		if((codelist.size() % Config.IMPORT_CODE_MAX) >= 0){
			int fromIndex = count*Config.IMPORT_CODE_MAX;
			int toIndex = codelist.size();
			List<String> list = codelist.subList(fromIndex, toIndex);
			System.out.println("--Last---------------------------------");
			System.out.println("Size:"+list.size()+" | FromIndex:"+fromIndex + " | ToIndex:"+toIndex);
			String json = getImportCodeJson(cardId, list);
			System.out.println(json);
			String result = HttpUtil.post(URL, json);
			System.out.println(result);
		}
		
		return "";
	}
	
	private static String getImportCodeJson(String cardId, List<String> codelist){
		String json = "{"+
				   "\"card_id\": \""+cardId+"\","+
				   "\"code\": [";
		for(String code:codelist){
			json += "\""+code+"\",";
		}
		json = json.substring(0, json.lastIndexOf(","));
		json += "]"+"}";
		
		return json;
	}
	
	public static String searchImportCodeNum(String json,Token token){
		String URL = Config.join(Config.SEARCH_IMPORT_CODE_NUM, token);
		return HttpUtil.post(URL, json);
	}
	
	public static String modifyStock(String json, Token token){
		String URL = Config.join(Config.MODIFY_STOCK, token);
		return HttpUtil.post(URL, json);
	}
	
	public static String createCouponPage(String json, Token token){
		String URL = Config.join(Config.COUPON_PAGE, token);
		return HttpUtil.post(URL, json);
	}
	
	public static String deleteCoupon(String id, Token token){
		String json = "{"+ "\"card_id\": \""+id+"\""+"}";
		System.out.println(json);
		String URL = Config.join(Config.MODIFY_STOCK, token);
		return HttpUtil.post(URL, json);
	}
	
	public static String getCardInfo(String id, Token token){
		String json = "{"+ "\"card_id\": \""+id+"\""+"}";
		System.out.println(json);
		String URL = Config.join(Config.GET_CARD_INFO, token);
		return HttpUtil.post(URL, json);
	}
	
	public static String getCouponUrl(String json, Token token){
		String URL = Config.join(Config.GET_COUPON_URL, token);
		return HttpUtil.post(URL, json);
	}
	
	public static String consumeCard(Token token, String code, String cardId){
		String URL = Config.join(Config.CONSUME_CARD, token);
		String json = "{"+
						  "\"code\": \""+ code +"\","+
						  "\"card_id\": \""+ cardId +"\""+
					  "}";
		return HttpUtil.post(URL, json);
	}
	
	public static String createMenu(String json, Token token){
		String URL = Config.join(Config.CREATE_MENU, token);
		return HttpUtil.post(URL, json);
	}
}
