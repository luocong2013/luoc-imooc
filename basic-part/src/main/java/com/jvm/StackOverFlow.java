package com.jvm;

/**
 * @author luoc
 * @version V1.0.0
 * @description Java栈溢出
 * @VM args: -Xss128K
 * @date 2018/9/10 22:52
 */
public class StackOverFlow {

    private int i;

    public void plus() {
        i++;
        plus();
    }

    public static void main(String[] args) {
        StackOverFlow stackOverFlow = new StackOverFlow();
        try {
            stackOverFlow.plus();
        } catch (Exception e) {
            System.out.println("Exception:stack length: " + stackOverFlow.i);
            e.printStackTrace();
        } catch (Error e) {
            System.out.println("Error:stack length: " + stackOverFlow.i);
            e.printStackTrace();
        }
    }
}
