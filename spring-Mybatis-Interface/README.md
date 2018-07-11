# Spring-Mybatis-Interface



  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>

      <plugin>
        <groupId>com.mysema.maven</groupId>
        <artifactId>apt-maven-plugin</artifactId>
        <version>1.1.3</version>
        <executions>
          <execution>
            <goals>
              <goal>process</goal>
            </goals>
            <configuration>
              <outputDirectory>target/generatedsources/java</outputDirectory>
              <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
            </configuration>
          </execution>
        </executions>
      </plugin>

    </plugins>
  </build>

실행 
mvn generate-sources



insert into board values  (null,null,'content1','title1','dbdyd1');

insert into board values  (null,null,'content2','title2','dbdyd2');

insert into board values  (null,null,'content3','title3','dbdyd3');



insert into comment(cmt_id,cmt_text,user_name,BBS_ID) values (null,'comment1','gil1',1);

insert into comment(cmt_id,cmt_text,user_name,BBS_ID) values (null,'comment3','gil1',1);

insert into comment(cmt_id,cmt_text,user_name,BBS_ID) values (null,'comment2','gil1',1);


<img src="https://github.com/dragonfly95/Spring-Mybatis-Interface/blob/master/%EA%B7%B8%EB%A6%BC12.png" alt="그림">
ㅊ
