package abc;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
 
public class MultipleFile {
 
    public void zipFiles(String... filePaths) {
        try {
            File firstFile = new File(filePaths[0]);
            String zipFileName = firstFile.getName().concat(".zip");
 
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
 
            for (String aFile : filePaths) {
                zos.putNextEntry(new ZipEntry(new File(aFile).getName()));
 
                byte[] bytes = Files.readAllBytes(Paths.get(aFile));
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
            }
 
            zos.close();
 
        } catch (Exception ex) {
            System.err.println("A file does not exist: " + ex);
        }
    }
 
    // public static void main(String[] args) {
    //     zipFiles(args);
    // }
}