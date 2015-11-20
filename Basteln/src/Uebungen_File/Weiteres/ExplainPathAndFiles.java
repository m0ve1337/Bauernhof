package Uebungen_File.Weiteres;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class ExplainPathAndFiles {

  public static void main(String[] args) throws IOException {

    // Vor Java 7
    File file = new File("einFile");
    file.isDirectory();
    file.isFile();

    // Java 7
    Path path = Paths.get("/Users/kaspar/Desktop/einFile");
    boolean deleteIfExists = Files.deleteIfExists(path);
    System.out.println("Delete File If Exists: " + deleteIfExists);
    System.out.println("getFileName: " + path.getFileName());
    System.out.println("toAbsolutePath: " + path.toAbsolutePath());
    System.out.println("getName: " + path.getName(1));
    System.out.println("getParent: " + path.getParent());
    System.out.println("subpath: " + path.subpath(0, 2));

    // Java6-File nach Java7-Path transformieren:
    Path tPath = new File("fileName").toPath();
    System.out.println("toAbsolutePath: " + tPath.toAbsolutePath());

    // Files (Java 7)
    System.out.println("isRegularFile: " + Files.isRegularFile(path));
    System.out.println("exists: " + Files.exists(path));
    // File erstellen
    System.out.println("createFile: " + Files.createFile(path));
    System.out.println("isRegularFile: " + Files.isRegularFile(path));
    System.out.println("exists: " + Files.exists(path));
    System.out.println("isReadable: " + Files.isReadable(path));

    // Ordner erstellen
    Path ordner = Paths.get("/Users/kaspar/Desktop/Ordner");

    // zuerst inhalt des ordners loeschen, wenn der Ordner existiert.
    if (Files.isDirectory(ordner)) {
      try (DirectoryStream<Path> stream = Files.newDirectoryStream(ordner)) {
        for (Path p : stream) {
          System.out.println("Delete file: " + p.getFileName());
          Files.delete(p);
        }
      }
    }
    // falls noch ein Ordner vorhanden ist --> loeschen
    Files.deleteIfExists(ordner);

    Files.createDirectory(ordner);
    System.out.println("Ordner Berechtigungen: "
        + Files.getPosixFilePermissions(ordner));

    // Datei kopieren und verschieben
    Files.copy(path, Paths.get("/Users/kaspar/Desktop/Ordner/bFile"));
    Files.move(path, Paths.get("/Users/kaspar/Desktop/Ordner/aFile"));

    // Dateiattribute setzen (Berechtigungen)
    Set<PosixFilePermission> perms = PosixFilePermissions
        .fromString("r--r--r--");
    FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions
        .asFileAttribute(perms);
    Path path2 = Paths.get("/Users/kaspar/Desktop/testFile");
    // existierende ordner loeschen
    Files.deleteIfExists(path2);
    Files.createFile(path2, attr);

    // Berechtigungen aendern
    Path dir = Paths.get("/Users/kaspar/Desktop/testOrdner");
    // existierende Ordner loeschen
    Files.deleteIfExists(dir);
    Files.createDirectory(dir, attr);
    Files.setPosixFilePermissions(dir,
        PosixFilePermissions.fromString("rw-r--r--"));
    System.out.println("testOrdern Berechtigungen: "
        + Files.getPosixFilePermissions(dir));

    // File Attribute auslesen
    BasicFileAttributes attributes = Files.readAttributes(dir,
        BasicFileAttributes.class);
    System.out.println("creationTime: " + attributes.creationTime());
    System.out.println("lastAccessTime: " + attributes.lastAccessTime());
    System.out.println("lastModifiedTime: " + attributes.lastModifiedTime());

    System.out.println("isDirectory: " + attributes.isDirectory());
    System.out.println("isOther: " + attributes.isOther());
    System.out.println("isRegularFile: " + attributes.isRegularFile());
    System.out.println("isSymbolicLink: " + attributes.isSymbolicLink());

    Path testFolder = Paths.get("/Users/kaspar/Desktop/TestFolder");

    if (Files.isDirectory(testFolder)) {

      Files.walkFileTree(testFolder, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
          System.out.println("Delete File: " + file);
          Files.delete(file);
          return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException e)
            throws IOException {
          if (e == null) {
            System.out.println("Delete Directory: " + dir);
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
          } else {
            // directory iteration failed
            throw e;
          }
        }
      });

    }
  }
}
