package LeetCodeUtils.Experience.container;

import LeetCodeUtils.Experience.Utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class Container {

    private static Logger logger = LoggerFactory.getLogger(Container.class);

    public static Map<String, Object> container = new ConcurrentHashMap<>();

    public Container() {
        start();
    }

    private void start() {
        logger.info("starting the container...");
        init();
        logger.info("finished the initialization...");
        blocking();
    }

    public void init() {
        loadBeans();
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder(System.getProperty("user.dir"));
        sb.append("/src/main/java/");
        return sb.toString();
    }

    public void loadBeans() {
        FileUtils.scanAllFiles(container);
    }

    public void blocking() {
        // after init()
        new Thread(() -> {
            try {
                new CountDownLatch(1).await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "a").start();
    }

    public Object getBean(String name) {
        return container.getOrDefault(name, new Object());
    }

    public Map<String, Object> getContext() {
        return container;
    }
}
