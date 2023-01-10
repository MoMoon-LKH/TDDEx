package chap05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class BadTest {
    private FileOperator op = new FileOperator();
    private static File file;

    /*
        테스트메서드는 순서를 보장하지않는다.
        또한 보장이 되더라도 독립적으로 작동해야된다.
        -> 한 테스트의 메서드의 결과가 다른 메서드의 테스트 결과에 영향을 끼쳐선 안되기 때문
     */

    @Test
    void fileCreationTest(){
        File createdFile = op.createFile();
        assertTrue(createdFile.length() > 0);
        this.file = createdFile;
    }

    @Test
    void readFileTest(){
        long data = op.readData(file);
        assertTrue(data > 0);
    }

}
