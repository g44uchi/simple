package io.openliberty.guides.hello;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;

/**
 * 常駐処理
 */
public class MyCallable implements Callable {

    // 業務常駐処理
    @Override
    public Object call() throws Exception {
        System.out.println("MyCallable call begin");

        long count = 0;
        while (count < 10) {
            try {
                // 5秒スリープ
                TimeUnit.SECONDS.sleep(5);
                System.out.println("MyCallable loop " + count);
                count++;
            } catch (InterruptedException ie) {
                System.out.println("MyCallable WAS停止が呼ばれるとInterruptedException発生する。その前にフラグなどで停止するようにしたほうがよい");
                break;
            }
        }

        System.out.println("MyCallable call end");
        return null;
    }

}
