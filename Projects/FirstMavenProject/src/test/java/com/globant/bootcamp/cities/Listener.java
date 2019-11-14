package com.globant.bootcamp.cities;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;


public class Listener implements ITestListener {

    @Override
    public void onFinish(ITestContext result)
    {

    }
    @Override
    public void onStart(ITestContext result){


    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){

    }
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Caso fallado:"+result.getName());
    }
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Case initiated:"+result.getName());

    }


    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }
}
