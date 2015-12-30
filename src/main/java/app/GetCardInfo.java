package app;

import service.CouponService;
import vo.Token;
import config.Config;

public class GetCardInfo {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String result2 = CouponService.getCardInfo("pmKOyjvzLahpd47Q7soJ_Uh6XCiI", token);
		System.out.println(result2);
		
	}
	
}