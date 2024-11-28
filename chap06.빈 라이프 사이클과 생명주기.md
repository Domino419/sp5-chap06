>Chapter6. 빈 라이프사이클과 범위
>> 컨테이너 초기화와 종료
>> 스프링 빈 객체의 라이프사이클
>> 빈 객체의 초기화와 소멸: 스프링 인터페이스
>>빈 객체의 생성과 관리 범위


1.컨테이너 초기화와 종료
 - 스프링 컨테이너의 라이프사이클에 따라 빈 객체도 자연스럽게 생성과 소멸이라는 라이프사이클을 갖는다. 
 컨테이너 초기화 → 빈 객체의 생성, 의존 주입, 초기화 
 컨테이너 종료 → 빈 객체의 소멸 

2.스프링 빈 객체의 라이프사이클
컨테이너를 초기화할 때, 가장 먼저 빈 객체를 생성하고 의존을 설정한다.
의존 자동 주입을 통한 의존 설정이 이 시점에 수행된다.
빈 객체의 초기화를 수행한다. 빈 객체를 초기화하기 위해 스프링은 빈 객체의 지정된 메서드를 호출한다.
스프링 컨테이너는 빈 객체의 소멸을 처리한다. 이때에도 지정한 메서드를 호출한다.

2.1. 빈 객체의 초기화와 소멸 : 스프링 인터페이스
빈 객체를 초기화하고 소멸하기 위해 빈 객체의 지정한 메서드를 호출한다.
org.springframework.beans .factory.lnitializingBean
org.springframework.beans .factory.DisposableBean

```
public interface lnitializingBean{ // 빈 객체가 이 인터페이스를 구현하면
		void afterPropertiesSet() throws Exception; // 컨테이너가 초기화시 이 메서드를 실행
} 
public interface DisposableBean { // 빈 객체가 이 인터페이스를 구현하면
		void destroy() throws Exception;  // 컨테이너가 소멸시 이 메서드를 실행
}
```
초기화와 소멸 과정이 필요한 예: 데이터 베이스 커넥션 풀, 채팅 클라이언트

2.2.빈 객체의 초기화와 소멸: 스프링 인터페이스
직접 구현한 클래스가 아닌 외부에서 제공받은 클래스를 스프링 빈 객체로 설정하는 방법 2가지 
@Bean 태그에서 initMethod 속성과 destroyMethod 속성을 사용해서 초기화 메서드와 소멸 메서드의 이름을 지정하여 사용하거나,
스프링 설정에서 직접 메서드를 지정하여 사용한다.

@Bean(initMethod = "connect", destroyMethod = "close")
BeanDefinitionValidationException: Couldn't find an init method named 'connect()' on bean with name 'client2'
속성값에 메소드명만 넣어야 하는데 괄호까지 입력해버려서 빌드 실패 

코드 수정후 출력값 

```
Client.afterPropertiesSet() 실행
Client2.connect() 실행
Client.send() to  host
Client2.close() 실행
Client.destroy() 실행 
```

3.빈 객체의 생성과 관리 범위
```
동일한 이름을 찾는 빈 객체는 한개만 생성된다. 별도 설정을 하지 않는 경우 싱글톤 범위를 갖는다.

 Client client1 = ctx.getBean(Client.class) ;
 Client client2 = ctx.getBean(Client.class) ;
 // client1 == client2  → ture
```
프로토타입 빈: 프로토타입으로 지정하면 빈 객체를 구할 때마다 매번 새로운 객체를 생성한다.
빈의 범위를 프로토 타입으로 지정하려면 @Scope("prototype") , 
싱글톤 범위를 명시적으로 지정하려면 @Scope("singleton") 
단 프로토타입 범위를 갖는 빈은 완전한 라이프사이클을 따르지 않는다.
스프링 컨테이너가 프로토타입의 빈 객체를 생성, 프로퍼티 설정, 초기화 작업까지만 수행하기 때문에
코드에서 직접 빈 객체의 소멸처리를 해주어야 한다.





