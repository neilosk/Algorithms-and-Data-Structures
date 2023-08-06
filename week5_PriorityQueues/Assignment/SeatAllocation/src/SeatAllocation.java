import edu.princeton.cs.algs4.MaxPQ;
import java.util.Scanner;


public class SeatAllocation {

   

    public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in); 
        int parties = scan.nextInt();
        int seats = scan.nextInt();
        int[] seatAllocation = new int[parties];

        //Create a priority queue of DHonts objects 
        MaxPQ<DHonts> pq = new MaxPQ<>();

        //Add each party to the priority queue with the number of votes it received  
        //as the DHonts object's votes field    
        //and the party's index as the DHonts object's party field
        for (int i = 0; i < parties; i++) {
            int votes = scan.nextInt();
            DHonts dhont = new DHonts(i, votes);
            pq.insert(dhont);
        }

        //Allocate seats to parties using DHonts method of seat allocation 
        //and update the priority queue
        for (int i = 0; i < seats; i++) {
            DHonts dhont = pq.delMax();
            dhont.seats++;
            pq.insert(dhont);
        }
      
        //Add the number of seats allocated to each party to the seatAllocation array 
        //and print the results
        while(!pq.isEmpty()) {
            DHonts p = pq.delMax();
            seatAllocation[p.party] = p.seats;
        }
      
        for (int i : seatAllocation) {
            System.out.println(i);
        }
    }
}



