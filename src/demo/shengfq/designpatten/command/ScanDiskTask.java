package demo.shengfq.designpatten.command;

public class ScanDiskTask implements Task {

	@Override
	public void taskPerform() {
		System.out.println("scanDisk Task has been performed");
	}

}
