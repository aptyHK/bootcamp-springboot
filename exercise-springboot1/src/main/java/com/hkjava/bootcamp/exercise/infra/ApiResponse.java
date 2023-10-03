package com.hkjava.bootcamp.exercise.infra;

import javax.management.RuntimeErrorException;

// @Builder // TBC.
public class ApiResponse<T> { // Why T? Because you won't know what kind of data want to tranfer
    // ApiResponse = this is a self written library that design to manage the api response in the whole company
    // attribute name by default same as JSON field name after serialization

    private int code;
    private String message;
    private T data; // put T

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    private ApiResponse(ApiResponseBuilder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }


    // a static method can put on any class, so the <T> may not relate to the T as the state of ApiResponse class
    // so need to specify the range
    public static <T> ApiResponseBuilder<T> builder() {
        return new ApiResponseBuilder<>();
    }

    // you don't want the result come as freeflow, so you would already plan
    // what result would come by which code
    // may use map, but best is use enum
    // so would create a enum class "Code"

    public static class ApiResponseBuilder<T> {
        private int code;
        private String message;
        private T data; // put T

        public ApiResponseBuilder<T> status(Code code) {
            this.code = code.getCode();
            this.message = code.getDesc();
            return this;
        }

        public ApiResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResponseBuilder<T> ok() {
            this.code = Code.OK.getCode();
            this.message = Code.OK.getDesc();
            return this;
          }

        public ApiResponse<T> build() {
            if (this.code == 0 || this.message == null)
                throw new RuntimeException();
            return new ApiResponse<>(this);
        }
    }
}

// {
//     "code" :200,
//     "message" : "OK",
//     "error" : [

//     ],
//     "error" : [
//         "", ""
//     ],
// }
