## Web Storage

### 개요

- Web Storage
  - 데이터를 사용자의 로컬 환경에 저장하는 방식
  - 데이터 저장 / 덮어쓰기 / 삭제 등 조작 가능
  - JavaScript로만 조작 가능
  - 모바일에서도 사용 가능
- cookie와의 차이점
  - 유효 기간이 없으며, 영구적으로 사용 가능
  - 5MB 가량 사용 가능, (cookie = 4KB)
  - 네트워크 요청 시 서버로 전송 X
  - 서버에서 HTTP 헤더를 통해 스토리지 객체 조작 불가능
  - origin(프로토콜, 도메인, 포트)이 다르면 접근 불가능

---

### localStorage / sessionStorage

- 특성
  - 키(key) - 값(value) 세트로 저장
    - 값은 항상 문자열
  - 도메인 / 브라우저별 저장
- 프로퍼티 / 메서드
  - setItem(key, value)
  - getItem(key)
  - removeItem(key)
  - clear()
  - key(index)
  - length
- local vs. session
  - local
    - 세션이 끝나도 사용 가능
  - session
    - 동일 세션만 사용 가능