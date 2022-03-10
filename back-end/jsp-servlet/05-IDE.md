## IDE

### 의의

- 개발의 여러 단계를 통합한 환경을 제공

  > 1. 코드 작성 / 수정
  > 2. 컴파일
  > 3. 배포
  > 4. 톰캣 서버 재시작
  > 5. 브라우저 요청

  - 위 5단계를, 한 번의 Run으로 통합

- Eclipse

  - Java EE 버전
  - Tip
    - tools 폴더: 사용하는 개발 툴을 모아놓고 관리
    - workspace 폴더: 각 프로젝트마다, 작업 공간 폴더를 생성하여 관리
  - Project 생성 / 환경 설정
    - New Dynamic Web Project
    - Target runtime 
      - Apache Tomcat v9.0: 해당 폴더 "...\apache-tomcat-9.0.xx" 선택

---

### Eclipse 사용

- Project 생성 / 환경 설정

  - New Dynamic Web Project

  - Target runtime 

    - Apache Tomcat v9.0: 해당 폴더 "...\apache-tomcat-9.0.xx" 선택

  - Context명 제거

    - Project 우클릭 - Open properties 실행
      - Web Project Settings 탭
        - Context root: /

  - Servlet 클래스 생성

    - Project 폴터

      - Java Resources

        - src
          - com.example.web 패키지 생성
            - Foo.java 파일 생성 / 작성

      - WebContent

        - WEB-INF

          - web.xml 파일 가져오기 (Tomcat 폴더)

            ```xml
            <servlet>
                <servlet-name>foo</servlet-name>
                <servlet-class>com.example.web.Foo</servlet-class>
            </servlet>
            
            <servlet-mapping>
                <servlet-name>foo</servlet-name>
                <url-pattern>/hello</url-pattern>
            </servlet-mapping>
            ```

            - 서블릿 클래스 - 패키지명을 포함하여 작성

  - Annotation 활용

    - WAS는 웹 서버로 들어오는 url-pattern을 처리한다. 
    
    - 들어온 url-pattern 정보를, 서블릿 클래스에 매핑한다. 
    
    - 기존에는 이를 web.xml을 통해 진행했었다면, 서블릿 3.0 이상부터는 Annotation을 지원한다. 
    
    - 단순히 가독성이 좋아지는 것을 뛰어넘어, 더욱 독립적인 환경에서 각 팀들이 개발을 진행할 수 있게 된다. 
    
    - "web.xml" 파일 수정 필요
    
      ```xml
      <web-app xmlns="..."
               ...
               version="4.0"
               metadata-complete="false">
          ...
      </web-app>
      ```
    
      - metadata-complete 부분 "false" 처리를 통해, WAS가 annotation을 통해 매핑을 진행토록 처리

---

### Servlet

- Create Servlet
  - 서블릿 클래스의 양식에 맞게 생성
    - Annotation의 URL 매핑 지정 가능
    - Override를 원하는 메서드 지정 가능

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)