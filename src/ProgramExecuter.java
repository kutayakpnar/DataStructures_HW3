
import java.io.IOException;



public class ProgramExecuter {
	 private PriorityQueue<Task> queue=new PriorityQueue<Task>();
	 private StackImplementation<Task> pile=new StackImplementation<Task>();
	 FileIO filex1 = new FileIO();
	 FileIO filex2 = new FileIO();
	 private StackImplementation<Task> reversedPile=new StackImplementation<Task>();
     
     ListImplementation<Task> taskList;

	
	
	 public void createWaitingLine() throws IOException {
		 filex1.readFile();
	     filex1.arrangeList();
	     taskList=filex1.taskList;
		
	    for (int i = 1; i < taskList.getLength() ; i++) {
	            for (int j = 1; j < taskList.getLength() - i +1; j++) {
	                if (Task.compareTasks(taskList.getEntry(j), taskList.getEntry(j+1)) < 0) {
	                	Task temp = taskList.getEntry(j);
		                taskList.replace(j, taskList.getEntry(j + 1));
		                taskList.replace(j + 1, temp);
	                }
	            }
	        }
	    for(int a = 1; a <=taskList.getLength();a++){
	        queue.enqueue(taskList.getEntry(a));
	    }
	    }
	
	
	public void displayWaitingLine() {
		queue.displayItems();
	}
	
	public void displayPile() {
		pile.displayItems();
	}
	
	
	public void sortByBurstTime() {
	    int n = taskList.getLength();
	    for (int i = 1; i < n; i++) {
	        boolean swapped = false;
	        for (int j = 1; j < n - i+1; j++) {
	            if (taskList.getEntry(j).getBurstTime() > taskList.getEntry(j + 1).getBurstTime()
	                    || (taskList.getEntry(j).getBurstTime() == taskList.getEntry(j + 1).getBurstTime()
	                    && taskList.getEntry(j).getArrivalDate().compareTo(taskList.getEntry(j + 1).getArrivalDate()) > 0)) {
	                Task temp = taskList.getEntry(j);
	                taskList.replace(j, taskList.getEntry(j + 1));
	                taskList.replace(j + 1, temp);
	                swapped = true;
	            }
	        }
	        if (!swapped) {
	            break; // No more swaps, the list is already sorted
	        }
	    }
	    for(int a = 1; a <=taskList.getLength();a++){
	        pile.push(taskList.getEntry(a));
	    }
	    
	}
	
	public StackImplementation<Task> reversedStack(){
		for(int a = taskList.getLength(); a > 0;a--){
	        reversedPile.push(taskList.getEntry(a));
	    }
		return reversedPile;
		
	}
	
	public void popFiveItemQueue(){


        for (int i = 0; i < 5; i ++){
             queue.dequeue();
        }
      
    }
	
	public void popFiveItemStack() {
		for (int i = 0; i < 5; i ++){
            reversedPile.pop();
       }
		
	}
	public void displayReversedPile() {
		reversedPile.displayItems();
	}
	
	

	
	
}
