package com.test.testTdd.chap08;

import java.util.List;

public interface PayInfoDao {
    void insert(PayInfo pi);
    List<PayInfo> getAll();
}
