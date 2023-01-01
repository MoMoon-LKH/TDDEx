package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일(){

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,3,1))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019,4,1)
        );

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,5,5))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019,6,5)
        );
    }

    @Test
    void 납부일과_한달뒤_일자가_같지않음(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,1,31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2022,2,28)
        );
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,5,31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2022,6,30)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원납부(){

        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2022,1,31))
                .billingDate(LocalDate.of(2022,2,28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(
                payData,
                LocalDate.of(2022,3,31)
                );

        // 첫 납부일과 이후 납부일자가 다를경우 -> 03.28로 나오는 부분 수정
        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2022, 1,30))
                .billingDate(LocalDate.of(2022,2,28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData2, LocalDate.of(2022,3,30));

        // 첫 납부일과 만료일가 같지않을 때
        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2022, 5, 31))
                .billingDate(LocalDate.of(2022,6,30))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData3, LocalDate.of(2022,7,31));

    }

    @Test
    void x만원ㅇ_이상_납부하면_비레해서_만료일_계산(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,3,1))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2022,5,1)
        );

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,3,1))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2022,6,1)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부(){
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2022,1,31))
                        .billingDate(LocalDate.of(2022,2,28))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2022,4,30)
        );

        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2022,3,31))
                        .billingDate(LocalDate.of(2022,4,30))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2022,7,31)
        );
    }

    @Test
    void 십만원을_납부하면_1년제공(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,1,28))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2023,1,28)
        );
    }

    @Test
    void 십만원을_윤달에_납부(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020,2,29))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2021,2,28)
        );
    }

    @Test
    void 십만원이_넘은_금액(){
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,1,28))
                        .payAmount(120_000)
                        .build(),
                LocalDate.of(2023,3,28)
        );

    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate){
        ExpiryDateCalculator cal = new ExpiryDateCalculator();

        LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
