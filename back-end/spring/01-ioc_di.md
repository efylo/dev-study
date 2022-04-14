## IoC / DI

### Abstract

- has a 관계

  - 하나의 개체가, 다른 객체를 사용하는 관계를 가리킨다. 
    - A has a B, A is dependent of B
    - B 객체는, A 객체의 멤버 변수
  - Association 관계
  - Aggregation 관계
  - Composition 관계 

---

### Dependency

- has a 관계에서, 사용의 객체가 되는 개체
  - 특정 클래스에서 사용되는 멤버 변수
  - 특정 프로젝트에서 사용되는 라이브러리

---

### IoC

- Inversion of Control(제어의 역전)
  - 해석
    1. 주격 객체에서 제어하던 목적격 클래스를 분리하여, 제 3의 객체가 이를 관리한다. 
       - Spring 프레임워크의 IoC 컨테이너가, 개발자가 개발한 객체를 관리한다. 
    2. 개발자가 주체적으로 관리하던 객체의 생명 주기를, 프레임워크에서 관리한다. 
  - Composition 관계 
    - has a 관계의 주격 클래스는, 목적격 클래스의 제어권을 갖는다. 
    - 주격 클래스의 생성 이전, 소멸 이후 목적격 클래스는 존재할 수 없다. 
  - Association 관계
    - has a 관계의 주격 클래스는, 목적격 클래스의 제어권을 갖지 않는다. 
      - 주격 클래스 내부에서 목적격 클래스의 생명 주기를 제어하지 않는다. 
    - Loose coupling, 약한 결합도를 갖는 관계가 된다. 
- 방법론
  - Dependency Injection
    - Container 객체가, has a 관계의 주격 클래스에 목적격 클래스를 Inject한다. 
      - Spring - IoC Container
    - Configuration, 설정 파일 작성
      - Spring Beans에 관한 메타 정보를 작성한다
        - 메타 정보에 의거하여, IoC Container는 Beans 객체를 관리한다. 
  - Dependency Lookup
    - Container에서 생성하고 관리하는 Dependency를 Lookup(조회)한다. 
      - Tomcat의 DB Connection Pool에 존재하는 Connection 객체를 Lookup하는 과정


---

### Examples

- A has a B 관계를 만족하는, A / B 클래스를 가정

  - A 클래스는 멤버 변수로써 B 인스턴스를 갖고 있다. 
  - Dependency = B 인스턴스
  - Dependency Injection = B 인스턴스를 생성하여, A 인스턴스 내부에 주입해주는 것

- Container

  - 컨테이너에서, A / B 인스턴스를 각각 생성한다. 
  - 컨테이너는, A 인스턴스 내부에 B 인스턴스를 주입한다. 
  
- Code

  ```java
  class A {
      private B b;
      
      public A() {
      }
      
      // Setter를 통한 주입; Setter Injection
      public void setB(B b) {
          this.b = b;
      }
  }
  
  class B {
      public B() {
      }
  }
  
  public class Container {
      public void static main(String[] args) {
          B b = new B();
          A a = new A();
          // Dependency Injection, using Setter method
          a.setB(b);
      }
  }
  ```

---

### Reference

- [YouTube - 뉴렉처 [스프링 강의 01 - DI(Dependency Injection)]](https://www.youtube.com/watch?v=XtXHIDnzS9c&list=PLq8wAnVUcTFWxnsrMu5kS_jt_o8gpEiTR)
- [GeeksforGeeks - Association, Composition and Aggregation in Java](https://www.geeksforgeeks.org/association-composition-aggregation-java/?ref=gcse)