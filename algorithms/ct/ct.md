## Computational Thinkings

### Abstract

- 탐욕 기법(Greedy)
- 완전 탐색(Brute-force)
- 백 트래킹(Back-tracking)
- 분할 정복(Divide & Conquer)
- 동적 계획법(Dynamic Programming)

---

### 명제와 논리

- Pseudo proposition
  - p -> q에서, p가 거짓일 경우 명제는 항상 참이 된다. 
- 대우 명제
  - p -> q가 참일 경우, ~q -> ~p는 항상 참이 된다. 

---

### 수치 해석

- 중간값 정리

  ```pseudocode
  function f(x, n):
  	return x*x - n;
  
  function sqrt(n):
  	l = 0;
  	r = n;
  	
  	while (l-r > 0.000001):
  		mid = (l + r) / 2;
  		if (f(mid)*f(r) < 0):
  			l = mid;
  		else if (f(l)*f(mid) < 0):
  			r = mid;
  			
  	return mid;
  ```

---

### 수와 표현

- 에라토스테네스의 체
  - $n \in N$에 대하여, $n^2$까지의 소수를 $1 \sim n$ 까지의 소수의 배수를 제거하여 구할 수 있다. 
- 소인수
- 유클리드 호제법
- 진수
- 베주 항등식
  - $GCD(x, y) = d \Leftrightarrow$
  - $\exists s, t \in \mathbb{Z}$
  - $ s \cdot x + t \cdot y = d$
- 피보나치 수열
  - $f_{2n+1} = f_{n}^{2} + f_{n+1}^{2}$
  - $f_{2n} = f_{n} \cdot (2 \cdot f_{n+1} - f_{n})$
- 페르마 소정리
  - $a^p \equiv a\ (mod\ p)$
  - $a^{p-1} \equiv 1\ (mod\ p)$
  - $a^{p-2} \equiv 1 \div a\ (mod\ p)$
  - $p \in \mathbb{P}$
- 중국인의 나머지 정리
- 오일러 정리
- 벡터
- 카탈란 수열
  - $C_{n} = \Sigma_{i=0}^{i=n-1} C_i \cdot C_{n-1-i}$
  - $C_0 = 1, C_1 = 1$
- 이항 계수
  - 뤼카 정리
    - $\left( \begin{array}{cols} n \\ r \end{array} \right) \equiv \Pi_{i=0}^{i=k} \left( \begin{array}{cols} n_i \\ r_i \end{array} \right)\ (mod\ p)$
    - $n = n_{0} \cdot p^{0} + \cdots + n_{k} \cdot p^{k}$
    - $r = r_{0} \cdot p^{0} + \cdots + r_{k} \cdot p^{k}$
      - $n \lt r$ 일 경우 이항 계수는 0이 된다. 
- 함수
  - 정의역 / 공역 / 치역
  - 전사 / 단사 / 전단사 함수
  - 전사 함수의 개수
    - 정의역: m개 / 치역: n개
      - $\Sigma_{k=0}^{n} (-1)^{k} \cdot _nC_k \cdot (n-k)^m$
- 수열
  - 등차
    - $\forall n \in \mathbb{N}, a_{n+1} - a_{n} = d$
    - $S_{n} = a_{1} \cdot n + \cfrac{n \cdot (n-1)}{2} \cdot d$
  - 등비
    - $\forall n \in \mathbb{N}, \exists r \in \mathbb{Q}, a_{n+1} \div a_{n} = r$
    - $S_{n} = a_{1} \cdot (\cfrac{r^{n}-1}{r-1})$
  - 계차
    - $\forall n \in \mathbb{N}, a_{n+1} - a_{n} = b_{n}$
    - ${\sf s.t.}\ \exists d \in \mathbb{Z}, b_{n+1} - b_{n} = d$
    - $a_{n} = a_{1} + \Sigma_{i=0}^{i-n-1} b_{i}$
- 특성 방정식
  - $a_{n+2} - \alpha \cdot a_{n+1} = \beta \cdot (a_{n+1} - \alpha \cdot a_{n}) = \beta^{n+1} (a_1 - \alpha \cdot a_0) \cdots (1)$
  - $a_{n+2} - \beta \cdot a_{n+1} = \alpha \cdot (a_{n+1} - \beta \cdot a_{n}) = \alpha^{n+1} (a_1 - \beta \cdot a_0) \cdots (2)$
  - $(\alpha - \beta) \cdot a_{n+1} = \alpha^{n+1} \cdot (a_1 - \beta \cdot a_0) - \beta^{n+1} \cdot (a_1 - \alpha \cdot a_0) \cdots (2) - (1)$
    - 마지막 식을 통해, $a_n$의 일반항을 구할 수 있다. 
- 위상 정렬(TP; Topological Sort)