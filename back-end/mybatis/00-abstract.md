## MyBatis

### Abstract

- 퍼시스턴스 프레임워크
  - JDBC 코드와 SQL문을 분리하여 관리할 수 있도록 도와주는 프레임워크

---

### Configuration XML

- XML 구조
  - mybatis-3-config.dtd 스키마 사용 설정
    - \<!DOCTYPE configuration PUBLIC ...dtd/mybatis-3-config.dtd">
  - \<configuration>
    - \<typeAliases>
      - \<typeAlias>
        - 자바 클래스의 full-name과, 그에 대한 별칭을 매핑한다. 
        - 기본형 데이터 타입, 콜렉션 API 내 클래스 및 인터페이스는 매핑된 별칭이 존재한다. 
    - \<environments>
      - \<environment>
        - MyBatis 프레임워크가 동작하는 환경 변수를 정의한다. 
        - 트랜잭션 매니저, 데이터소스를 정의할 수 있다. 
    - \<mappers>
      - \<mapper>
        - Mapper 인터페이스와 매핑할 매퍼 XML파일을 지정한다. 

---

### Mapper 인스턴스

- **개요**
  - Mapper 인스턴스의 메서드는, 정의된 SQL문과 매핑이 가능하다. 
  - 매핑은, Mapper XML 설정 파일 내부에서 정의한다. 
    - namespace: Mapper 인터페이스의 full-path
    - id: 해당 Mapper 인터페이스의 메서드명
- **흐름**
  1. Configuration(설정)을 위한 XML 파일 생성
     - DataSource, TransactionManager, Mapper 등을 설정한다. 
  2. SqlSessionFactoryBuilder().build(Reader config)
     - 설정 파일을 해석하여, SqlSessionFactory 인스턴스를 빌드한다. 
  3. SqlSessionFactory.openSession()
     - SQL문을 실행할 수 있는, SqlSession 인스턴스를 반환한다. 
     - 의존성 관리를 위해, 스프링 컨테이너 등에 관리를 위임할 수 있다. 
  4. SqlSession.getMapper(xxxMapper.class)
     - 정의된 SQL문과 메서드가 매핑되어 있는, Mapper 인스턴스를 반환한다. 
     - 메서드 호출을 통하여, SQL문을 실행할 수 있다. 

---

### Mapper XML

- XML 설정
  - mybatis-3-mapper.dtd 스키마 사용 설정
    - \<!DOCTYPE mapper PUBLIC ...dtd/mybatis-3-mapper.dtd">
  - \<mapper>
    - \<select>
      - 프로퍼티
        - id - Select문을 수행할 메서드의 이름
        - parameterType - 입력 매개변수의 데이터 타입
        - resultType - 출력 결과의 데이터 타입
    - \<insert>, \<update>, \<delete>
      - 프로퍼티
        - id - Insert, Update, Delete문을 수행할 메서드의 이름
        - parameterType - 입력 매개변수의 데이터 타입
      - 자동생성키
        - Insert문의 경우, 삽입 이후에 자동 생성된 키 값을 필요로 하는 경우가 존재
          - useGeneratedKeys="true" 설정
        - keyProperty - 자동생성키가 적용된 칼럼명
    - \<sql>
      - 재사용 가능한 SQL문에 대한 정의
      - id - 현재 태그의 식별자
      - \<include refid="">
        - refid - 해당 id의 \<sql> 태그의 SQL문을 포함한다. 
    - \<resultMap>
      - id, result - 하나의 칼럼을, POJO의 필드에 매핑한다. 
      - constructor - 특정 칼럼을, POJO의 생성자에 사용한다. 이 때 칼럼의 javaType을 지정한다. 
      - association - POJO의 has one 관계를 다루는 방법을 제시한다. 
      - collection - POJO의 has many 관계를 다루는 방법을 제시한다. 
      - discriminator - 칼럼의 value에 따른 매핑을 진행한다. 
    - \<selectKey>
      - keyProperty - 자동 생성된 키 값의 칼럼 명
      - resultType - 해당 키의 데이터 타입
      - order - insert문 이전 / 이후에 실행할 것을 결정
    - \<cache>
      - select문의 모든 결과는 캐싱된다. 
      - insert, update, delete문은 캐시를 지운다. 
      - Least Recently Used(LRU) 알고리즘을 사용한다. 
      - 1024개의 참조를 저장한다. 
  - 