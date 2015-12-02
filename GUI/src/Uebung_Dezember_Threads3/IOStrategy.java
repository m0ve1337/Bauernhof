package Uebung_Dezember_Threads3;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IOStrategy {

  void save(File file, List<String> decisions) throws IOException;

  List<String> load(File file) throws IOException, ClassNotFoundException;

}