package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class FileUtil {
	public static List<String> readCodeByCSV(String filePath) {
		if (StringUtils.isBlank(filePath))
			return null;
		File file = new File(filePath);
		if (!file.exists())
			return null;
		List<String> codelist = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			// 读取直到最后一行
			String line = "";
			while ((line = br.readLine()) != null) {
				// 把一行数据分割成多个字段
				StringTokenizer st = new StringTokenizer(line, ",");
				String code = st.nextToken();
				codelist.add(code);
			}
			br.close();

		} catch (FileNotFoundException e) {
			// 捕获File对象生成时的异常
			e.printStackTrace();
		} catch (IOException e) {
			// 捕获BufferedReader对象关闭时的异常
			e.printStackTrace();
		}

		return codelist;
	}

	public static String loadFile(String filePath) {
		if (StringUtils.isBlank(filePath))
			return null;
		File file = new File(filePath);
		if (!file.exists())
			return null;

		StringBuilder str = new StringBuilder();
		Reader reader = null;
		try {
			// 一次读一个字符
			reader = new InputStreamReader(new FileInputStream(file));
			int tempchar;
			while ((tempchar = reader.read()) != -1) {
				// 对于windows下，\r\n这两个字符在一起时，表示一个换行。
				// 但如果这两个字符分开显示时，会换两次行。
				// 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
				char c = (char) tempchar;
				if (c != '\r' && c != '\n' && c != '\t' && c != ' ') {
					str.append((char) tempchar);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str.toString();
	}
	
	/**
     * 获取当前Jar所在目录
     * 未打包前路径 示例：/E:/Conan/Workspace/ExcelConverter-cleanup/bin
     * 打包后路径   示例：E:/Conan/Workspace/ExcelConverter-cleanup/
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String getCurrentLocalPath(Class clazz){
        URL s = clazz.getProtectionDomain().getCodeSource().getLocation();
        String path = s.getPath();
        try {
            path = URLDecoder.decode(path,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String cp = path.substring(0, path.lastIndexOf("/"));
        return cp;
    }

}
