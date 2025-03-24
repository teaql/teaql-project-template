package com.yourcompany.logservice;

import io.teaql.data.UserContext;

public class CustomUserContext extends UserContext {


    @Override
    public void init(Object request) {
        //this.info("inited");
        super.init(request);
    }

}
