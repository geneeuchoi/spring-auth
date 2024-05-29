package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    //@Autowired
    //Food food; //자동 주입 불가: bean이 2개 이상
    //빈 등록 방법
    //1. 직접 주입

//    @Autowired
//    Food pizza;
//
//    @Autowired
//    Food chicken;
    // => 기본적으로는 타입으로 찾지만, 타입으로 찾을 수 없다면 이름으로 찾음
    //@Test
//    @DisplayName("테스트")
//    void test1() {
//        pizza.eat();
//        chicken.eat();
//    }
    //2.
    //구현체에 @Primary 붙이기
    //우선적으로 그 객체를 주입해줌.
//    @Autowired
//    Food food;

//    @Test
//    @DisplayName("테스트")
//    void test1() {
//        food.eat();
//        //치킨을 먹습니다.
//    }

    //3.
    //구현체에 @Qualifier 붙이기
    @Autowired
    @Qualifier("pizza")
    Food food;

    @Test
    @DisplayName("테스트")
    void test1() {
        food.eat();
        //피자를 먹습니다.
    }

    @Test
    @DisplayName("Qualifier과 Primary중 어느 것이 우선순위가 높은가?")
    void test2() {
        food.eat();
        //피자를 먹습니다.
        //-> Qualifier의 우선순위가 높음
        //범용적으로 사용되는 빈에는 primary
        //지역적으로 사용되는 빈에는 qualifier
        //스프링은 지역적(좁은 범위의 설정)에 높은 우선순위를 준다.
    }
}
