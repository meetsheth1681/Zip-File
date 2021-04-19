package abc;
import abc.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipOutputStream;

public class ds
{	
	public static int value = printHello();
	public static int printHello() 
	{ 
		System.out.println("If you want to Compress a Single File : Press 1");
		System.out.println("If you want to Compress Multiple Files : Press 2");
		System.out.println("If you want to Compress a Whole Directory : Press 3");
	    return 0;
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int No = sc.nextInt();
		if(No==1) 
		{
			String filePath = args[0];
			single o = new single();
	        o.zipFile(filePath);

		}
		else if(No==2) 
		{
			MultipleFile obj = new MultipleFile();
			obj.zipFiles(args);

		}
		else if(No==3) 
		{
			String dirPath = args[0];
	        Path sourceDir = Paths.get(dirPath);
	        WholeDirectory ob = new WholeDirectory(sourceDir);
	 
	        try {
	            String zipFileName = dirPath.concat(".zip");
	            ob.zos = new ZipOutputStream(new FileOutputStream(zipFileName));
	 
	            Files.walkFileTree(sourceDir, new WholeDirectory(sourceDir));
	 
	            ob.zos.close();
	        } catch (IOException ex) {
	            System.err.println("I/O Error: " + ex);
	        }
		}
	}
	
}