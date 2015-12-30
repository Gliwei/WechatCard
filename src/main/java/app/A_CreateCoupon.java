package app;

import service.CouponService;
import utils.FileUtil;
import vo.Token;
import config.Config;

public class A_CreateCoupon {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String json = FileUtil.loadFile("C:/Users/H030500245/Desktop/couponjson/coupon2.txt");
		
		String result = CouponService.createCoupon(json, token);
		System.out.println(result);
	}
	
}
