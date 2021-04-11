package normal;

/**
 * Create by lhw on 2021/2/14
 */
public class Dog extends Animal{

    /**
     * 结论： 子类可以继承父类的静态资源，但是不能重写父类的静态资源
     * @param args
     */
    public static void main(String[] args) {
        new Dog().run("狗");
        run();
    }
}


