## SET Operators

### Abstract

- 관계형 데이터베이스 내 하나의 테이블은, 곧 하나의 집합으로써 의미를 갖는다. 
  - Column 타입과 개수가 동일한 두 개의 테이블에는, 집합 연산자를 적용할 수 있다. 
- Operators
  - UNION
    - 두 개의 집합(테이블)을 합친다, 이 때 중복되는 행은 하나로 처리된다. 
  - UNION ALL
    - 두 개의 집합(테이블)을 합친다, 이 때 중복되는 행도 모두 포함한다. 
  - INTERSECT
    - 두 개의 집합(테이블) 중 중복되는 행을 반환한다. MySQL에서는 지원하지 않는다. 
  - MINUS
    - 하나의 집합에서, 나머지 집합과 중복되는 행을 제거하여 반환한다. MySQL에서는 지원하지 않는다. 