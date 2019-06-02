package testjk;



import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class GetFileType {
   // private static List<String> accTypes = Arrays.asList("jsp","jspx","asp","aspx","exe","ashx","php");
    public static boolean wjpd(String filename){
    	String type=getFileType(filename);
    	String jg[]=duqu();
    	boolean flag=false;
    	for(int i=0;i<jg.length;i++){
            if(jg[i].equalsIgnoreCase(type)){
                System.out.println(filename+"后缀不合法");
                //System.out.println(type);
                flag=true;
            }/*else{
                System.out.println(filename+"后缀合法");
               // System.out.println(type);
                return false;
            }*/
    	}
		return flag;
    }
    public static String[] duqu(){
    	Properties properties = new Properties();
    	List<String> list=new ArrayList<String>();
    	String houzui=null;
    	try {
			InputStream in = Object.class.getClass().getResourceAsStream("/houzui.properties");
		    properties.load(in);
		    houzui= properties.getProperty("houzui");
		    in.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return houzui.split(",");
    }
    /**
     * 获取文件后缀名
     * @param filename
     * @return
     */
    public static String getFileType(String filename){
        int pos = filename.lastIndexOf(".");
        if(pos == -1){
            return null;
        }
        return filename.substring(pos+1);
    }
    public static void main(String args[]){
    	wjpd("C://wdjsahdw/wdjasdha/nsad.jsP");
    }
}