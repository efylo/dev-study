## Algorithm

### Abstract

- 사전적 정의
  - 입력으로부터 출력을 만드는 과정을 애매하지 않게 기술
  - [효율성 / 무결성 / 재귀] - 핵심 관점
- 문제의 종류
  - 풀 수 없는 문제들(unsolvable / undecidable)
    - 튜링의 정지 문제, Hilbert의 10번째 문제
  - 풀 수 있는 문제들(solvable / decidable)
    - 현실적인 시간 내에 풀 수 없는 문제들
      - 다항 시간(O(n^p^))을 넘어가는 시간 복잡도를 갖는다. 
      - NP-Complete, NP-Hard, ...
    - 현실적인 시간 내에 풀 수 있는 문제들
      - 다항 시간(O(n^p^)) 안에 표현되는 시간 복잡도를 갖는다. 
      - MST, 최단 경로 문제, ...

---

### Approach

- 알고리즘 설계 기법(5)
  - 완전 탐색(Brute-force)
    - 모든 경우의 수를 탐색하는 기법
  - 탐욕 기법(Greedy)
    - 부분 해가 최적 해임을 가정하고 전체 해를 구하는 기법
  - 백 트래킹(Back-tracking)
    - 모든 경우의 수 중, 불가능한 경우에 대한 탐색을 진행하지 않는 기법
  - 분할 정복(Divide & conquer)
    - 전체 문제를, 동일한 구조의 부분 문제로 분할하여, 정복하며 해를 구하는 기법
  - 동적 계획법(Dynamic programming)
    - Optimal substructure
    - Overlapping recursive calls

---

### Point of view

- 효율성
  - 시간(Time)
  - 공간(Space)
  - 네트워크(Bandwidth)
- 재귀: 내 안에 나를 찾는다. 
  - Recursive calls
  - Relation with the mother problem
  - Base case(for termination)