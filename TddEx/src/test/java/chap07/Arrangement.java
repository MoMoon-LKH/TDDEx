package chap07;

public class Arrangement {

    /*
        대역 : 외부 요소에 대한 대체 요소

        대역이 필요한 시점
        - 외부요인으로 인해 테스트 하기 어려운 경우
         ㄴ 테스트 대상에서 파일 사용
         ㄴ DB로부터 데이터를 조회 및 데이터 추가
         ㄴ 외부의 HTTP 서버와 통신할 필요가 있을 경우
         등등

         종류
         - 스텁(Stub) : 구현을 단순한 것으로 대체 -> 테스트에 맞게 단순히 원하는 동작을 수행 ex) StubCardNumberValidator
         - 가짜(Fake) : 제품에는 적합 X, 실제 동작하는 동작을 구현 -> DB 대신에 메모릴 이용해서 구현 ex) MemoryAutoDebitInfoRepository
         - 스파이(Spy) : 호출된 내역을 기록 -> 기록한 내용을 테스트 결과를 검증할 때 사용, Stub일 경우도 있다
         - 모의(Mock) : 기대한 대로 상호작용하는지 행위를 검증 -> 기대한 대로 동작하지 않으면 익셉션을 발생, Stub이자 Spy
    */
}
