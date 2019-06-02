package testjk;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;


public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
      /*     // 监控目录   
        System.out.println("请输入监控路径:");
        Scanner sca=new Scanner(System.in);
        String path= sca.next();
        System.out.println("请输入监控日志存放");
        String log_path= sca.next();*/
        // 轮询间隔 5 毫秒   
    	Properties properties = new Properties();
    	  String jkpath = null;
    	  String logpath = null;
		try {
			InputStream in = Object.class.getClass().getResourceAsStream("/config.properties");
			//in = new FileInputStream("testjk/config.properties");
		    properties.load(in);
		    jkpath =properties.getProperty("jkpath");
		    logpath =properties.getProperty("logpath");
		    in.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        long interval = 5l;
        FileAlterationObserver observer = new FileAlterationObserver(jkpath,null,null); 
        MyFileListener myFileListener =new MyFileListener();
        myFileListener.setPath(logpath);
        observer.addListener(myFileListener);   
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval,observer);   
        // 开始监控   
        System.out.println("开始监控");
        monitor.start();  
    }
}