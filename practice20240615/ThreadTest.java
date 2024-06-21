package practice20240615;

import java.util.concurrent.*;

public class ThreadTest extends Thread{
    //创建一个公共锁对象
    private static final Object Lock = new Object();
    //执行线程数
    private static final int THREAD_COUNT = 3;

    //打印数字的起始点
    private static volatile int START = 0;

    //打印数字的结束点
    private static final int END = 100;

    private static class Print extends Thread{
        private final int index;

        public Print(int index){
            this.index = index;
        }


        @Override
        public void run() {
            while(START<END){
                synchronized (Lock){
                    //START和线程数进行取余，如果不等于当前线程的则等待
                    while(START % THREAD_COUNT != index){
                        try{
                            Lock.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    //否则进行输出
                    if(START<=END){
                        System.out.println("Thread" + (index+1) +  ",打印结果：" + START);
                    }
                    START++;
                    //唤醒等待线程
                    Lock.notifyAll();
                }
            }
        }

        public static void main(String[] args) {
            for(int i = 0; i < THREAD_COUNT; i++){
                new Print(i).start();
            }
        }
    }

}
