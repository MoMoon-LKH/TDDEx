package chap05;

import java.io.File;

public class FileOperator {

    public File createFile(){
        return new File("/");
    }

    public long readData(File file) {
        return file.length();
    }
}
