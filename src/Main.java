import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);
        System.out.println("Введи Н");
        int n = vvod.nextInt();
        System.out.println("Введи маршруты");
        Integer [] order = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = vvod.nextInt();
        ArrayList<Bus> bus=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bus.add(new Bus(order[i],i ));
        }
        Collections.sort(bus);
        int maxTime =1;
        for (int i = 0; i < n-1; i++) {
         if(bus.get(i).number==bus.get(i+1).number){
             int x = bus.get(i+1).orderInQueue-bus.get(i).orderInQueue;
             if(x>maxTime) maxTime=x;
         }
        }
        System.out.println(maxTime);
    }
}
 class Bus implements Comparable<Bus> {
   Integer number; int orderInQueue;
    public Bus(Integer number, int orderInQueue) {
        this.number = number;
        this.orderInQueue = orderInQueue;
    }
     @Override
     public int compareTo(Bus o) {
        return this.number.compareTo(o.number);
     }
 }