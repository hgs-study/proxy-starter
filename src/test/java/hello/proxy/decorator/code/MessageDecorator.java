package hello.proxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator extends Decorator{

    public MessageDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");

        // data -> *****data*****
        String result = super.operation();
        String decoResult = "*****" + result + "*****";
        log.info("MessageDecorator 꾸미기 전  = {}, 적용 후 = {}",result, decoResult);
        return null;
    }
}
