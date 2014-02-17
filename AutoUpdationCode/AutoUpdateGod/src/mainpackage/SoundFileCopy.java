package mainpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SoundFileCopy {

public static void main(String[] args) {
	SoundFileCopy file=new SoundFileCopy();
	file.copySoundFile(100);	
  
}
public void copySoundFile(int id)
{
	 try {
	        File srcFile = new File(Paths.srcFile+id+".mp3");//"D:/Android yog/PradeepGodWorkSPace/Sounds/841.mp3");
	        File dstFile = new  File(Paths.dstFile);//"D:/Android yog/PradeepGodWorkSPace/Sounds/FileCreationGod_Automationcode/SIREN.mp3");//destination path
	        File  dstFile1 = new  File(Paths.dstFile1);//"D:/Android yog/PradeepGodWorkSPace/Sounds/FileCreationGod_Automationcode/SIREN1.mp3");//destination path
	        
	        
	        FileInputStream in = new FileInputStream(srcFile);
	        FileOutputStream out = new FileOutputStream(dstFile);
	        FileOutputStream out1 = new FileOutputStream(dstFile1);

	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0) {
	            out.write(buf, 0, len);
	            out1.write(buf, 0, len);
	        }

	        in.close();
	        out.close();
	        out1.close();

	    } catch (Exception e) {
	        System.out.println(e);
	    }
}
}