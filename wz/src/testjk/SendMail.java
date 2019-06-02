package testjk;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.mail.EmailException;   
import org.apache.commons.mail.SimpleEmail;  
	  
	public class SendMail {   
	    public static void email(String title,String content) {
	    	Properties properties = new Properties();
	        SimpleEmail email = new SimpleEmail();   
	        String user=null;
	        String pass=null;
	        String smtp=null;
	        String recei_email=null;
	    	try {
				InputStream in = Object.class.getClass().getResourceAsStream("/mail.properties");
			    properties.load(in);
			    smtp =properties.getProperty("email_stmp");
			    user =properties.getProperty("email_user");
			    pass =properties.getProperty("email_pass");
			    recei_email= properties.getProperty("recei_email");
			    in.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    		email.setTLS(true);       
		        email.setHostName(smtp);   
		        email.setAuthentication(user, pass); // 用户名和密码   
	        try {   
	            email.addTo(recei_email); // 接收方   
	            email.setFrom(user); // 发送方   
	            email.setSubject(title); // 标题   
	            email.setCharset("utf-8");   
	            email.setMsg(content); // 内容   
	            email.send();   
	            System.out.println("发送邮件"+title+"到"+recei_email);
	        } catch (EmailException e) {   
	           System.out.println("未配置邮件"); 
	        }   
	    }  
	    public static void main(String args[]){
	    	email("hello", "test");
	    }
	}  