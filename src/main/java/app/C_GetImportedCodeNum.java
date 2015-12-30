package app;

import service.CouponService;
import vo.Token;
import config.Config;

public class C_GetImportedCodeNum {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		String result2 = CouponService.searchImportCodeNum(A_CurrentID.ID, token);
		System.out.println(result2);
		
	}
	
}