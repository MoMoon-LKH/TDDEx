package com.test.testTdd.chap08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryPayInfoDao implements PayInfoDao {

    Map<Integer, PayInfo> map = new HashMap<>();

    @Override
    public void insert(PayInfo pi) {
        map.put(pi.getParse(), pi);
    }

    @Override
    public List<PayInfo> getAll() {
        return new ArrayList<>(map.values());
    }
}
