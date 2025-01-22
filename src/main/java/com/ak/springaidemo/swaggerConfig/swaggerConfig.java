//package com.ak.springaidemo.swaggerConfig;
//
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * The type Swagger config.
// */
//public class swaggerConfig {
//
//
//    /**
//     * The type Open api config.
//     */
//    @Configuration
//    public class OpenApiConfig {
//
//        /**
//         * Payment api grouped open api.
//         *
//         * @return the grouped open api
//         */
//        @Bean
//        public GroupedOpenApi aiApi() {
//            return GroupedOpenApi.builder()
//                    .group("aijava-api")
//                    .pathsToMatch("/api/**")
//                    .build();
//        }
//    }
//
//}
//
//
//
