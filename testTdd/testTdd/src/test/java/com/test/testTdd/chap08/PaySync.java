package com.test.testTdd.chap08;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PaySync {

    // 의존 대상을 직접 생성하는 문제점
    private PayInfoDao payInfoDao;
    private String filePath;

    public void sync() throws IOException {
        // 해당 파일 경로가 하드 코딩 되어있음
        // 이 코드를 테스트 하기위해서는 해당 경로에 파일이 반드시 위치해야됨
        Path path = Paths.get(filePath);

        List<PayInfo> payInfos = Files.lines(path)
                .map(line -> {
                    String[] data = line.split(",");
                    PayInfo payInfo = new PayInfo(
                            data[0], data[1], Integer.parseInt(data[2])
                    );
                    return payInfo;
                })
                .collect(Collectors.toList());
        payInfos.forEach(pi -> payInfoDao.insert(pi));
    }
}
