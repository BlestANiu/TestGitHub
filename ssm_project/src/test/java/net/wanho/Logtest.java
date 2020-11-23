package net.wanho;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Logtest {


    @Test
    public void test(){
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
