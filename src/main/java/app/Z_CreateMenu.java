package app;

import service.CouponService;
import utils.FileUtil;
import vo.Token;
import config.Config;

public class Z_CreateMenu {
	public static Token token = Config.getTestAccessToken();
	
	public static void main(String[] args) {
		
		String json = FileUtil.loadFile("C:/Users/H030500245/Desktop/couponjson/menu2.txt");
		System.out.println(json);
		String result = CouponService.createMenu(json, token);
		System.out.println(result);
	}
}
