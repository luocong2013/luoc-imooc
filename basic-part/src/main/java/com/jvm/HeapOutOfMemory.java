package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoc
 * @version V1.0.0
 * @description 堆溢出测试
 * @VM args: -Xms20M -Xmx20M -verbose:gc -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=F:/JVM/dump -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:F:/JVM/heap_trace.txt
 * @date 2018/9/10 22:13
 */
public class HeapOutOfMemory {

    public static void main(String[] args) {
        List<TestCase> cases = new ArrayList<>();
        while (true) {
            cases.add(new TestCase());
        }
    }
}
