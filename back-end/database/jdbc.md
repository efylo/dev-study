## JDBC

### Abstract

- Java DataBase Connectivity
  - Java 프로그램에서, 데이터베이스와 연결하기 위한 인터페이스
    - 인터페이스가 존재한다고 해서, 데이터베이스와 연결 가능하지 않다. 
  - 인터페이스는, 다양한 DBMS에 존재하는 공통적인 기능들을, 추상적인 클래스 혹은 메서드로 정의해놓은 것
    - DBMS에서 제공하는 JDBC의 구현체, Connector 등을 내부 라이브러리에 import하여 사용

---

### Connector

- Driver

  - DBMS에서 제공하는, JDBC의 구현 클래스
  - [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) - MySQL에서 제공하는 드라이버

- DriverManager

  - java.sql 패키지에 포함된 클래스
  - Driver와 관련된 Managing 기능들을 제공
  - Singleton 디자인 패턴 구현
    - 프로그램 내 인스턴스 임의 생성 불가능

- DriverManager.getConnection(String url, String user, String password)

  - Arguments

    > - url
    >   - "jdbc:mysql://127.0.0.1:3306/schema_name?userUniCode=yes&characterEncoding=UTF-8&..."
    > - jdbc:mysql
    >   - 해당 프로토콜을 사용하여 통신
    > - 127.0.0.1:3306 
    >   - 연결하고자 하는 DB의 도메인 주소 및 포트 번호
    > - schema_name 
    >   - DB 내 존재하는 스키마 이름
    > - userUniCode=yes&characterEncoding=UTF-8
    >   - 문자열 인코딩 타입 및, 유니코드 사용 여부 지정
    >   - 사전에 정의된 key-value 값을 사용하여, 통신 규격에 대한 정의
    > - user
    > - url 주소에 존재하는 db에 접근할 때 사용할 사용자 id
    > - password
    >   - 해당 사용자 id의 password

  - 특징

    - Connection을 맺는 것에 시간이 오래 걸린다. (공통)
      - Connection pool을 프로그램 구동 시 생성해, 각 사용자에게 할당하여 연결 시간을 줄인다. 
      - 설정해둔 Connection pool을 초과해서 연결 요청이 들어올 경우, 여전히 연결이 오래 걸릴 수 있다. 