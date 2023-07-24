import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileIO {
	
		
		ListImplementation<Task> taskList = new ListImplementation<>();
		Task[] tasks = new Task[20];
		int i = 0;
	
	public void readFile() throws IOException{
		Scanner scan =new Scanner(System.in);
		try {
			String path="tasks.txt";
			BufferedReader input=new BufferedReader(new FileReader(path));
			
			
			String line =input.readLine();
			while(line!=null) {
				String[] arr=line.split(",");
				String type=arr[0];
				int priority=0;
				int burstTime=Integer.parseInt(arr[1]);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        LocalDate date= LocalDate.parse(arr[2],formatter);
		        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
		        LocalTime time = LocalTime.parse(arr[3],formatter1);
		        if(type.equals("security management")) {
		        	priority=6;
		        	
		        }
		        else if(type.equals("process management")) {
		        	priority=5;
		        	
		        }
		        else if(type.equals("memory management")) {
		        	priority=4;
		        	
		        }
		        else if(type.equals("user management")) {
		        	priority=3;
		        	
		        }
		        else if(type.equals("device management")) {
		        	priority=2;
		        	
		        }
		        else if(type.equals("file management")) {
		        	priority=1;
		        	
		        }
		        Task task=new Task(type,burstTime,date,time,priority);
		        tasks[i]=task;
		        i++;
		        
		        line=input.readLine();
				
			}
		
		
	}catch(FileNotFoundException e) {
		e.getMessage();
		System.out.println("File NOT FOUND.");
		System.exit(0);
	}
	scan.close();


	}
	public void arrangeList() {
		
		Task temp = new Task();

        for(int x = 1; x < tasks.length; x++){
            for(int y = x; y > 0; y--){

                if(tasks[y].compareTo(tasks[y-1]) == -1){
                    temp = tasks[y];
                    tasks[y] = tasks[y-1];
                    tasks[y-1] = temp;
                }
            }
        }
        for (int i = 0; i < tasks.length; i++){

            taskList.add(tasks[i]);
        }
        
        
        
	}
	

}
