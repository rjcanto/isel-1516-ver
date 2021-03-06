package Synchronizers;

public class Completion {
	public boolean isComplete = false ;
	
	public void complete()
	{
		notify();
	}
	
	public boolean waitForCompletion()
	{
		synchronized(this) {
			try {
				while(!isComplete) wait();
				return false ;
			} catch (InterruptedException e)
			{
				return false ;
			}
		}
	}
	
	public void completeAll()
	{
		synchronized(this) {
			notifyAll();
		}
	}
}
