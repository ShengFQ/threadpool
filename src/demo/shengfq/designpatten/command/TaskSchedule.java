package demo.shengfq.designpatten.command;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 计划执行任务列表,计划不关心任务的具体实现,计划项中,通过接口实现任务的具体实现与任务描述分离解耦.
 * */
public class TaskSchedule extends Thread {
	private Vector taskList = new Vector<>();
	private long sleeptime = 1000000000L;

	public void addTask(TaskEntry taskEntry) {
		taskList.add(taskEntry);
		taskEntry.setTimeLastDone(System.currentTimeMillis());
		if (sleeptime > taskEntry.getTimeInterval())
			sleeptime = taskEntry.getTimeInterval();
	}

	public void schedulePermorm() {
		try {
			sleep(sleeptime);
			Enumeration e = taskList.elements();
			while (e.hasMoreElements()) {
				TaskEntry te = (TaskEntry) e.nextElement();
				if (te.getTimeInterval() + te.getTimeLastDone() < System
						.currentTimeMillis()) {
					te.getTask().taskPerform();
					te.setTimeLastDone(System.currentTimeMillis());
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TaskSchedule schedule = new TaskSchedule();
		TaskEntry t1 = new TaskEntry(new ScanDiskTask(), 1000);
		TaskEntry t2 = new TaskEntry(new BackupoTask(), 3000);
		schedule.addTask(t1);
		schedule.addTask(t2);
		while (true) {
			schedule.schedulePermorm();
		}
	}
}
