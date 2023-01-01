package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData){
        int addedMonths = calculateAddedMonth(payData.getPayAmount());

        if(payData.getFirstBillingDate() != null){
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else{
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);

            return withLastDay(payData.getBillingDate(), candidateExp);
        }
    }



   public LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths){

           LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
           if(isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)){

               return withLastDay(payData.getFirstBillingDate(), candidateExp);
           } else {
               return candidateExp;
           }

   }

   private LocalDate withLastDay(LocalDate billingDate, LocalDate candidateDate){
        final int dayLenOfCandiMon = lastDayOfMonth(candidateDate);
        final int dayOfBilling = billingDate.getDayOfMonth();

        if(dayLenOfCandiMon < dayOfBilling){
            return candidateDate.withDayOfMonth(dayLenOfCandiMon);
        }

        return candidateDate.withDayOfMonth(billingDate.getDayOfMonth());
   }

   private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2){
        return date1.getDayOfMonth() != date2.getDayOfMonth();
   }

   private int lastDayOfMonth(LocalDate date){
        return YearMonth.from(date).lengthOfMonth();
   }


   private int calculateAddedMonth(int payAmount){
        int yearAmount = 100_000;
        int monthAmount = 10_000;

        if(payAmount >= yearAmount){
            int year =  payAmount / yearAmount;
            int month = (payAmount % yearAmount) / monthAmount;
            return year * 12 + month;
        } else{
            return payAmount / monthAmount;
        }
   }

}
