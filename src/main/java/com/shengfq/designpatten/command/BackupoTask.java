package com.shengfq.designpatten.command;

public class BackupoTask implements Task {
	@Override
	public void taskPerform() {
		System.out.println("Backup task has been performed");
	}
}
