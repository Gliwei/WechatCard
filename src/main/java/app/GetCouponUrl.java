package app;

import service.CouponService;
import utils.FileUtil;
import vo.Token;
import config.Config;

public class GetCouponUrl {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String json = FileUtil.loadFile("C:/Users/H030500245/Desktop/couponjson/get-coupon-url.txt");
		System.out.println(json);
		
		String result = CouponService.getCouponUrl(json, token);
		System.out.println(result);
	}
	
}
