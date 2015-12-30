package config;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import utils.HttpUtil;
import vo.Token;

public class Config {
	public static final String APP_ID = "wx0f186d92b18bc5b0";
	public static final String APP_SECRET = "f5852840f23e3ae21d436f899bebc898";
	
	public static final String APP_ID_TEST = "wxc78ed6dbcb40e961";
	public static final String APP_SECRET_TEST = "d4624c36b6795d1d99dcf0547af5443d";
	
	/**
	 * 获取二维码/链接
	 */
	public static final String GET_COUPON_URL = "https://api.weixin.qq.com/card/qrcode/create";
	
	/**
	 * 查询卡券信息
	 */
	public static final String GET_CARD_INFO = "https://api.weixin.qq.com/card/get";
	
	/**
	 * 上传图片
	 */
	public static final String UPLOAD_IMAGE = "";
	
	/**
	 * 创建卡券API URL
	 */
	public static final String CREATE_CPOPON_URL = "https://api.weixin.qq.com/card/create";
	
	/**
	 * 导入自定义Code
	 */
	public static final String IMPORT_CODE_URL = "https://api.weixin.qq.com/card/code/deposit";
	
	/**
	 * 导入自定义,单次最大可导入数量
	 */
	public static final int IMPORT_CODE_MAX = 100;
	
	/**
	 * 查询导入的Code
	 */
	public static final String SEARCH_IMPORT_CODE_NUM = "https://api.weixin.qq.com/card/code/getdepositcount";
	
	/**
	 * 修改库存接口
	 */
	public static final String MODIFY_STOCK = "https://api.weixin.qq.com/card/modifystock";
	
	/**
	 * 删除卡券
	 */
	public static final String DELETE_COUPON = "https://api.weixin.qq.com/card/delete";
	
	/**
	 * 卡券货架接口
	 */
	public static final String COUPON_PAGE = "https://api.weixin.qq.com/card/landingpage/create";
	
	/**
	 * 获取AccessToken
	 */
	public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	
	public static final String CODE_CSVFILE_LOCALPATH = "";
	
	public static final String ACCESS_TOKEN_FIELD_NAME = "access_token";
	
	/**
	 * 核销卡券
	 */
	public static final String CONSUME_CARD = "https://api.weixin.qq.com/card/code/consume";
	
	/**
	 * 创建菜单
	 */
	public static final String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create";
	
	/**
	 * 获取AccessToken
	 * @return
	 */
	public static Token getAccessToken(){
		Map<String, String> param = new HashMap<String, String>();
		param.put("grant_type", "client_credential");
		param.put("appid", APP_ID);
		param.put("secret", APP_SECRET);
		
		String tokenJson = HttpUtil.post(GET_ACCESS_TOKEN_URL, param);
		
		Gson gson = new Gson();
		Token token = gson.fromJson(tokenJson, Token.class);
		return token;
	}
	
	public static Token getTestAccessToken(){
		Map<String, String> param = new HashMap<String, String>();
		param.put("grant_type", "client_credential");
		param.put("appid", APP_ID_TEST);
		param.put("secret", APP_SECRET_TEST);
		
		String tokenJson = HttpUtil.post(GET_ACCESS_TOKEN_URL, param);
		
		Gson gson = new Gson();
		Token token = gson.fromJson(tokenJson, Token.class);
		return token;
	}
	
	/**
	 * 拼接AccessToken到URL参数中
	 * @param url
	 * @param token
	 * @return
	 */
	public static String join(String url, Token token){
		return url +"?"+Config.ACCESS_TOKEN_FIELD_NAME+"="+token.getAccess_token();
	}
}
