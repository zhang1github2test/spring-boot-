package com.imooc.security.demo.service;

/**
 * zhshl  2018/9/16
 */
public interface IAsyncTaskService {
    void executorAsncTask(String string, String name, String user) throws InterruptedException;
}
