package io.openliberty.guides.hello;

import javax.annotation.Resource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class MyExecutorService {

    @Resource(lookup = "concurrent/myExecutor")
    private ScheduledExecutorService executor;

    /**
     * JVM起動時の初期化処理
     */
    public void handle(@Observes @Initialized(ApplicationScoped.class) Object event) {
        System.out.println("MyExecutorService handle begin " + event);

        // ここで初期化処理を何か実装
        // TODO something to init.

        // 常駐処理の起動処理(5秒後に起動するようにスケジュール)
        executor.schedule(new MyCallable(), 5, TimeUnit.SECONDS);

        System.out.println("MyExecutorService handle end");
    }

}
