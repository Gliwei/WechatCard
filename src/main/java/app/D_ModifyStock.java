package app;

import service.CouponService;
import vo.Token;
import config.Config;

public class D_ModifyStock {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String result2 = CouponService.modifyStock(A_CurrentID.ID, 50, token);
		System.out.println(result2);
		
	}
	
}