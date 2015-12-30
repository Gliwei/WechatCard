package app;

import service.CouponService;
import utils.FileUtil;
import vo.Token;
import config.Config;

public class ModifyStock {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String searchjson = FileUtil.loadFile("C:/Users/H030500245/Desktop/couponjson/modify-stock.txt");
		System.out.println(searchjson);
		String result2 = CouponService.modifyStock(searchjson, token);
		System.out.println(result2);
		
	}
	
}