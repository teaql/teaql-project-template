package com.yourcompany.logservice;

import io.teaql.data.TQLContext;
import io.teaql.data.UserContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnsureModelController {
    @GetMapping(value = "/version/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String version(){
        return "V1.0.0";
    }
    @GetMapping(value = "/contextInfo/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String contextInfo(@TQLContext UserContext ctx){
        return "You are from ip: "+ ctx.getClientIp() +", you are from local? " + ctx.isFromLocalhost() ;
    }






}
