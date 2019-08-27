package demo.shengfq.lang;
import java.math.BigInteger;
 
/**
 * Created by Rocky on 14-3-26.
 */
public class MyBigIntegerTest {
    public void test1() throws Exception {
        String a1 = "1212";
        String b1 = "1212";
        MyBigInteger a = new MyBigInteger(a1);
        MyBigInteger b = new MyBigInteger(b1);
        MyBigInteger c = a.add(b);
        System.out.println(c);
        BigInteger a2 = new BigInteger(a1);
        BigInteger b2 = new BigInteger(b1);
        BigInteger c2 = a2.add(b2);
        System.out.println(c2);
        System.out.println(c2.toString().equals(c.toString()));
    }
}

