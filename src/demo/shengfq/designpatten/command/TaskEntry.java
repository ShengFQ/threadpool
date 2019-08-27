package demo.shengfq.designpatten.command;

public class TaskEntry {
	private Task task;
	private long timeInterval;
	private long timeLastDone;

	public TaskEntry(Task task, long timeInteral) {
		this.task = task;
		this.timeInterval = timeInteral;
	}

	public Task getTask() {
		return task;
	}

	public long getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(long timeInterval) {
		this.timeInterval = timeInterval;
	}

	public long getTimeLastDone() {
		return timeLastDone;
	}

	public void setTimeLastDone(long timeLastDone) {
		this.timeLastDone = timeLastDone;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
