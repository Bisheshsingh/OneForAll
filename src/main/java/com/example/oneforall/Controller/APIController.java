package com.example.oneforall.Controller;

import com.example.oneforall.Config.AppConfig;
import com.example.oneforall.Constants.Enums;
import com.example.oneforall.Models.APIRequest;
import com.example.oneforall.Models.APIResponse;
import com.example.oneforall.Models.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {
    private Service getService(final String serviceName) {
        final ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        return (Service) context.getBean(serviceName);
    }
    @GetMapping(path="/service/{serviceName}")
    public APIResponse calculate(@MatrixVariable MultiValueMap<String, String> request,
                                 @PathVariable String serviceName) {

        try {
            return getService(serviceName).initialize(APIRequest.builder()
                    .serviceName(serviceName)
                    .input(request.toSingleValueMap()).build());
        } catch (Exception e) {
            String message = String
                    .format("No service exists with %s name\n", serviceName);
            message += String.format("errorMessage : %s", e.getMessage());

            return APIResponse.builder()
                    .status(Enums.Status.BAD.getCode())
                    .message(message)
                    .build();
        }
    }
}
