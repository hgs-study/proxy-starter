package hello.proxy.decorator.code;

public abstract class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public String operation(){
        return component.operation();
    }
}
