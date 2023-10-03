framework folder = write your own library
Usually after a library written if can copy to another project and let them use 
So I should able to copy this folder directly for my final project to use

library should not use annotation
a ground level program better not have any dependency

##
#### 18 Sep
- enum (Code.java, ApiResponse.java)
- BusinessException, JPHException
- Mapper Logic (UserMapper.java, used convert from User -> UserDTO)
- @WebMvcTest -> Autowired MockMvc -> @MockBean
- @SpringBootTest (Complete SB environment, full context)
- ResponseEntity (because sometimes we have to return non-200 status)
- GlobalExceptionHandler(ControllerAdvice)