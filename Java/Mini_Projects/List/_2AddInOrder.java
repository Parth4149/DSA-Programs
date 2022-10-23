package Java.Mini_Projects.List;
import java.util.*;

class test2 {
    private static boolean addInOrder(LinkedList<String> ll,String newCity){// insert in ascending order

        ListIterator<String> it=ll.listIterator();//stringListIterator
        while(it.hasNext()){
            int comparison = it.next().compareTo(newCity);//
            if(comparison==0){//equal, do not add
                System.out.println(newCity+" is already included as a destination");
                return false;
            }
            else if(comparison>0){
                it.previous();
                it.add(newCity);
                return true;
            }
        }
        it.add(newCity);
        return true;
    }

    public static void main(String[] args) {
        LinkedList<String> ll=new LinkedList<>();

//        addInOrder(ll,"Benglore");
//        addInOrder(ll,"Mumbai");
//        addInOrder(ll,"Ahmedabad");
//        addInOrder(ll,"Delhi");
//        addInOrder(ll,"Noida");
////        printList(ll);
//        addInOrder(ll,"Indore");// insert in alphabetical order
//        System.out.println(ll.listIterator(3));
        printList(ll);
        visit(ll);
    }
    private static void visit(LinkedList<String> cities){
        Scanner sc=new Scanner(System.in);
        ListIterator<String> it=cities.listIterator();
        boolean quit=false;
        boolean goingForward=true;
        if (cities.size() == 0) {// NoSuchElementException occurs
            System.out.println("No cities in itinerary");
            return;
        }
        else{
            System.out.println("Now visiting "+it.next());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();

            sc.nextLine();
            switch(action) {
                    case 0:
                        System.out.println("Holiday (vacation) over");
                        quit = true;
                        break;
                    case 1:
                        if (!goingForward) {
                            if (it.hasNext()) {
                                it.next();
                            }
                            goingForward = true;
                        }
                        if (it.hasNext()) {
                            System.out.println("Now visiting " + it.next());
                        } else {
                            System.out.println("We are at the end of the list");
                        }
                        break;
                    case 2:
                        if (goingForward) {
                            if (it.hasPrevious()) {
                                it.previous();
                            }
                            goingForward = false;
                        }
                        if (it.hasPrevious()) {
                            System.out.println("Now visiting " + it.previous());
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                        break;
                    case 3:
                        printMenu();
                }
        }

    }

    private static void printMenu() {
        System.out.print("1 - go to next city\n2 - go to previous city\n3 - print manu options\n0 - to quit\nSelect :");
    }

    private static void printList(java.util.LinkedList<String> ll){
        Iterator<String> it=ll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());// it++
        }
//        for(String i:ll){
//            System.out.println(i);
//        }
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
    }
}
