package chap06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    @Test
    void noDataFile_Then_Exception(){
        File dataFile = new File("badpath.txt");
        assertThrows(IllegalArgumentException.class,
                () -> MathUtil.sum(dataFile));
    }
}
