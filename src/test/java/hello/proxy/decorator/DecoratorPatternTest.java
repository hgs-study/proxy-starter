package hello.proxy.decorator;

import hello.proxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator(){
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    /**
     * 요구사항 : 코드를 수정하지 않고 로그를 남겨야한다.
     * 데코레이터 추가됨
     */
    @Test
    void decorator1(){
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    /**
     * 요구사항 : 실행 시간 로그 추가해야한다.
     *  데코레이터 특징 : 클라이언트는 전혀 변경사항 없이 프록시를 집어넣어서 꾸미는 패턴
     */
    @Test
    void decorator2(){
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
