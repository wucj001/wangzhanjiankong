package testjk;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
  
/**  
 * 自定义文件监听器  
 * @author    
 * @date    2010-11-16  
 * @file    org.demo.file.MyFileListener.java  
 */  
public class MyFileListener extends FileAlterationListenerAdaptor{   
	private String path;
	private Add_log log=new Add_log();
	private DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override  
    public void onFileCreate(File file) {   
       // System.out.println("[新建]:" + file.getAbsolutePath()+"  操作时间 :"+df1.format(new Date()));   
        log.setPath(getPath());
        if(GetFileType.wjpd(file.getAbsolutePath())){
        	SendMail.email("文件上传告警", "发现告警文件路径为:"+file.getAbsolutePath()+"		时间:"+df1.format(new Date()));
        }
        log.method1("New:	" + file.getAbsolutePath()+"  New_time :"+df1.format(new Date()));
    } 
    @Override  
    public void onFileChange(File file) {   
      //  System.out.println("[修改]:" + file.getAbsolutePath()+"  操作时间 :"+df1.format(new Date()));   
        log.setPath(getPath());
        if(GetFileType.wjpd(file.getAbsolutePath())){
        	SendMail.email("文件修改告警", "发现告警文件路径为:"+file.getAbsolutePath()+"		时间:"+df1.format(new Date()));
        }
        log.method1("modify:	" + file.getAbsolutePath()+"  modify_time :"+df1.format(new Date()));
    }   
    @Override  
    public void onFileDelete(File file) {   
     //   System.out.println("[删除]:" + file.getAbsolutePath()+"  操作时间 :"+df1.format(new Date()));   
        log.setPath(getPath());
        log.method1("delete:	" + file.getAbsolutePath()+"  delete_time :"+df1.format(new Date()));
    }   
}

