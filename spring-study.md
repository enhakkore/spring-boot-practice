>  공부한 책 : [Spring boot in action(한국어판)](https://thebook.io/006859/), [Spring boot in action](https://github.com/Innsmounth/JavaEBooks/blob/master/Spring%20Boot%20in%20Action.pdf)

* @SpringBootTest -> [관련 글1](https://meetup.toast.com/posts/124), [관련 글2](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing)

* SpringRunner is an alias for the SpringJUnit4ClassRunner. -> [관련 글](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/junit4/SpringRunner.html)  

* 스프링으로 개발할 때는 빌드에 추가로 도움을 주는 세부적인 옵션을 사용한다.  
  * 스프링 부트는 그레이들과 메이븐 빌드 플러그인을 제공한다.  
  * 빌드 플러그인의 주 기능은프로젝트를 실행 가능한 우버 JAR로 패키징하는 것이다.  
  이 작업으로 애플리케이션 의존성을 모두 JAR에 패키징하고, java -jar 명령으로 애플리케이션을 실행할 수 있게 하는 엔트리를 담은 매니페스트(Manifest)를 추가한다.  


* 스프링 부트 스타터 의존성  
  * 전이적 의존성으로 단순히 몇 개의 의존성 추가가 개별 라이브러리 수십 개가 빌드에 추가된다.  
  * 어떤 경우에도 버전을 지정할 필요가 없다. 스프링 부트 버전에 따라 자체적으로 결정된다.  


* @Entity를 붙인 클래스는 JPA엔티티

* JpaRepository 인터페이스는 타입 매개변수 두 개를 받는데, 첫 번째는 repository가 사용할 도메인 타입이고, 두 번째는 클래스의 ID 프로퍼티 타입이다.  

* 컴포넌트 검색으로 자동으로 Controller클래스를 빈으로 등록하려면 클래스에 @Controller를 붙인다.  

* RequestMapping 주소에 따라 처리할 수 있는 Controller 클래스를 만들 수 있다.  

* 똑같은 주소라도 GET과 POST 방식에 따라 다른 처리를 할 수 있게 메서드를 구성할 수 있다.  

* 메서드가 반환하는 String의 값으로 모델(org.springframework.ui.Model)을 렌더링할 뷰의 논리적 이름을 반환할 수 있다.  

* 스프링 부트 자동 구성이 스프링을 구성하는 일을 한다.

* `org.springframework.boot:spring-boot-starter-security` 의존성을 추가한 후 애플리케이션을 실행하면 HTTP 기본 인증 대화상자가 나타나는데, username은 user, password는 애플리케이션을 실행하면 출면되는 로그에서 값을 찾아 입력하면 된다.   
```
Using generated security password: 25a41e4a-97de-4db8-a98f-6e1321a15acb
```  

* 스프링 시큐리티 자동 구성을 오버라이드할 때는 WebSecurityConfigureAdapter를 확장해서 구성 클래스를 작성한다. 자동 구성을 오버라이드하는 것을 사용자 정의 보안 구성 클래스를 선언하는 것이라고 하며, 이럴 경우 스프링 부트는 보안 자동 구성을 건너뛴 채 사용자 정의 보안 구성을 사용한다.  

* readerRepository.findOne(username) -> readerRepository.findById(username).get()  

* Spring boot 2 에서는 spring.main.show-banner=false -> spring.main.banner-mode="off"  

* spring error response 기본 구성  
```json
{
  "timestamp": "2019-02-15T21:48:44.447+0000",
  "status": 404,
  "error": "Not Found",
  "message": "No message available",
  "path": "/123"
}
```  
