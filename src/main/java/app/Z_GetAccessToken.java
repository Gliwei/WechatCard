package app;

import config.Config;

public class Z_GetAccessToken {
	
	public static void main(String[] args) {
		System.out.println("AccessToken: "+Config.getAccessToken().getAccess_token());
	}
}
