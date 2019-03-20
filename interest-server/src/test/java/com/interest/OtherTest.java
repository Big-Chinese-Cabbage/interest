package com.interest;

import org.junit.Test;

public class OtherTest {

    @Test
    public void test001(){
        StringBuilder rulBuilder = new StringBuilder("https://thirdqq.qlogo.cn/qqapp/101512648/EAF0A6314B4851164A7F735DB6E9CDD5/40");

        rulBuilder.delete(rulBuilder.length()-2,rulBuilder.length());
        rulBuilder.append("100");
        System.out.println(rulBuilder.toString());
    }

    @Test
    public void testPassword(){
        String s = "123456787654231345677654333543232543123123eqwdasdqwe1312123456787654231345677654333543232543123123eqwdasdqwe1312123456787654231345677654333543232543123123eqwdasdqwe1312";
        s = s.substring(0,100);
        System.out.print(s);
    }

}
