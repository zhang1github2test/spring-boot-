package com.imooc.security.demo.service.impl;

import com.imooc.security.demo.service.IAsyncTaskService;
import org.springframework.scheduling.annotation.Async;

/**
 * zhshl  2018/9/16
 */
public class AsyncTaskServiceImpl implements IAsyncTaskService {
    @Override
    @Async
    public void executorAsncTask(String string, String name, String user) throws InterruptedException {
            Thread.sleep(10000L);
    }
}
