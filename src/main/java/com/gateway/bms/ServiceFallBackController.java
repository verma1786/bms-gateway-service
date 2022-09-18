package com.gateway.bms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceFallBackController {

    @RequestMapping(value = "/authenticationService", method = RequestMethod.POST,produces = "application/json")
    public String authenticationService() {
        return "authentication-service is down...";
    }

    @RequestMapping("/communityService")
    public String productService() {
        return "Community Service is down...";
    }


	    

}
