package com.interest.annotation.handler;

import com.interest.WhSpringBootApplicationTests;
import com.interest.annotation.InterestLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterestLogAspectTest {

    @InterestLog
    @Test
    public void printLog() {
        System.out.println("log test.");
    }
}