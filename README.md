mvn clean -> clear "target" folder
mvn compile -> compile java classes to .class (byte code) in target
mvn test -> (include compile), run all test cases
mvn package -> (include compile +test ), generate jar in target folder
mvn install ->(include compile + test+package), copy jar to .m2 folder(local reposityor)

Maven Spring Boot Project:
// install到......先黎到呢一步
mvn spring-boot:run -> Start up App Server(Web+App) ()
  Step 1: @SpringbootApplication (佢成個Project搵呢個annoation)( this file should be located
  at root directory(最出面))

  Step 2: @ComponentScan -> Find java class that annotated by 
  @Component(@Controller,@Service,@Reposityory,@Configuration) (Scan曬所有呢D的class)
  For example, Acontroller.class, Bservice.class (佢搵到兩個class)

  Step 3: New objects for Acontroller.class & Bservice.class, put them into
  the SpringContext 
  Step 3.1: Acontroller.class depends on Bservice.class(Because you @Autowird
  Bservice.class into Acontroller.class)
  Step 3.2: So, it will new Bservice.class first.
  Step 3.3: It will find the object of Bservice from SpringContext in order to 
  create the new object of Acontroller. 
  (3.3 有機會失敗 如果你沒有@service)
  (inject Bservice object into Acontroller object)
  (Bean mean the object in spring context, unique like enum object)
  (Bean should have no field)
