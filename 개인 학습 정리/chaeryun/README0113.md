## 1. 스프링이란?

① 흔히 스프링이라 부르지만 "**스프링 프레임워크(Spring Framework)"**라고 하는 것이 정확한 표현이다.



② 자바(JAVA) 엔터프라이즈 개발을 위한 "**오픈소스(Open Source)"** 애플리케이션 프레임워크(Framework)



 \- Open Source : 소프트웨어(S/w) 혹은 하드웨어의(H/W) 제작자의 권리를 지키면서 원시 코드를 누구나 열람할 수 있도록 한 소프트웨어, 오픈 소스 라이선스에 준하는 모든 통칭을 일컫는다. (소스가 공개되어 여러 개발자가 플랫폼을 함께 개발, 구축, 보완해 나가는 시스템. )



 \- Framework : 개발할 때 설계 기본이 되는 뼈대나 구조 / 환경 (문제 영역을 해결한 재사용, 확장 가능한 라이브러리.)





## 2. 스프링 특징

① **"****경량 컨테이너"**(크기와 부하의 측면)로서 자바 객체를 직접 관리

 \- 각각의 객체 생성, 소멸과 같은 라이프 사이클을 관리하며 스프링으로부터 필요한 객체를 얻어올 수 있다.

 

② **제어 역행**(**IoC** : Inversion of Control)

 \- 애플리케이션의 느슨한 결합을 도모.

 \- 컨트롤의 제어권이 사용자가 아니라 프레임워크에 있어 필요에 따라 스프링에서 사용자의 코드를 호출한다.

 

③ **의존성 주입**(**DI** : Dependency Injection)

 \- 각각의 계층이나 서비스들 간에 의존성이 존재할 경우 프레임워크가 서로 연결시켜준다.



③ **관점지향 프로그래밍**(**AOP** : Aspect-Oriented Programming)

 \- 트랜잭션이나 로깅, 보안과 같이 여러 모듈에서 **공통적으로 사용하는 기능의 경우 해당 기능을 분리**하여 관리할 수 있다.



④ 애플리케이션 객체의 생명 주기와 설정을 포함하고 관리한다는 점에서 일종의 **"****컨테이너"**(Container)라고 할 수 있다.

 \- iBatis, myBatis나 Hibernate 등 완성도가 높은 데이터베이스처리 라이브러리와 연결할 수 있는 인터페이스를 제공한다.

 

⑤ **트랜잭션 관리** 프레임워크

 \- 추상화된 트랜잭션 관리를 지원하며 설정파일(xml, java, property 등)을 이용한 선언적인 방식 및 프로그래밍을 통한 방식을 모두 지원한다.



⑥ **모델-뷰-컨트롤러** 패턴

 \- 웹 프로그램밍 개발 시 거의 표준적인 방식인 **"Spring MVC"**라 불리는 모델-뷰-컨트롤러(MVC) 패턴을 사용한다. 

 \- DispatcherServlet이 Controller 역할을 담당하여 각종 요청을 적절한 서비스에 분산시켜주며 이를 각 서비스들이 처리를 하여 결과를 생성하고 그 결과는 다양한 형식의 View 서비스들로 화면에 표시될 수 있다.



⑦ 배치 프레임워크

 \- 스프링은 특정 시간대에 실행하거나 대용량의 자료를 처리하는데 쓰이는 일괄 처리(Batch Processing)을 지원하는 배치 프레임워크를 제공한다. 기본적으로 스프링 배치는 Quartz 기반으로 동작한다.



⑧ **즉 공통 부분의 소스 코딩이 용이하며 확장성도 매우 높다.**





## 3. 스프링 모듈





① Spring Core

 \- Spring 프레임워크의 근간이 되는요소. IoC(또는 DI) 기능을 지원하는 영역을 담당.

 \- BeanFactory를 기반으로 Bean 클래스들을 제어할 수 있는 기능을 지원



②Spring Context

 \- Spring Core 바로 위에 있으면서 Spring Core에서 지원하는 기능외에 추가적인 기능들과 좀 더 쉬운 개발이 가능하도록 지원

 \- 또한 JNDI, EJB등을 위한 Adaptor들을 포함



③Spring DAO

 \- 지금까지 우리들이 일반적으로 많이 사용해왔던 JDBC 기반하의 DAO개발을 좀 더 쉽고, 일관된 방법으로 개발하는 것이 가능하도록 지원

 \- Spring DAO를 이용할 경우 지금까지 개발하던 DAO보다 적은 코드와 쉬운 방법으로 DAO를 개발하는 것이 가능



④Spring ORM

 \- Object Relation Mapping 프레임워크인 Hibernate, IBatis, JDO와의 결합을 지원하기 위한 기능 

 \- Spring ORM을 이용할 경우 Hibernate, IBatis, JDO 프레임워크와 쉽게 통합하는 것이 가능



⑤Spring AOP

 \- Spring 프레임워크에 Aspect Oriented Programming을 지원하는 기능이다. 이 기능은 AOP Alliance 기반하에서 개발



⑥Spring Web

 \- Web Application 개발에 필요한 Web Application Context와 Multipart Request등의 기능을 지원

 \- 또한 Struts, Webwork와 같은 프레임워크의 통합을 지원하는 부분을 담당



⑦Spring Web MVC

 \- Spring 프레임워크에서 독립적으로 Web UI Layer에 Model-View-Controller를 지원하기 위한 기능



지금까지 Struts, Webwork가 담당했던 기능들을 Spring Web MVC를 이용하여 대체하는 것이 가능하다. 또한 Velocity, Excel, PDF와 같은 다양한 UI 기술들을 사용하기 위한 API를 제공





출처: https://goddaehee.tistory.com/156