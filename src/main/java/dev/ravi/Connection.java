package dev.ravi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Connection {


    @GetMapping(path = "/connected")
    public String connected(@RequestParam("origin") String origin,
                             @RequestParam("destination") String destination) {

        log.debug("Request:" + origin +" " + destination);
        return "yes" ;

    }

    @GetMapping(path = {"/", "."})
    public String redirect() {

        return "API available @: /connected?origin=city1&destination=city2";
    }



}
