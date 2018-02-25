package cn.com.luoc.spring.bean;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/2/12 14:50
 */
public class HelloWorld {

    private String user;

    public HelloWorld() {
        System.out.println("HelloWorld's constructor...");
    }

    /**
     * JavaBean 使用 setter 和 getter 来定义属性
     */
    public void setUserName(String user) {
        System.out.println("setUserName:" + user);
        this.user = user;
    }

    public void hello() {
        System.out.println("Hello:" + user);
    }

    public void init() {
        System.out.println("init method...");
    }

    public void destroy() {
        System.out.println("destroy method...");
    }
}
