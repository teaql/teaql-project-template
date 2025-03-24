package com.yourcompany.logservice;

import io.teaql.data.TQLContext;
import io.teaql.data.UserContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleControler {
    @GetMapping(value = "/platformName/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String platformName(@TQLContext UserContext ctx){
        return Q.platforms()

                .rawSql("select 1 as id, to_char(1+1, '9999') as name")
                //.selectName("concat(name,'-加入后缀')")

                .execute(ctx).getName();
    }
}
