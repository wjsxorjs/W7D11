package com.sist.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevTestController {
    @Value("${global.siteName}")
    private String siteName;

    @GetMapping
    public String test(){
        return siteName;
    }


}
