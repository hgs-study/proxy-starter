package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA(){
        AImpl target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        // 프로시 동적 생성
        // 어떤 인터페이스(AInterface) 기반으로 사용해서 만들 것인지
        // handler : 프록시가 사용해야하는 로직
        //Object proxy = Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);
       AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

       proxy.call();
       log.info("targetClass = {}", target.getClass());
       log.info("proxyClass = {}", proxy.getClass());
    }

    @Test
    void dynamicB(){
        BImpl target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

        proxy.call();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
    }
}
