@Controller + @ ResponseBody (@RestController)
- Bean + Web Layer
@Service
- Bean
@Repository (JPA + Hibernate)
- Define Entity (with @Id)
- Bean
- JPA includes basic CRUD operations
- method name rules for Hibernate generating implementions
- @Query -> JPQL (Entity) or Native SQL
- nativeQuery = True
- Isolate the Database implementation and Hibernate (MySQL, Oracle)
- Entity @Id, strategy = GenerationType.IDENTITY is for auto-increment, but Oracle do not have auto-increment, so if you use oracle database, cannot use GenerationType.IDENTITY
@Configuration
- @Bean (Method Annotation) -> Create Bean by Method
What is Dependency Injection (DI)?
- @Autowired
    - field injection (@Autowired on a field)
    - constructor injection (@Autowired on a constructor)
- Controller depends on Service (because controller autowired service)
- AppConfig class depends on yml (for example, it used @Value)
What is IoC (Inversion of Control)
- Java: use new keyword to create object. You are the only one to control the relationship between objects.
Spring or Spring Boot: Application Context plays a role of managing the dependency betweens objects. It complains during the server starts if it found any missing dependency.
RestTemplate
- getForObject
- UriComponentsBuilder (with yml, @Value)
- Define the return type (Object or Array)
model class (DTO)
- lombok
- ModelMapper
- mapper class
@Scheduled
- @FixRated, @FixDelay, @Scheduled (cron = ?)
CommandLineRunner (Inteface)
- @Component
- implements run method
- this methodd will be executed during server start
- Server start will fall if the run method fail
ApiResponse<T>
- generics of data
Custom Exception class (extends Exception.class)
- BusinessException
GlobalExceptionHandler
- @ControllerAdvise (@RestControllerAdvise)
- @ExceptionHandler (method)
- Catch from child to parent (includes runtime, checked exception)
DTO
- Deserialization (Controller RequestBody: from JSON to Object)
- Serialization (Controller ResponseBody: from Object to JSON)
- ObjectMapper (test code)
test code
- By Environment & Layer
    - @Test, @SpringBootTest
    - Web Layer
        - @WebMvcTest (@Controller Only)
        - @MockBean for Service (Controller Autowired Service)
        - Mockito, when -> thenReturn for MockBean's method
        - mockMvc.perform() -> test JSON structure
        - verify if service layer being called
    - Service Layer
        - @SpringBootTest
        - @MockBean for Repository (Service autowired Repository)
        - Mockito, when & thenReturn for MockBean's method
        - @Mock, @InjectMock -> mock normal java class & method
        - Hamcrest (assertThat)
    - Repository Layer
        - @DataJpaLayer
        - Autowired TestEntityManager
        - Autowired repository
        - TestEntityManager.persist()
        - repository.save(), findById() -> test Hibernate

        - The point of encapsulation is: lower the complexity to use but keep as much common usage as possible 

        - question need to solve: grpc vs RestTemplate