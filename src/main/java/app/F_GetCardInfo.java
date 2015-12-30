package app;

import service.CouponService;
import vo.Token;
import config.Config;

public class F_GetCardInfo {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String result2 = CouponService.getCardInfo(A_CurrentID.ID, token);
		System.out.println(result2);
		
	}
	
}