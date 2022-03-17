## JOIN

### Abstract

- 두 개 이상의 테이블에서 데이터가 필요한 경우, JOIN절을 활용하여 테이블의 열을 합친다. 
  - ON절 안에, 두 테이블의 각 행이 만족해야하는 관계(조건)을 작성
    - 일반적으로 PK = FK 조건이 자주 사용

> - Primary Key(기본키): UNIQUE / NOT NULL, INDEX 자동 생성
> - Foreign Key(외래키): 다른 테이블에서 존재하는 값을 참조, NULL 허용

---

### Approach

- A JOIN B ON A.PK = B.FK
  - 행 단위로 접근
    - A 테이블의 1행과, B 테이블의 전체 행을 비교
    - A.PK = B.FK를 만족하는 B 테이블의 행일 경우
      - A의 1행 데이터 + B 테이블의 행을 JOIN한다. 
      - A의 Column과, B의 Column을 모두 갖는 행을 반환한다. 
    - A 테이블의 전체 행에 대해서 반복
- ON절
  - A 테이블과, B 테이블이 만족해야 하는 관계를 정의한다. 
    - A 칼럼의 데이터와, B 칼럼의 데이터 간 관계를 생각하여 작성한다. 

---

### Types

- INNER JOIN
  - JOIN 조건이 만족하는 데이터만 반환한다. 
  - 가장 자주 사용되며, MySQL에서는 INNER 키워드 생략이 가능하다. 
- OUTER JOIN
  - A LEFT OUTER JOIN B ON A.col1 = B.col1;
    - B.col1의 값이 NULL인 경우에도 반환한다. 
  - A RIGHT OUTER JOIN B ON A.col1 = B.col1;
    - A.col1의 값이 NULL인 경우에도 반환한다. 
  - A FULL OUTER JOIN B ON A.col1 = B.col1;
    - LEFT OUTER JOIN union RIGHT OUTER JOIN
- SELF JOIN
  - 동일한 두 개의 테이블 내에 존재하는 관계에 사용된다. 
  - A 테이블 내 하나의 행이, 다른 행과의 관계가 존재할 때 사용한다. 
  - A child JOIN A parent ON child.parent_id = parent.id
- NON-EQUI JOIN
  - Equivalent 조건을 제외한, (!=, <, >, <=, >=, 등)을 관계의 조건으로 사용하는 경우

---

### 다중 JOIN문

- 3개 이상의 테이블에서 JOIN문을 활용하여 데이터를 결합하여야 되는 경우
  - 각 테이블 간 관계 설정
  - 관계를 맺어야 하는 순서 결정
- 주의사항
  - 한 번에 모든 관계를 설정하지 말고, 논리적으로 하나씩 구현한다. 
    - 기준 테이블과 가장 가까운 관계를 갖는 테이블부터, 하나씩 늘려나가며 작성한다. 