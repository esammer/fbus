package com.cloudera.fbus.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/fbus.xml")
public class ApplicationTest {

  private static final Logger logger = LoggerFactory
      .getLogger(ApplicationTest.class);

  @Test
  public void testApplication() throws InterruptedException, IOException {
    logger.debug("Application bootstrapped");

    File f = File.createTempFile("test", String.valueOf(System
        .currentTimeMillis()), new File(
        "/Users/esammer/Documents/Code/com.cloudera.fbus/import"));

    Thread.sleep(20000);
  }

}
