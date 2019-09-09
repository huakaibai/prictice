package com.watchdata.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhibin.wang
 * @create 2019-09-03 14:23
 * @desc
 **/
public class TestStream {


    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));

        /**
         * stream filter
         * x -> x.getAge() == 20  过滤条件保留年龄为20的用户
         * 输出结果 [Person(name=jack, age=20)]
         */
        list = list.stream().filter(x -> x.getAge() == 20).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("------------------------");

        /**
         *  distinct()去除重复数据
         *  注意list中对象需要重写equal和hashcode方法
         */
        list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("jack", 20));
        list.add(new Person("tom", 30));

        System.out.println(list);

        List<Person> list1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("----------------");
        //Comparable
        /**
         * sorted 排序
         * sorted() 需要list中的对象实现Comparable接口
         * / sorted((T, T) -> int)
         */
        List<Person> list2 = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list2);

        List<Person> list3 = list.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList());
        System.out.println(list3);


        list.stream().sorted(Comparator.comparingInt(Person::getAge));

        System.out.println("----------------");

        /**
         * limit(long n) 返回前n个数据
         */

       List<Person> list4 = list.stream()
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(list4);
        System.out.println("----------------");

        /**
         * skip(long n) 去除前n个数据
         */
        List<Person>  list5 = list.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(list5);
        System.out.println("----------------");

        /**
         * map(T -> R) 将流中的每一个元素 T 映射为 R（类似类型转换）
         * 这个是将listz person中name转换成单独的list
         */

        List<String> nameList = list.stream().map(Person::getName).collect(Collectors.toList());

        System.out.println(nameList);

        List<String> collect = nameList.stream().map(x -> x + "aa").collect(Collectors.toList());
        System.out.println(collect);


        /** flatMap(T -> Stream<R>)
         *
         * 将流中的每一个元素 T 映射为一个流，再把每一个流连接成为一个流
         */
        System.out.println("----------------");

        List<String> listS = new ArrayList<>();
        listS.add("aaa bbb ccc");
        listS.add("ddd eee fff");
        listS.add("ggg hhh iii");

        List<String[]> collect1 = listS.stream().map(s -> s.split(" ")).collect(Collectors.toList());

        collect1.forEach(strings -> Arrays.asList(strings).forEach(System.out::println));
        System.out.println(collect1);


        /**
         * ，我们的目的是把 List 中每个字符串元素以" "分割开，变成一个新的 List<String>。
         * 首先 map 方法分割每个字符串元素，但此时流的类型为 Stream<String[ ]>，
         * 因为 split 方法返回的是 String[ ] 类型；所以我们需要使用 flatMap 方法，先使用Arrays::stream将每个 String[ ] 元素变成一个 Stream<String> 流，
         * 然后 flatMap 会将每一个流连接成为一个流，最终返回我们需要的 Stream<String>
         */
        List<String> list6 = listS.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());

        System.out.println(list6);


        /**
         * anyMatch(T -> boolean)
         * 流中是否有一个元素匹配给定的 T -> boolean 条件
         */
        boolean b = list.stream().anyMatch(person -> person.getAge() == 20);
        System.out.println(b);

        /**
         * allMatch(T -> boolean)
         * 流中是否所有元素都匹配给定的 T -> boolean 条件
         */

        boolean b1 = list.stream().allMatch(person -> person.getAge() == 20);
        System.out.println(b1);


        /**
         * noneMatch(T -> boolean)
         * 流中是否没有元素匹配给定的 T -> boolean 条件
         */

        boolean b2 = list.stream().noneMatch(person -> person.getAge() == 20);
        System.out.println(b2);


        /**
         * findAny()：找到其中一个元素 （使用 stream() 时找到的是第一个元素；使用 parallelStream() 并行时找到的是其中一个元素）
         * findFirst()：找到第一个元素
         * 值得注意的是，这两个方法返回的是一个 Optional<T> 对象
         */

        Optional<Person> any = list.stream().findAny();
        Person person = any.get();
        System.out.println(person.getAge());

        Optional<Person> first = list.stream().findFirst();
        Person person1 = first.get();
        System.out.println(person1.getAge());


        /**
         *  reduce((T, T) -> T) 和 reduce(T, (T, T) -> T)
         *  用于组合流中的元素，如求和，求积，求最大值等
         */
        list.stream().map(Person::getAge).reduce(0,Integer::sum);
        list.stream().map(Person::getAge).reduce(Integer::sum);
        list.stream().map(Person::getAge).reduce(0,(a,b3)-> a+b3); // （a,b） 是在整个{}范围内生效，假设说定义一个private String a, 则会和（a.b ）有冲突

        /**
         *  count()
         * 返回流中元素个数，结果为 long 类型
         */
        List aa = null;
        long count = list.stream().count();
        System.out.println(count);

       // long count1 = aa.stream().count(); // 也是会报空指针
       // System.out.println(count1);


        /**
         * unordered() 还有这个比较不起眼的方法，返回一个等效的无序流，
         * 当然如果流本身就是无序的话，那可能就会直接返回其本身
         */

        list.forEach(person2 -> System.out.println(person2));
    }
}
