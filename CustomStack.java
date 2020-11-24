package cmsc256;

import bridges.connect.Bridges;
import bridges.base.SLelement;
import bridges.connect.DataSource;

/*************************************************
 * File name: CustomStack
 * Name: Anne Szarek
 * Project number: Project 4
 * Course identifier: CMSC 256, Spring Semester, Section 902
 * Brief description: Implement a stack using SLelements and visualize in Bridges API
 ************************************************/

public class CustomStack<E> implements cmsc256.StackInterface<E> {
    public SLelement<E> topOfStack = null;

   //Create push method
    @Override
    public void push(E newEntry) throws IllegalArgumentException{
        //Check if newEntry is null. If so, throw IllegalArgumentException
        if(newEntry == null) {
            throw new IllegalArgumentException();
        }
        //Create new SL element
        SLelement<E> newNode = new SLelement<>(newEntry);

        //Setting topOfStack value to new element
        newNode.setNext(topOfStack);
        topOfStack = newNode;
    }

    //Create pop method
    @Override
    public E pop() throws cmsc256.EmptyStackException {
        //Check if the stack is empty. If so, throw EmptyStackException
        if(isEmpty()) {
            throw new cmsc256.EmptyStackException("The stack is empty!");
        }

        //Create new temp element to hold current topOfStack
        SLelement<E> tempNode = topOfStack;
        //Create new element to get new in stack that will become new topOfStack
        SLelement<E> next = topOfStack.getNext();

        //Setting new topofStack
        topOfStack = next;

        //Returning value held in temp element that was popped off of stack
        return (E) tempNode.getValue();
    }

    //Create peek method
    @Override
    public E peek() throws cmsc256.EmptyStackException {
        //Check if stack is empty first. If so throw EmptyStackException
        if(isEmpty()) {
            throw new cmsc256.EmptyStackException("The stack is empty!");
        }

        //Return value to user
        return (E) topOfStack.getValue();
    }

    //Create isEmpty method
    @Override
    public boolean isEmpty() {
       //Create boolean var and set to default of false
       boolean result = false;
       //Checks if topOfStack is null. If so, sets result to true
       if(topOfStack == null) {
           result = true;
       }
       //Returns result
        return result;
    }

    //Create clear method
    @Override
    public void clear() {
        //Set topOfStack to null to clear stack
        topOfStack = null;
    }


    public static void main(String[] args) throws EmptyStackException {

        /* Initialize a Bridges connection with your credentials */
        Bridges bridges = new Bridges(0, "szarek", "1509239090489");
        DataSource ds = bridges.getDataSource();

        //Create instance of CustomStack class
        CustomStack customStack = new CustomStack();

        // Pushed 15, 135, 62, 12, 487
        customStack.push(15);
        customStack.push(135);
        customStack.push(62);
        customStack.push(12);
        customStack.push(487);
        //Display stack values
        customStack.display();

        //Connecting to Bridges API to visualize stack
        try {
            bridges.setTitle("CMSC 256 Project 4 Anne Szarek");
            bridges.setDataStructure(customStack.topOfStack);
            bridges.visualize();
        }
        catch(Exception exc) {
            System.out.println(exc.getMessage());
        }

        // Called pop twice
        customStack.pop();
        customStack.pop();
        //Display stack values
        customStack.display();

        // Called peek
        customStack.peek();
        //Display stack values
        customStack.display();

        // Called clear to empty stack
        customStack.clear();
        //Display stack values
        customStack.display();
    }

    //Create display method
    public void display() {
        //Check if stack is empty. If so, display stack is empty message
        if(isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            //Create new element that holds stack values
            SLelement<E> current = topOfStack;
            //Create new instance of StringBuffer class
            StringBuffer output = new StringBuffer();
            //Appending to output to include top of stack value
            output.append("Top of stack: " + current.getValue() + "\n");
            //While loop over all values in stack
            while(current.getNext() != null) {
                //Setting next value in stack to current
                current = current.getNext();
                //If next value in stack is null, append to output value as stack bottom
                if(current.getNext() == null)
                    output.append("Stack bottom: ");
                //Else append to output a space
                else
                    output.append(" ");
                //Appending to output the current value
                output.append(current.getValue() + "\n");
            }
            //Print out result of output
            System.out.println(output.toString());
        }
    }
}
