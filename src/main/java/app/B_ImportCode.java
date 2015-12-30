package app;

import java.util.List;

import service.CouponService;
import utils.FileUtil;
import vo.Token;
import config.Config;

public class B_ImportCode {
	public static Token token = Config.getAccessToken();
	
	public static void main(String[] args) {
		
		List<String> codelist = FileUtil.readCodeByCSV("C:/Users/H030500245/Desktop/couponjson/code2.csv");
		codelist.remove(0);
		String result = CouponService.importCode(A_CurrentID.ID, codelist, token);
		System.out.println(result);
		
		
		
		/*String json = FileUtil.loadFile("C:/Users/H030500245/Desktop/couponjson/import-code.txt");
		String result = CouponService.importCode(json, token);
		System.out.println(result);*/
	}
	
}
