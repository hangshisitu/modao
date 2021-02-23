package io.nocode.test;

import io.nocode.GrayRobot;
import org.junit.Assert;
import org.junit.Test;


public class TestGrayRobot {

    @Test
    public void Test() throws InterruptedException {
        GrayRobot grayRobot = new GrayRobot(100,60);

        Assert.assertEquals(true,grayRobot.isGrayKey(1L));
        Assert.assertEquals(false,grayRobot.isGrayKey(11L));
        Assert.assertEquals(true,grayRobot.isGrayKey(101L));
        Assert.assertEquals(true,grayRobot.isGrayKey(1001L));
        Assert.assertEquals(true,grayRobot.isGrayKey(0L));
        Assert.assertEquals(false,grayRobot.isGrayKey(10L));
        Assert.assertEquals(true,grayRobot.isGrayKey(100L));
        Assert.assertEquals(true,grayRobot.isGrayKey(1000L));
        Assert.assertEquals(false,grayRobot.isGrayKey(2L));
        Assert.assertEquals(false,grayRobot.isGrayKey(12L));
        Assert.assertEquals(false,grayRobot.isGrayKey(102L));
        Assert.assertEquals(false,grayRobot.isGrayKey(1002L));
        Thread.sleep(60*1000);
        Assert.assertEquals(true,grayRobot.isGrayKey(2L));
        Assert.assertEquals(false,grayRobot.isGrayKey(12L));
        Assert.assertEquals(true,grayRobot.isGrayKey(102L));
        Assert.assertEquals(true,grayRobot.isGrayKey(1002L));
        Assert.assertEquals(true,grayRobot.isGrayKey(101L));
    }

    @Test
    public void TestFibonacci()
    {
        int[] fibonacci =  GrayRobot.Fibonacci.genFibonacci(1,2,500);
        System.out.println("ok");
    }

}
