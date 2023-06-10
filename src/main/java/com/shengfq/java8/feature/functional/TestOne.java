package com.shengfq.java8.feature.functional;
/**
 * 函数式接口的
 *
 * **/
public class TestOne {
    public static void main(String[] args) {
        FunctionCall call=new FunctionCall();

        call.testConsumer(x->System.out.println(x),1);
        call.testBiConsumer((x,y)->{
            int result=x+y;
            System.out.println("x+y:"+result);
        },1,1);
        Integer result=call.testSupplier(()->{
            return 12;
        });
        System.out.println("supplier:"+result);
        result=call.testFunctional((x)->{
            return x+1;
        },1);
        System.out.println("function:"+result);
        result=call.testFunctional((x)->{
            return x-1;
        },1);
        System.out.println("function:"+result);
        result=call.testFunctional((x)->{
            return x*2;
        },1);
        System.out.println("function:"+result);

        call.testPredicate(x->{
            if(x>0){
                return true;
            }else{
                return false;
            }
        },2);
    }
}
