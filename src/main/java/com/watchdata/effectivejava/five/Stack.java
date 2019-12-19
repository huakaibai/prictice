package com.watchdata.effectivejava.five;



import java.util.*;

/**
 * @author zhibin.wang
 * @desc 泛型栈
 * 所有的comparable 和comparator 都是消费者
 *
 **/
public class Stack<E> {

    //   private Object[] elments;

    private E[] elments;

    private final  static int DEFAULT_INITAL_CAPACITY = 16;

    private int size = 0;
    @SuppressWarnings("unchecked")
    public Stack() {
        // this.elments = new E[DEFAULT_INITAL_CAPACITY]; // 这里会提示创建泛型数组错误

      this.elments = (E[])new Object[DEFAULT_INITAL_CAPACITY];

        // this.elments = new Object[DEFAULT_INITAL_CAPACITY];
    }


    public void push(E o){
        elments[size++] = o;

    }


    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E o = (E) elments[--size];
        elments[size] = null;
        return o;
    }


    public boolean isEmpty(){
        if (size > 0)
            return  false;

        return true;
    }

    //Iterable<? extends  E>    传递参数为E的子类，包括他本身 生产者使用这个
    public void pushAll(Iterable<? extends  E>   es){
        for (E e:
            es) {
            push(e);
        }
    }

    //Collection<? super  E> c传递的参数为E的超类，包括它本身 消费者使用这个
    public void popAll(Collection<? super  E> list){
        while(! isEmpty()){
            list.add(pop());
        }

    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack();

        stack.push("1");
        stack.push("b");
        while (! stack.isEmpty()){
            System.out.println(stack.pop().toUpperCase());
        }


        Stack<Number> stack1 = new Stack<>();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        Iterable<Integer> iterable =integerList;

        stack1.pushAll(iterable);


        List<Object> objects = new ArrayList<>();
        stack1.popAll(objects);
        System.out.println("size = " + objects.size());

    }



}
