package app;

import service.CouponService;
import vo.Token;
import config.Config;

public class E_GetCouponUrl {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String result = CouponService.getCouponUrl(A_CurrentID.ID, token);
		System.out.println(result);
	}
	
}
