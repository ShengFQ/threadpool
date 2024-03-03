package com.shengfq.designpatten.share;

/**
 * ClassName: ShareTest
 * Description: 享元模式测试
 * 抽象一个模型,共享内部状态的元素集合,
 * @author shengfq
 * @date: 2024/2/3 9:16 上午
 */
public class ShareTest {
    public static void main(String[] args) {
        Pieces pieces1=PiecesFactory.get(0);
        pieces1.drawing(1,1);
        Pieces pieces2=PiecesFactory.get(1);
        pieces2.drawing(2,2);
        Pieces pieces3=PiecesFactory.get(0);
        pieces3.drawing(2,2);
        Pieces pieces4=PiecesFactory.get(1);
        pieces4.drawing(2,2);
        Pieces pieces5=PiecesFactory.get(0);
        pieces5.drawing(2,2);
    }

}
/**
 * 享元工厂,提供共享的对象
 * */
class PiecesFactory{
    /**
     * 享元集合,只有2种颜色
     * */
    static Pieces[] pieces={new WhitePieces(),new BlackPieces()};
    public static Pieces get(int key){
        if(key==0){
            return pieces[0];
        }else{
            return pieces[1];
        }
    }
}
/**
 * 享元的抽象定义
 * */
abstract class Pieces{
    protected String color;
    abstract void drawing(int x,int y);
}

class  WhitePieces extends Pieces{
    public WhitePieces(){
        this.color="白色";
    }
    @Override
    void drawing(int x, int y) {
        System.out.println(String.format("我是 %s 落子: x: %d y:%d",this.color,x,y));
    }
}
class BlackPieces extends Pieces{
    public BlackPieces(){
        this.color="黑色";
    }
    @Override
    void drawing(int x, int y) {
        System.out.println(String.format("我是 %s 落子: x: %d y:%d",this.color,x,y));
    }
}
