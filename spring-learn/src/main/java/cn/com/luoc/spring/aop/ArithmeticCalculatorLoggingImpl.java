package cn.com.luoc.spring.aop;

/**
 * @author luoc
 * @version V1.0.0
 * @date 2018/2/12 15:09
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        System.out.println("The method add begins with [" + i + "," + j + "]");
        int result = i + j;
        System.out.println("The method add ends with " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("The method sub begins with [" + i + "," + j + "]");
        int result = i - j;
        System.out.println("The method sub ends with " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("The method mul begins with [" + i + "," + j + "]");
        int result = i * j;
        System.out.println("The method mul ends with " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("The method div begins with [" + i + "," + j + "]");
        int result = i / j;
        System.out.println("The method div ends with " + result);
        return result;
    }
}
