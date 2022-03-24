## Context

### 정의

- Context
  
  - ROOT 폴더 내에 모든 파일을 사용할 경우,  다양한 문맥의 Web 프로젝트들이 한 폴더에 포함
  
    - 다양한 문맥을 나누기 위해, ROOT 폴더 외부에 Context 위치를 지정하여, 서버가 라우팅해주는 추가적인 폴더를 설정
    - 다수의 서버 컴퓨터를 사용할 경우, 각 애플리케이션의 meta-info를 수정하여 사용 가능하다. 
  
  - "webapps\ROOT" 폴더
  
    - (Default) 웹 서버가 라우팅해주는 위치
    - "index.jsp", "tomcat.css", 등을 포함
  
  - "webapps\foo" 폴더 등록
  
    - 웹 서버가 라우팅해주지 않는 위치
    - "conf\server.xml" 파일의 수정이 필요
  
  - "conf\server.xml"
  
    ```xml
    <!-- ... -->
    <Host name="localhost"  appBase="webapps"
          unpackWARs="true" autoDeploy="true">
        <Context path="foo" 
                 docBase="C:\dev\apache-tomcat-9.0.56\webapps\foo"
                 privileged="true"/>
    <!-- ... -->
    ```
  
    - 위와 같이 수정 시, 하나의 추가적인 context 설정 가능
  

---

### Cautions

- Eclipse project properties - Web project settings - Context root
  - 프로젝트 전체의 Context를 지정, "/"을 지정함을 통해 프로젝트 명을 숨길 수 있다. 
- Context root 변경 시
  - 이미 Tomcat 서버에 한 번 이상 올라간 프로젝트의 경우, server.xml 파일에 프로젝트의 Context tag가 생성된다. 
  - Tomcat은 이를 참조하기 때문에, Web Project Settings 뿐만 아니라 server.xml 파일도 수정해주어야 한다. 

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)