package abc;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
import java.nio.file.attribute.*;
 
public class WholeDirectory extends SimpleFileVisitor<Path> {
 
    public static ZipOutputStream zos;
 
    private Path sourceDir;
 
    public WholeDirectory(Path sourceDir) {
        this.sourceDir = sourceDir;
    }
 
    
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attributes) {
 
        try {
            Path targetFile = sourceDir.relativize(file);
 
            zos.putNextEntry(new ZipEntry(targetFile.toString()));
 
            byte[] bytes = Files.readAllBytes(file);
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
 
        } catch (IOException ex) {
            System.err.println(ex);
        }
 
        return FileVisitResult.CONTINUE;
    }
 
    // public static void main(String[] args) {
    //     String dirPath = args[0];
    //     Path sourceDir = Paths.get(dirPath);
 
    //     try {
    //         String zipFileName = dirPath.concat(".zip");
    //         zos = new ZipOutputStream(new FileOutputStream(zipFileName));
 
    //         Files.walkFileTree(sourceDir, new WholeDirectory(sourceDir));
 
    //         zos.close();
    //     } catch (IOException ex) {
    //         System.err.println("I/O Error: " + ex);
    //     }
    // }
}