package app;

import config.Config;

public class GetAccessToken {
	
	public static void main(String[] args) {
		System.out.println("AccessToken: "+Config.getAccessToken().getAccess_token());
	}
}
