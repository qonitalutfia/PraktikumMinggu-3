package com.juaracoding.test.listeners;

import com.juaracoding.test.DriverSingleton;
import org.testng.IExecutionListener;

public class Hook implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.err.println("TestNG is commencing execution");
        DriverSingleton.createOrGetDriver();
    }

    @Override
    public void onExecutionFinish() {
        System.err.println("TestNG is finished execution");
        DriverSingleton.quitDriver();
    }
}
