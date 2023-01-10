package chap05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleTest {

    public LifecycleTest(){
        System.out.println("new LifecycleTest");
    }


    /*
        @BeforeEach
         - 테스트 메서드마다 실행되기 전에 실행되는 메서드
         - 테스트를 실행하는데 필요한 사전 작업을 할 때 사용            
     */
    @BeforeEach
    void setUp(){
        System.out.println("setUp");
    }

    @Test
    void a() {
        System.out.println("A");
    }

    @Test
    void b(){
        System.out.println("B");
    }

    
    /*
        @AfterEach
         - 테스트 메서드마다 실행한 후에 실행되는 메서드
         - 테스트를 실행한 후 정리할 작업이 필요할 때 사용
     */
    @AfterEach
    void tearDown(){
        System.out.println("tearDown");
    }
}
