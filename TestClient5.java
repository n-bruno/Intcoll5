//*******************************************
// Test Client Program for Intcoll4, Intcoll2 and Intcoll3
//       Aniruddha Maiti
//*******************************************

import java.util.*;

public class TestClient5 {

    public static final int SENTINEL = 0;

    public static void main(String[] args) {

        int value;
        Scanner keyboard = new Scanner(System.in);
        Intcoll5 P1 = new Intcoll5(), N1 = new Intcoll5(), L1 = new Intcoll5();

        ////////////////////////////////////////////////////
        //
        ////////////////////////////////////////////////////
        /*
        This code was on the answer to the second question on quiz #3.
         */
        //setup
        Intcoll5 A = new Intcoll5();
        A.insert(5);
        A.insert(6);

        LinkedList<Intcoll5> L;
        L = new LinkedList<Intcoll5>();

        L.add(A);
        L.add(A);
        L.add(A);

        /////actual code
        int i = 0;
        ListIterator<Intcoll5> L2 = L.listIterator();
        while (L2.hasNext()) {
            if (A.equals(L2.next())) {
                i++;
            }
        }

        System.out.println(i);
        ////////////////////////////////////////////////////

        value = keyboard.nextInt();
        while (value != SENTINEL) {
            if (value > 0) {

                P1.insert(value);
                L1.insert(value);

            } else {

                N1.insert(-value);
                L1.omit(-value);
            }

            value = keyboard.nextInt();
        }

        // Test Intcoll4
        System.out.println("\n\nResults for Intcoll4\n*****************************\n");

        System.out.println("\nThe values in collection P1 are: ");
        P1.print();
        System.out.println("Size of P1 : " + P1.get_howmany());

        System.out.println("\nThe values in collection N1 are:");
        N1.print();
        System.out.println("Size of N1 : " + N1.get_howmany());

        System.out.println("\nThe values in collection L1 are:");
        L1.print();
        System.out.println("Size of L1 : " + L1.get_howmany());

        if (P1.equals(N1)) {
            System.out.println("\nP1 and N1 are equal.");
        } else {
            System.out.println("\nP1 and N1 are NOT equal.");
        }

        Intcoll5 A1 = new Intcoll5();
        A1.copy(L1);

        if (A1.equals(L1)) {
            System.out.println("\nA1 and L1 are equal.");
        } else {
            System.out.println("\nA1 and L1 are NOT equal.");
        }

        A1.omit(5);
        A1.omit(400);
        A1.omit(-5);
        A1.omit(-400);
        A1.omit(0);

        System.out.println("\n 5 Belongs to A1 " + A1.belongs(5));
        System.out.println("\n 15 Belongs to A1 " + A1.belongs(15));
        System.out.println("\n 150 Belongs to A1 " + A1.belongs(150));
        System.out.println("\n 27 Belongs to A1 " + A1.belongs(27));

        A1.insert(15);
        A1.insert(-27);
        A1.insert(30);
        A1.insert(0);

        System.out.println("\n 5 Belongs to A1 " + A1.belongs(5));
        System.out.println("\n 15 Belongs to A1 " + A1.belongs(15));
        System.out.println("\n 150 Belongs to A1 " + A1.belongs(150));
        System.out.println("\n 27 Belongs to A1 " + A1.belongs(27));

        System.out.println("\nThe values in the copy of L1 are:\n");
        A1.print();

        System.out.println("Size of A1  " + A1.get_howmany());

        System.out.println("\n*****************************\n");
    }
}
