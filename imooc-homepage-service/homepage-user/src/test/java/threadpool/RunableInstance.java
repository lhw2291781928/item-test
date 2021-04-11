package threadpool;



/**
 * <h2>线程实现1</h2>
 */

public class RunableInstance implements Runnable{



    @Override
    public void run() {
        System.out.println("我是线程实现1");
    }
}
