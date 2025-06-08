헥사고날 아키텍처(Hexagonal Architecture, 또는 포트와 어댑터 아키텍처)는 **비즈니스 로직을 외부 환경으로부터 분리**하여 유연하고 테스트하기 쉬운 구조를 만드는 데 목적이 있습니다. 이 아키텍처는 다음과 같은 디렉토리 구조로 설계하는 것이 일반적입니다.

---

### ✅ 기본 디렉토리 구조 (Java/Spring 기반 예시)

```
src
└── main
    └── java
        └── com.example.myapp
            ├── domain
            │   ├── model
            │   ├── service
            │   └── port
            │       ├── in
            │       └── out
            ├── application
            │   └── service
            ├── adapter
            │   ├── in
            │   │   ├── web   (e.g. REST controller)
            │   │   └── batch / messaging / grpc 등
            │   └── out
            │       ├── persistence (e.g. JPA, MyBatis)
            │       └── external (e.g. 외부 API, SMTP)
            └── config
                └── (Spring 설정, Bean 등록 등)
```

---

### 📌 디렉토리별 설명

#### 1. `domain`

* **비즈니스 로직의 핵심**
* 외부와 완전히 분리되어야 하며, 순수 자바 코드로 작성되어야 합니다.

    * `model`: Entity, Value Object 등 도메인 모델
    * `service`: 도메인 서비스 (도메인 로직이 여러 객체에 걸칠 때)
    * `port.in`: 외부에서 도메인 계층을 호출하기 위한 인터페이스 (UseCase)
    * `port.out`: 도메인이 외부 의존성을 호출하기 위한 인터페이스 (Persistence, API 호출 등)

#### 2. `application`

* **도메인과 어댑터 사이의 서비스 계층**
* UseCase 구현체가 들어가며 트랜잭션 처리, 흐름 제어 등을 담당

#### 3. `adapter`

* **실제 외부와의 입출력을 담당**

    * `in`: 사용자의 입력을 도메인으로 연결하는 어댑터 (예: Web Controller, Kafka Consumer 등)
    * `out`: 도메인의 `port.out` 인터페이스를 구현하는 어댑터 (예: JPA Repository, 외부 API 클라이언트 등)

#### 4. `config`

* 스프링 설정, 의존성 주입 설정 등을 담당하는 계층 (e.g. Bean 등록, @Configuration)

---

### 🎯 예시 흐름

> 사용자가 웹 요청을 보내는 경우

1. `adapter.in.web.MyController`가 요청 수신
2. `application.service.MyUseCaseImpl` 호출
3. `domain.service.MyDomainService`가 핵심 로직 처리
4. 필요한 경우 `port.out.MyRepository` 인터페이스 호출
5. `adapter.out.persistence.MyJpaRepository`에서 DB 처리

---

### ✅ 정리

| 계층            | 역할           | 외부 의존성 |
| ------------- | ------------ | ------ |
| `domain`      | 핵심 비즈니스 로직   | ❌ 없음   |
| `application` | 유스케이스, 흐름 제어 | ⭕      |

\| `adapter`   | 입출력 구현체 (Web, DB, API 등)   | ✅ 있음       |

---
