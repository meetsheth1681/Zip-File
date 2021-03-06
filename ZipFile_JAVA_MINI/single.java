package abc;
import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class single {
 
    public void zipFile(String filePath) {
        try {
            File file = new File(filePath);
            String zipFileName = file.getName().concat(".zip");
 
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
 
            zos.putNextEntry(new ZipEntry(file.getName()));
 
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();
 
        } catch (Exception ex) {
            System.err.format("The file %s does not exist", filePath);
        } 
    }
 
    // public static void main(String[] args) {
    //     String filePath = args[0];
    //     zipFile(filePath);
    //}
}