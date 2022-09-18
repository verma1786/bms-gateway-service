package com.gateway.bms;

import com.gateway.bms.config.ApiResponse;
import com.gateway.bms.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ServiceFallBackController {

    @RequestMapping(value = "/userService", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<ApiResponse> userService() {
        ApiResponse apiResponse=null;
        List<String> eList=new ArrayList<>();
        eList.add("User Service is down...");
        apiResponse = ApiResponse.builder()
                .status("ERR0005")
                .message(Constants.ERROR)
                .errors(eList)
                .build();
        log.info("[ServiceFallBackController :userService] : service response");
        return ResponseEntity.ok().body(apiResponse);

    }


}
