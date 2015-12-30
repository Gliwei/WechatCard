package app;

import service.CouponService;
import vo.Token;
import config.Config;

public class DeleteCoupon {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String result2 = CouponService.deleteCoupon("pmKOyjqYtnPulqUIS1etZfi3vLQg", token);
		System.out.println(result2);
		
	}
	
}