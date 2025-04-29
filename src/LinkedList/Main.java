package LinkedList;

public class Main {

    public static void main(String[] args) {
        LL object = new LL();

        object.add(1);
        object.add(3);
        object.add(9);
        object.add(11);
        object.add(17);
        object.add(101);

        object.insertAtIndex(6, 934);
        object.display();
        System.out.println(object.getSize());
    }
}
