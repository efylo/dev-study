## KAKAO Map API

### Abstract

- Javascript 내에서, kakao map api를 활용해 지도 창을 표현 / 제어 / 로직 등 구현 가능
  - 사용자에게 지도에 관련한 정보를 조금 더 가시적으로 제공

---

### Desc

1. API import

   - [Kakao developers](https://developers.kakao.com/) 내 애플리케이션 등록

     - App key
       - Kakao Map API에 요청을 전송할 때, bind

   - [Kakao Maps API](https://apis.map.kakao.com/) Guide / Sample / Docs 참조

     - API import, 지도 및 좌표 객체에 대한 설명

   - HTML5

     - script tag에 Kakao Maps API import

       ```html
       <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 넣으시면 됩니다."></script>
       ```

2. 지도 객체

   - 지도 객체를 담을, div tag 생성

     ```html
     <div id="map">지도 객체 생성용 div 태그</div>
     ```

     

3. 좌표 객체

4. 기타

   - 지도 라이브러리
     - 기능: clusterer, services, drawing
   - 지도 URL
     - Kakao 지도에 연결
       - 지도 / 길찾기 / 로드뷰 바로가기 링크

---

### Reference

- [Kakao Maps API](https://apis.map.kakao.com/)
- [Kakao Developers](https://developers.kakao.com/)