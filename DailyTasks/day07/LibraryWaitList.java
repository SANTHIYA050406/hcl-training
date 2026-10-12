import java.util.*;
public class LibraryWaitList{
    public static void main(String[] Args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> catalogue=new ArrayList<>();
        System.out.println("enter no of books:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.println("enter books in catalogue:");
            catalogue.add(sc.nextLine());
        }
        System.out.println("catalogue:"+ catalogue);
        LinkedHashSet<String> uniquerequests =new LinkedHashSet<>();
        System.out.println("Enter no of requests:");
        int k=Integer.parseInt(sc.nextLine());
        for(int i=0;i<k;i++){
            System.out.println("Enter StudentID:");
            uniquerequests.add(sc.nextLine());
        }
        System.out.println("unique requests:"+ uniquerequests);
        ArrayDeque<String>waitList=new ArrayDeque<>();
        for(String values:uniquerequests){
            waitList.offer(values);
        }
        System.out.println("wailt list:"+ waitList);
        PriorityQueue<String>prioritywaitlist=new PriorityQueue<>(Comparator.comparingInt((String request)-> request.startsWith("Faculty")?1:2));
        System.out.println("Enter no of priority requests:");
        int p=Integer.parseInt(sc.nextLine());
        for(int i=0;i<p;i++){
            System.out.println(" Enter requests(Faculty-Id or Students-Id):");
            prioritywaitlist.offer(sc.nextLine());
        }
        System.out.println("Priority list:");
        while(!prioritywaitlist.isEmpty()){
            System.out.println(prioritywaitlist.poll());
        }
        System.out.println("enter no of overdue books:");
        int h=Integer.parseInt(sc.nextLine());
        ArrayList<String> overdue=new ArrayList<>();
        for(int i=0;i<h;i++){
            System.out.println("Enter the overdue books:");
            overdue.add(sc.nextLine());
        }

        System.out.println("Enter the book name to remove:");
        String removebook=sc.nextLine();
        Iterator <String> it=overdue.iterator();
        while(it.hasNext()){
            if(it.next().equalsIgnoreCase(removebook)){
                it.remove();
            }
        }
        System.out.println("Remaining books:"+overdue);
        sc.close();
    }
}