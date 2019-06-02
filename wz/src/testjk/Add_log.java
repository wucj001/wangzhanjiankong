package testjk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Add_log {
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void method1(String name) {
		FileWriter fw = null;
		try {
		//如果文件存在，则追加内容；如果文件不存在，则创建文件
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		File f=new File(path+"/"+df.format(new Date())+".log");
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(name);
		pw.flush();
		try {
		fw.flush();
		pw.close();
		fw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
	/*public static void main(String args[]){
		Add_log add=new Add_log();
		add.method1("D://1.txt","HElllllll");
	}*/
}
