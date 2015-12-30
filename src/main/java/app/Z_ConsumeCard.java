package app;

import service.CouponService;
import vo.Token;
import config.Config;

public class Z_ConsumeCard {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		System.out.println(token.getExpires_in());
		String result = CouponService.consumeCard(token, "C716EDFF593A3", "pmKOyjtx3Qt2Fhy2w1sCuOF1qHFM");
		System.out.println(result);
	}
}
