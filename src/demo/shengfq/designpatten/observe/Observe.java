package demo.shengfq.designpatten.observe;
/**
 * 订阅者角色
 * 定义监听方法,被动接受发布者发布的更新.
 * */
public interface Observe {
	public void update();
}
