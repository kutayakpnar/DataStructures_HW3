import java.io.IOException;

public class ProgramRun {
	
	public void run() throws IOException {
		FileIO filex=new FileIO();
		filex.readFile();
		filex.arrangeList();
		System.out.println("******************************************************************************");
		System.out.println("------------------------OPERATING SYSTEM SIMULATION---------------------------");
		System.out.println("******************************************************************************");
		System.out.println("\n");
		
		System.out.println("----------------------------------------PART2----------------------------------------");
		for(int b = 1; b < filex.taskList.getLength()+1;b++){
            System.out.println(filex.taskList.getEntry(b));

        }
		System.out.println("\n");
		System.out.println("**************************************************************************************");
		System.out.println("\n");
		System.out.println("---------------------------------------PART4.a----------------------------------------");
		ProgramExecuter exec=new ProgramExecuter();
		exec.createWaitingLine();
		exec.displayWaitingLine();
		System.out.println("\n");
		System.out.println("**************************************************************************************");
		System.out.println("\n");
		System.out.println("---------------------------------------PART4.b----------------------------------------");
		exec.sortByBurstTime();
		exec.displayPile();
		System.out.println("\n");
		System.out.println("**************************************************************************************");
		System.out.println("\n");
		System.out.println("---------------------------------------PART 6.a----------------------------------------");
		System.out.println("-----------AFTER 5 EXECUTION FROM WAITING LINE:");
		exec.popFiveItemQueue();
		exec.displayWaitingLine();
		System.out.println("-----------AFTER 10 EXECUTION FROM WAITING LINE:");
		exec.popFiveItemQueue();
		exec.displayWaitingLine();
		System.out.println("-----------AFTER 15 EXECUTION FROM WAITING LINE:");
		exec.popFiveItemQueue();
		exec.displayWaitingLine();
		System.out.println("**************************************************************************************");
		System.out.println("---------------------------------------PART 6.b----------------------------------------");
		exec.reversedStack(); //we have to change the order due to pop from top according to given command.
		System.out.println("-----------AFTER 5 EXECUTION FROM PILE OF TASK:(from bottom to top)");
		exec.popFiveItemStack();
		exec.displayReversedPile();
		System.out.println("-----------AFTER 10 EXECUTION FROM PILE OF TASK:(from bottom to top)");
		exec.popFiveItemStack();
		exec.displayReversedPile();
		System.out.println("-----------AFTER 15 EXECUTION FROM PILE OF TASK:(from bottom to top)");
		exec.popFiveItemStack();
		exec.displayReversedPile();
		System.out.println("**************************************************************************************");
		
	}

}
