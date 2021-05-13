package com.neeraj.codingproblems;

public class ThreadJoin {

	private static class ParallelTask implements Runnable {
		private Thread predecessor;

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " Started");
			if (predecessor != null) {
				try {
					predecessor.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " Finished");
		}

		public void setPredecessor(Thread t) {
			this.predecessor = t;
		}
	}

	public static void main(String[] args) {

		// we have three threads and we need to run in the // order T1, T2 and T3 i.e.
		// T1 should start first // and T3 should start last. // You can enforce this
		// ordering using join() method // but join method must be called from run()
		// method // because the thread which will execute run() method // will wait for
		// thread on which join is called.

		ParallelTask task1 = new ParallelTask();
		ParallelTask task2 = new ParallelTask();
		ParallelTask task3 = new ParallelTask();
		final Thread t1 = new Thread(task1, "Thread - 1");
		final Thread t2 = new Thread(task2, "Thread - 2");
		final Thread t3 = new Thread(task3, "Thread - 3");
		task2.setPredecessor(t1);
		task3.setPredecessor(t2);

		// now, let's start all three threads
		t1.start();
		t2.start();
		t3.start();
	}

}
