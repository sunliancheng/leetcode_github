package LeetCodeUtils.Experience.test;

import LeetCodeUtils.Experience.sortBean.BubbleSort;
import LeetCodeUtils.Experience.container.Container;

public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        Container ioc = new Container();
        BubbleSort bean1 = (BubbleSort) ioc.getBean("bubbleSort");

    }
}
