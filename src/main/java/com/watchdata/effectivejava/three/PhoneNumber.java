package com.watchdata.effectivejava.three;

import java.util.Objects;

/**
 * @author zhibin.wang
 * @create 2019-07-09 14:41
 * @desc 测试 Hashcode和equals
 **/
public class PhoneNumber  implements  Comparable<PhoneNumber>{


    private final short areaCode;

    private final short prefix;

    private final short lineNumber;


    public PhoneNumber(short areaCode, short prefix, short lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        if ( !(o instanceof  PhoneNumber))
            return  false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNumber == that.lineNumber;
    }

    @Override
    public int hashCode() {
       // return Objects.hash(areaCode, prefix, lineNumber);
        int result = 17;

        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        int i = areaCode - o.areaCode;
        if (i != 0 )
            return i;

        int i1 = prefix - o.prefix;
        if (i1 != 0)
            return i1;

            return 0;
    }

    public static void main(String[] args) {
     //   PhoneNumber phoneNumber = new PhoneNumber(0,1,2);
//       / phoneNumber.prefix =1;

    }
}
