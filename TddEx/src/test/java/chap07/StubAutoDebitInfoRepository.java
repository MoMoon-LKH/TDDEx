package chap07;

public class StubAutoDebitInfoRepository implements AutoDebitInfoRepository {

    @Override
    public AutoDebitInfo findOne(String userId) {
        return new AutoDebitInfo(userId);
    }

    @Override
    public void save(AutoDebitInfo newInfo) {

    }
}
