package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileManager 
{ 
	Properties pro;
   public FileManager()
   {     
	   try
	   {
		   FileInputStream fis = new FileInputStream("./configuration.properties");
		   pro = new Properties();
		   pro.load(fis);   
	   }catch(Exception e)
	   {
		   System.out.println("caught exception");
	   }
   } 
	   public String getApplicationUrl()
	   {
		  
		   String url = pro.getProperty("url");
		   if(url==null)
		   {
			   throw new RuntimeException("invalid url");
		   }
		return url;
		   }
	   public Long getImplicitlyWait()
	   {
		  String implicitwait = pro.getProperty("iw");
		  if(implicitwait==null)
		{
			throw new RuntimeException("invalid time");
		}
		  return Long.parseLong(implicitwait);
		   
	   }
}
