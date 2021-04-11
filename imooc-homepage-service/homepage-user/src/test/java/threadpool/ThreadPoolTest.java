package threadpool;


import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <h2>线程池 练习</h2>
 */
public class ThreadPoolTest {


    private static final RunableInstance RUNNABLE_INSTANCE = new RunableInstance();

    private static final RunableInstance2 RUNNABLE_INSTANCE_2 = new RunableInstance2();

    private static final Executor SINGLE_THREAD = Executors.newSingleThreadExecutor();




    @Test
    public void test01(){

        Thread currentThread = Thread.currentThread();
        SINGLE_THREAD.execute(RUNNABLE_INSTANCE);
        SINGLE_THREAD.execute(RUNNABLE_INSTANCE_2);
        currentThread.interrupt();


    }
}
