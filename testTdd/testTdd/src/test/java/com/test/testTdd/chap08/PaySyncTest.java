package com.test.testTdd.chap08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaySyncTest {

    private MemoryPayInfoDao memoryPayInfoDao = new MemoryPayInfoDao();

    @Test
    void allDataSaved() throws IOException {
        PaySync paySync = new PaySync();
        paySync.setPayInfoDao(memoryPayInfoDao);
        paySync.setFilePath("src/test/resources/c0111.csv");
        paySync.sync();

        List<PayInfo> savedInfos = memoryPayInfoDao.getAll();
        assertEquals(2, savedInfos.size());
    }
}
