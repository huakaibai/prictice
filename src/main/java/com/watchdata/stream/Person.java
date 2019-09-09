package com.watchdata.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zhibin.wang
 * @create 2019-09-03 14:18
 * @desc
 **/

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {
        return age-o.getAge();
    }
}
