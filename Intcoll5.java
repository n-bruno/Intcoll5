
import java.util.LinkedList;
import java.util.ListIterator;

//*********************************************************************
// FILE NAME    : Intcoll5.java
// DESCRIPTION  : This file contains the class Intcoll5.
//*********************************************************************
public class Intcoll5 {
////////////////////////////////////////////
//  Variables
////////////////////////////////////////////

    private LinkedList<Integer> c;

////////////////////////////////////////////
//  Crap
////////////////////////////////////////////
    /*
    Constructor for Intcoll5 class
     */
    public Intcoll5() {
        create();
    }

    //accepts a parameter to allow compatibility between client versions
    public Intcoll5(int i) {
        create();
    }

    private void create() {
        c = new LinkedList<Integer>();
    }

    /*
    Returns the size of the linked list
    We don't store the size in a variable and update it in the class this time
    instead we can calculate it on the spot.
     */
    public int get_howmany() {
        ListIterator<Integer> I = c.listIterator();
        int i = 0;

        /*
        Fortunately, linkedlist has a hasNext() method that returns false
        if we reach the last member of the list.
        
        So for each loop, we select the next node an increment i, once I has
        reached an empty node, we reach the end of the list. The integer i
        is our size and we return it.
         */
        while (I.hasNext()) {
            I.next();
            i++;
        }
        return i;
    }

////////////////////////////////////////////
//  Belongs
////////////////////////////////////////////
    /*
    Checks if the integer in the parameter is in our list.
     */
    public boolean belongs(int integer) {
        /*
        Thankfully linked list already has a method for this.
        Less efort on my part!
        */
        return c.contains(integer);
    }
////////////////////////////////////////////
//  Insert
////////////////////////////////////////////
    //Inserts a number into the collection
    public void insert(int integer) {
        /*
        This *really* should be self explanitory...
         */
        if (integer > 0) {
            if (!c.contains(integer)) 
                c.add(integer);
        } else {
            System.out.println("Error: You can't insert"
                    + "negative numbers or zero.");
        }
    }

////////////////////////////////////////////
//  Omit
////////////////////////////////////////////
    /*
    Deletes a member from the linked list
     */
    public void omit(int integer) {
        /*
        We remove an object instead of an integer because each element
        in a link list is an object that containsd a pointer and integer.
        
        On the other hand, the add method adds the integer and generates
        an object with a pointer automatically.
        See line 942 in the linked list source code.
         */
        if (integer > 0 && get_howmany() > 0) {
            Integer I = new Integer(integer);
            if (c.contains(I)) {
                c.remove(I);
            }
        }
    }

////////////////////////////////////////////
//  Copy
////////////////////////////////////////////
    /*
    Here we copy the contents from the parameter
    into the obj that executed it.
     */
    public void copy(Intcoll5 obj) {
        /*
        We overwrite c here so it doesn't leave any elements over when we
        copy over, that'd be bad.
         */
        c = new LinkedList<Integer>();

        /*
        Create an I object to cycle through
         */
        ListIterator<Integer> I = obj.c.listIterator();

        /*
        Create Integer a
        
        also when first using next() it returns the first element.
         */
        if (obj.get_howmany() != 0) {

            Integer a = I.next();
            /*
            We traverse through I and add each integer from it into c
             */
            while (I.hasNext() == true) {
                c.add(a);
                a = I.next();
            }

            /*
            due to some quirk, this is here to add the last element
            I'm a bd boy. If there's a better way to do this method with
            this line, I'd like to hear.
             */
            c.add(a);
        }
    }

    /*
    Prints all contents in the list
     */
////////////////////////////////////////////
//  Print
////////////////////////////////////////////
    /*
    Print all contents
     */
    public void print() {
        /*
        This really should be self explanitory...
        I keep looping and printing until I reach the end of the list
         */
        ListIterator<Integer> I = c.listIterator();
        while (I.hasNext()) {
            Integer n = I.next();
            System.out.println(n.intValue());
        }
    }

////////////////////////////////////////////
//  Equals
////////////////////////////////////////////
    /*
    Tests the equaluty of two lists by content and order.
     */
    public boolean equals(Intcoll5 obj) {
        if (this != obj) { //check if the pointers aren't equal
            if (get_howmany() == obj.get_howmany()) {
                boolean thisTestsYoSkills = true;

                ListIterator<Integer> mememe = c.listIterator();
                ListIterator<Integer> objobj = obj.c.listIterator();
                Integer b;

                while (mememe.hasNext() && thisTestsYoSkills == true) {
                    b = objobj.next();
                    if (b != mememe.next()) {
                        thisTestsYoSkills = false;
                    }
                }
                return thisTestsYoSkills;
            } else return false;
        } else return true;
    }

///////////////////////////////////////////////////////////////////////////////
}
