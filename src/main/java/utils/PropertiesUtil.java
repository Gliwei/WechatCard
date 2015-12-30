package utils;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
 
import javax.swing.filechooser.FileSystemView;
 
public class PropertiesUtil {
     
    private File properties = null;
     
    public PropertiesUtil(File saveDir) {
        if(saveDir == null){
             
            FileSystemView fsv = FileSystemView.getFileSystemView(); 
            File myDoc = fsv.getDefaultDirectory();// 我的文档
            properties = new File(myDoc, "config.properties");
        }else if(saveDir.isDirectory()){
             
            properties = new File(saveDir, "config.properties");
        }else if(saveDir.isFile()){
             
            properties = new File(saveDir.getParentFile(), "config.properties");
        }else{
             
            FileSystemView fsv = FileSystemView.getFileSystemView(); 
            File myDoc = fsv.getDefaultDirectory();// 我的文档
            properties = new File(myDoc, "config.properties");
        }
    }
     
    /**
     * 默认在我的文档创建名为config.properties的配置文件
     */
    public PropertiesUtil() {
        FileSystemView fsv = FileSystemView.getFileSystemView(); 
        File myDoc = fsv.getDefaultDirectory();// 我的文档
        properties = new File(myDoc, "config.properties");
    }
     
    public String getConfig(String name) throws IOException{
        Properties pro = new Properties();
        if(properties == null || !properties.exists()){
            return "";
        }
        InputStream in = new FileInputStream(properties);
         
        pro.load(in);
        return pro.getProperty(name);
    }
     
    public void setConfig(Map<String, String> map) throws IOException{
        //创建
        Properties pro = new Properties();
        for(Map.Entry<String, String> entry:map.entrySet()){
            pro.setProperty(entry.getKey(), entry.getValue());
        }
         
        OutputStream fos = new FileOutputStream(properties); 
        pro.store(fos, "CONFIG "+new Date());
    }
}
