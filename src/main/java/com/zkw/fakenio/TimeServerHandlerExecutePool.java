package com.zkw.fakenio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/2 0002.
 */
public class TimeServerHandlerExecutePool {
    private ExecutorService exe;

    public TimeServerHandlerExecutePool(int maxSize, int queueSize) {
        exe = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable task){
        exe.execute(task);
    }
}
