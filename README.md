# proxy-starter

### 프록시 패턴
- 캐싱
- 접근 제어
- 권한에 따른 접근 차단
- 지연 로딩

### 데코레이터 패턴
- 새로운 부가 기능추가

![image](https://user-images.githubusercontent.com/76584547/171671694-12e2c886-d38a-4dfc-93bc-9fc3b9a10fe1.png)
 - Decorator 추상 클래스 추가
   - 데코레이터 추상 클래스 만들어서 어떤 것이 실제 컴포넌트고, 어떤 것이 데코레이터인지 구분
   - 중복 제거

#### 프록시 vs 데코레이터
- 형태는 거의 비슷하다
- 하지만 `의도`에 따라 구분 가능
- 프록시 패턴 : 다른 개체에 대한 접근을 제어하기 위해 대리자를 제공
- 데코레이터 패턴 : 객체에 추가 책임(기능)을 동적으로 추가하고, 기능 확장을 위한 유연한 대안 제공


### 인터페이스 기반 프록시 vs 클래스 기반 프록시

#### 인터페이스 기반 프록시
  - 인터페이스 기반 프록시는 인터페이스만 같으면 모든 곳에 적용할 수 있다.
  - 인터페이스 기반의 프록시는 상속이라는 제약에서 자유롭다. 프로그래밍 관점에서도 인터페이스를 사용하는 것이 역할과 구현을 명확하게 나누기 때문에 더 좋다.
  - 인터페이스를 만들어야하는 것이 단점

#### 클래스 기반 프록시
 - 클래스 기반 프록시는 해당 클래스에만 적용할 수 있다.
 - 클래스 기반 프록시는 상속을 사용하기 때문에 몇가지 제약이 있다.
   - 부모 클래스의 생성자를 호출해야 한다.(앞서 본 예제)
   - 클래스에 final 키워드가 붙으면 상속이 불가능하다.
   - 메서드에 final 키워드가 붙으면 해당 메서드를 오버라이딩 할 수 없다.

### 리플렉션
- 리플렉션은 런타임 시점에 동작하기 때문에, 컴파일 시점에 오류를 잡을 수 없다.
- 리플렉션은 프레임워크 개발이나 또는 매우 일반적인 공통 처리가 필요할 때 부분적으로 주의해서 사용해야한다.
> 따라서 일반적으로  사용하면 안된다.

### JDK 동적 프록시
- proxy -> invocationHandler -> target
- 인터페이스 필요

![image](https://user-images.githubusercontent.com/76584547/173589645-1f7c714e-daa6-4424-90ef-0d567497eb86.png)

![image](https://user-images.githubusercontent.com/76584547/173588651-fb8515aa-33ff-45c2-9f83-86f8379acc27.png)


### CGLIB
- `CGLIB` : Code Generator Library
- 바이트코드를 조작해서 동적으로 클래스를 생성하는 기술을 제공하는 라이브러리
- 인터페이스 없이 구체 클래스만 가지고 동적 프록시를 만들어낼 수 있다.
- 원래는 외장 라이브러리지만 스프링이 내부에 넣어 놓았다.
- JDK 동적 프록시는 인터페이스를 구현해서 프록시를 만들지만, CGLIB는 구체 클래스를 상속해서 프록시를 만든다.

- 세팅
  - 구체클래스 생성 
  - `MethodInterceptor`를 구현해서 `intercept()`를 커스텀마이징
  - `Enhancer` 설정
