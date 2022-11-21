import java.util.*;

public class fcfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of process: ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        float avg_wt = 0, avg_tat = 0;

        for(int i=0; i<n; i++)
        {
            pid[i] = i + 1;
            System.out.println("Enter process " +(i+1)+ " arrival time: ");
            pid[i] = sc.nextInt();
            System.out.println("Enter process " +(i+1)+ " burst time: ");
            bt[i] = sc.nextInt();
        }

        // Calculating completion time
        for(int i=0; i<n; i++)
        {
            // For zero arrival time
            if(i==0)
            {
                ct[i] = at[i] + bt[i];
            }
            else{
                // for arrival time greater than completion time
                if(at[i]>ct[i])
                {
                    ct[i] = at[i] + bt[i];
                }
                else{
                    ct[i] = ct[i-1] + bt[i];
                }
            }

            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            avg_tat += tat[i];
            avg_wt += wt[i];
        }
        System.out.println("\nProcess  Arrival  Burst  Completion Turn Waiting");
        for(int i=0; i<n; i++)
        {
            System.out.println(pid[i] +"\t"+ at[i] +"\t"+ bt[i] +"\t"+ ct[i] +"\t"+ tat[i] +"\t"+ wt[i]);
        }
        sc.close();
        System.out.println("\nAverage waiting time: " +(float)(avg_wt/n));
        System.out.println("Average turn around time: " +(float)(avg_tat/n));
    }
}
