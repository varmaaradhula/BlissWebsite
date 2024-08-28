package Utils;

import PageObjects.PageObjectManager;
import StepDefinitions.Hooks;

import java.io.IOException;

public class TestContextSetUp {
public BaseTest baseTest;
public PageObjectManager pageObjectmanger;
public Utilities utils;
    public TestContextSetUp() throws IOException {
    baseTest=new BaseTest();
    pageObjectmanger = new PageObjectManager(baseTest.webDriverManager());
    utils = new Utilities(baseTest.webDriverManager());
    }

}
