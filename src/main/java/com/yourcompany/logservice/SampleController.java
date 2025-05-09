package com.yourcompany.logservice;

import com.yourcompany.logservice.platform.Platform;
import io.teaql.data.TQLContext;
import io.teaql.data.UserContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping(value = "/platformName/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String platformName(@TQLContext UserContext ctx){
        return Q.platforms()
                .rawSql("select 1 as id, to_char(1+1, '9') as name")
                .selectName("concat(name,'-add-a-suffix')")
                .execute(ctx).getName();
    }

    @GetMapping(value = "/platform/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Platform platform(@TQLContext UserContext ctx){
        return Q.platforms()
                //.rawSql("select 1 as id, to_char(1+1, '9') as name")
                .selectName("concat(name,'--add-a-suffix')")
                .execute(ctx);
    }
}
