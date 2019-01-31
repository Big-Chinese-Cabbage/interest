package com.interest;

import org.junit.Test;

public class OtherTest {

    @Test
    public void test001(){
        StringBuilder rulBuilder = new StringBuilder("https://thirdqq.qlogo.cn/qqapp/101512648/EAF0A6314B4851164A7F735DB6E9CDD5/40");

        if (rulBuilder.indexOf("https") < 0) {
            rulBuilder.insert(4, "s");

        }
        System.out.println(rulBuilder.toString());
    }

    @Test
    public void testPassword(){

    }

}
