package ru.example.sb;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/")
public class AppController {
    @Value("${p1:false}")
    private Boolean p1;

    @RequestMapping("app/app-config.js")
    public void getGitInfo(HttpServletResponse httpServletResponse) throws IOException {
        String json = "{}";

        boolean test = this.p1;

        String str = test ? "c" : "c.min";

        String result = "" +
                "(function(){\n" +
                "       'use strict';\n" +
                "\n" +
                "       requirejs.config({\"paths\": {\"a\": '/scripts/test/a'}}); \n" +
                "       requirejs.config({\"paths\": {\"b\": '/scripts/test/b.min'}}); \n" +
                "       requirejs.config({\"paths\": {\"c\": '/scripts/test/" + str + "'}}); \n" +
                "\n" +
                "})();\n";

        httpServletResponse.setContentType("application/javascript;charset=UTF-8");
        httpServletResponse.getWriter().print(result);
    }


    @GetMapping("/test")
    public String test() {return  "hello test page!"; }

}
