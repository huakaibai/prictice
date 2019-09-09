package com.watchdata.effectivejava.ten;

import com.watchdata.effectivejava.four.ForwardingSet;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhibin.wang
 * @create 2019-07-17 15:35
 * @desc
 **/
public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> s) {
        super(s);
    }


    private final List<SetObserver<E>> observers = new ArrayList<>();  // 这个可以使用
    // CopyOnWriteArrayList 并发列表，这样后面的操作都不用加锁了 内部使用可重入锁


    public void addObserver(SetObserver<E> observer){
        synchronized (observers){
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer){
        synchronized (observers){
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element){

/*        synchronized (observers){
            System.out.println("observers size="+observers.size());
            for (SetObserver<E> ob : observers){
                ob.added(this,element);
            }
        }*/

        List<SetObserver> snapShort = null;
        synchronized (observers){
            snapShort = new ArrayList<>(observers);
        }
        for (SetObserver<E> observer: snapShort
             ) {
            observer.added(this,element); // 虽然observers中数据被删除了，但是由于snapshort是被遍历,
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if (added){
            notifyElementAdded(e);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E e:c
             ) {
            result |= add(e);
        }
        return result;
    }

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet(new HashSet<Integer>());
/*        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet set, Integer element) {
                System.out.println(element);
                if ( element  == 23)
                    set.removeObserver(this);
            }
        }); 这样删除会曝出异常，相当于是在for 循环中删除List 中的元素*/


        // 之所以打到23 就停止运行了，是因为观察者只有一个，运行到23 观察者就从set中移除了，所以 added 方法也不会被执行了
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {

                if (element == 23){
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    final SetObserver<Integer> observer = this;
                    try {
                        executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                set.removeObserver(observer); // 观察者没有理由使用后台线程，这个应该是指观察者
                            }
                        }); //.get()
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        executor.shutdown();
                    }
                }
                System.out.println(element);
            }
        });


        for (int i = 0;i < 100;i++){
            set.add(i);
        }
    }
}
