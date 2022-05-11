## File

### Abstract

- 파일 업로드
  - 클라이언트의 파일을 웹 서버 상에 저장하는 것
- 파일 다운로드
  - 웹 서버 상의 파일을 클라이언트의 시스템에 저장하는 것

---

### Upload in Spring

- **Configuration**

  > - Dependency 설정 - pom.xml
  >
  >   - spring-web
  >   - commons-fileupload
  >     - Apache 재단의 Commons FileUpload 패키지
  >     - HTML 페이지 내에서, Form-based File Upload에 대한 파싱 기능을 지원
  >
  > - Servlet Context 설정 - servlet-context.xml
  >
  >   ```xml
  >   <beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
  >       <beans:property name="defaultEncoding" value="UTF-8" />
  >       <!-- maximum upload size possible in bytes -->
  >       <beans:property name="maxUploadSize" value="10485760" />
  >       <!-- maximum size possible in main memory in bytes -->
  >       <beans:property name="maxInMemorySize" value="1048576" />
  >   </beans:bean>
  >   ```
  >
  >   - Properties
  >     - defaultEncoding
  >       - 기본적으로 설정할 인코딩 타입을 지정
  >     - maxUploadSize
  >       - 업로드 가능한 최대 크기를 지정 (바이트 단위)
  >     - maxInMemorySize
  >       - 메모리에 올라갈 수 있는 최대 크기를 지정 (바이트 단위)
  >     - uploadTempDir
  >       - 임시적으로 저장할 디렉토리를 지정
  >   - 주의사항
  >     - id를 "multipartResolver"로 지정하지 않을 경우, DispatcherServlet 객체가 인식하지 못한다. 

- MVC 구성

  > - View
  >   - HTML - form 태그 설정
  >     - \<form method="post" enctype="multipart/form-data">
  >     - POST 메서드 사용
  >     - content-type은 multipart/form-data 사용
  >   - HTML - input 태그 설정
  >     - \<input type="file" name="upfile" multiple="multiple">
  >     - file 타입 사용
  >     - name은 HTTP 요청을 보낼 때 필수적으로 사용
  >     - multiple은 다수의 파일 업로드를 허용하고자 할 경우 사용
  > - Controller
  >   - Parameter
  >     - @Requestparam(value = "upfile") MultipartFile file
  >       - getOriginalFileName() : String
  >         - 파일의 기존 이름을 반환
  >       - transferTo(File dest) : void
  >         - dest에 해당하는 위치에 파일을 전송
  >         - 로컬 시스템에 저장하는 방법 - 시스템 변경 시, 해당 파일을 참조할 수 없다. 
  >           - 폴더: workspace/project/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/
  >       - 주의사항
  >         - 이름에 공백이 포함된 파일에 대해 처리하는 것

---

### Reference

- [CommonsMultipartResolver (Spring Framework 5.3.19 API)](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/multipart/commons/CommonsMultipartResolver.html)
- [[[스프링\] 스프링의 MVC - 파일 업로드 처리, 다운로드 처리]](https://m.blog.naver.com/javaking75/140203390797)