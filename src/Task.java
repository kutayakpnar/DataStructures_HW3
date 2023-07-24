
import java.time.LocalDate;
import java.time.LocalDateTime ;
import java.time.LocalTime;
public class Task implements Comparable<Task> {
	
	private String type;
	private int burstTime;
	private LocalDate arrivalDate;
	private LocalTime arrivalTime;
	private int priority;
	
	public Task() {
		
	}
	public Task(String type, int burstTime, LocalDate arrivalDate, LocalTime arrivalTime,int priority) {
		
		this.type=type;
		this.burstTime=burstTime;
		this.arrivalDate=arrivalDate;
		this.arrivalTime=arrivalTime;
		this.priority=priority;
		
	}
	public int compareTo(Task other) {
		int result = 0;

        if(this.arrivalDate.isBefore(other.arrivalDate)){
            result = -1;
        }

        else if (this.arrivalDate.isAfter(other.arrivalDate)){
            result = 1;
        }
        else if (this.arrivalDate.isEqual(other.arrivalDate)){

            if(this.arrivalTime.isBefore(other.arrivalTime)){
                result = -1;
            }
            else if( this.arrivalTime.isAfter(other.arrivalTime)){
                result = 1;
            }
            else{
                result = 0;
            }
        }
        return result;
    
		
	}
	public int compareBurstTimes(Task otherTask){
        return (this.burstTime - otherTask.getBurstTime());
	
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getBurstTime() {
		return burstTime;
	}


	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}


	public LocalDate getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public LocalTime getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public int getPriority() {
		return priority;
	}


	public void setPrioriy(int prioriy) {
		this.priority = prioriy;
	}
	public static int compareTasks(Task task1, Task task2) {
        if (task1.priority != task2.priority) {
            return task1.priority - task2.priority;
        } else if (!task1.arrivalDate.equals(task2.arrivalDate)) {
            return -(task1.arrivalDate.compareTo(task2.arrivalDate));
        } else {
            return -(task1.arrivalTime.compareTo(task2.arrivalTime));
        }
    }
	public int comparePriorities(Task otherTask){

        return (this.priority - otherTask.getPriority());
    }
	public String toString() {
        return 
                "TASK TYPE:" + type +" "+
                "BURST TIME:" + burstTime +" "+
                "DATE:" + arrivalDate +" "+
                "TIME:" + arrivalTime +" "+
                "PRIORITY:" + priority;
    }
	

}
