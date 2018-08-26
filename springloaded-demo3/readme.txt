
context -
컴퓨터 자원 (탐캣)

context 추가
web.xml -> spring-context.xml -> spring MVC
spring MVC
ㅡㅡㅡㅡ
Controller -
(url 처리 - request / response, validate check,)

Service  -
method interface 구현
비지니스구현
트랜잭션 처리

DAO (Mapper/ Repository)
쿼리 날리는 역할
mybatis (library) - interface 로 만든다
jdbc연결 -> db connection -> sql 실행 -> 결과값 가져옴 -> dao에 리턴 해줌.

Model
내용을 담는 그릇

View (Jsp)
jstl, spring el, jsp

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

url 기준
filter / interceptor / AOP
filter - web.xml 단계
interceptor - spring-context 단계
AOP - spring MVC 단계


thread-safe
인터넷 찾아서 보세요.




스프링은 객체를 관리 (빈관리 해줌)
@Autowired
개발자가 new BoardController() 하면 안됨. X
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
spring COC
설정보다 관례 (xml 설정이 간소화)
component-scan
mybatis-scan

table 이름이 `board`
BoardController.java
BoardService.java
BoardMapper.java
Board.xml
메소드는 CRUD (1건조회/목록조회(검색조건)/입력/수정/삭제)

table 이름이 `comment`

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
ORM - JPA, Hibernate .....
(Object Relation Mapping)
sql X

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
메이븐 프로젝트
jar 관리자 (라이브러리) - http://mvnrepostory.com
gradle

nodejs - npm
python -
php - composer
javascript - bower

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
jRebel - 클래스 변경시 자동리로드 (서버재부팅 필요없음)



intellij 단축키
ctrl + shift + R -> 파일명으로 찾기
오류발생시 해결 intellij -- 오류나는 곳에 커서 후 alt + enter
한줄 지우기 ctrl + x
주석처리 ctrl + /
한줄 아래로 이동 alt + 방향키 위/아래

vs code
파일찾기 ctrl + p
단어선택 ctrl + d
다음단어 선택 ctrl + d + d
한줄지우기 ctrl + x
주석처리 ctrl + /
현재줄 커수 추가 - 블럭후 ctrl + shift + L
한줄 아래로 이동 ctrl + shift + 방향키 위/아래


ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
영어 공부 (유부트)
운배영 - https://www.youtube.com/channel/UCgaz7WOHwJhjdcSAvN5R8ag


프로그램 공부 (유투브/github.com)
octree

맥북 - 맥으로 개발
5년이내 제품만 유효
cpu- 기본i5 이상
ram- 8g 이상
hdd- 256 이상
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


java
interface (인터페이스) - 완전 가상 - 선언만 하고 구현은 없음.
abstract (추상클래스) - 반 가상 (반만 구현)
concrete (구현클래스) - 구현

라이브러리 (spring, mybatis, 등등)
잘 쓰려먼? interface 선언을 잘 해야 함.
mybatis - interface로 써야하나는 이유

인터페이스 - 구현클래스
1  :  1- 의미없다.
1  :  N - 의미 있는데 (내가 라이브러리 만들어서 배포하지 않는 이상 사용하지 않다)


@RequestMapping (기본 GET)
method (4가지로 구분)
GET - ?key=value&key1=value1  default
POST - 양식 받을 때 (저장할때)
PUT - 양식 받을 때 (수정)
DELETE - 삭제할 때




    // 한줄주석
    /*
    * 여러줄 주석
    * */

    /**
     * 주석이 아니고 Document
     * @return
     */


install:install-file -Dfile=libs/ojdbc6-11.2.0.3.jar -DgroupId=oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar
install:install-file -Dfile=libs/springloaded-1.2.6.RELEASE.jar -DgroupId=org.springframework -DartifactId=springloaded -Dversion=1.2.6.RELEASE -Dpackaging=jar

-javaagent:/Users/dbdyd/Documents/acts29/app/Demo3/libs/springloaded-1.2.6.RELEASE.jar -noverify

lombok.jar
(getter,setter)
plugin -> lombok 설치,
enable annotation processing 체크 해줘야 함.
jdk10 버전에서는 오류 발생

jRebel plugin 설치



오픈소스 db TOOL ==
dbbeaver (mysql/mssql/oracle) - eclipse 기반 mac가능
heidisql (mysql/mssql) - 윈도우만


