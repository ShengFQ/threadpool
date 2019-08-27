package demo.shengfq.designpatten.observe;
/**
 * 发布者角色:
 * 事件源
 * */
public interface Subject {
	public void attach(Observe observe);
	public void dettach(Observe objserve);
	public void msgNotify();
	public String getState();
	public void setState(String state);
}
