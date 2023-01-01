package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData){
        int addedMonths = payData.getPayAmount() == 100_000 ?
            12 : payData.getPayAmount() / 10_000;

        if(payData.getFirstBillingDate() != null){
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else{
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }



   public LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths){

           LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
           if(isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)){
               final int dayLenOfCadiMon = lastDayOfMonth(candidateExp);
               final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();

               if(dayLenOfCadiMon < dayOfFirstBilling){
                   return candidateExp.withDayOfMonth(dayLenOfCadiMon);
               }

               return candidateExp.withDayOfMonth(dayOfFirstBilling);
           } else {
               return candidateExp;
           }

   }

   private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2){
        return date1.getDayOfMonth() != date2.getDayOfMonth();
   }

   private int lastDayOfMonth(LocalDate date){
        return YearMonth.from(date).lengthOfMonth();
   }


}
