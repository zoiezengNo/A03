package edu.unc.comp210.a03LinkedList;

// Starter Code provided with Assignment #3 for COMP210

public class LinkedList {
    private Node _head = null;
    private Node _tail = null;
    private int _size = 0;

    /**
     * Task 1
     * Merge the given list (list2) at the start of the current list.
     * After merging, list2 should be empty.
     *
     * Note: Do NOT create and return a new list, merge the second list at the start of the first one.
     *
     * ex: list: 1 -> 2 -> 3
     *     list2: 4 -> 5 -> 6
     *     list after simpleMerge: 4 -> 5 -> 6 -> 1 -> 2 -> 3
     *     list2 after simpleMerge: (empty)
     *
     * @param list2 - list to be merged
     */
    public void simpleMerge(LinkedList list2) {
        //TODO
        // if the list is empty then nothing happens
        if (list2.isEmpty()){
            return;
        }
        // the current list is empty
        if(this.isEmpty()){
            _tail = list2._tail;
            _head = list2._head;
            // this means that the list2 head will be the current list head; etc
        }
        // when both the list contains something
        else {
            list2._tail.setNext(_head); // setting the list's tail to the current head, so it
            // has that in reference
            _head = list2._head;
            //tail stays the same
        }
        _size += list2.size() ;
        list2.clear(); // clears all the content in list2

    }

    /**
     * Task 2
     * Remove the node at index i of the list.
     * Note that the first element is at index 0
     * If i is not a valid index (less than 0, or greater than or equal to the size of the list),
     * throw an IndexOutOfBoundsException
     *
     * ex: list: 1 -> 4 -> 2 -> 3
     *     i: 1
     *     list after removeAtIndex: 1 -> 2 -> 3
     *
     * @param i    - index of node to remove
     */
    public void removeAtIndex(int i) {
        // TODO
        validIndex(i); // method that will check if it's out of bounds or below 0/1
        // throws the indexOutofBounds Exception
        if (i == 0){
            _head = _head.getNext(); // since it's removing at index 0, new head is the next value
            // if there is no head, then make sure that the tail also doesn't have a value
            if(_head == null){
                _tail = null;
            }
        }
        else{
            Node prev = _head;
            // loops through the whole list, and gets the value before the index i (k = i -1)
            for(int k = 0; k < i -1; k++){
                prev = prev.getNext(); // the node before i
            }
            Node tem = prev.getNext(); // storing the next value (desired index)
            prev.setNext(tem.getNext()); // the temp next value, which is the the one that needs to be linked
            // since tem.getNext() will equal null, then it won't throw an error / and the tail is stored as the last value of the
            // node list
            // while the head is the first item of the hode list

            // the one that you want to remove, so set the previous node as the tail now
            if(tem == _tail){
                _tail = prev;
            }

        }
        _size --;


    }

    /**
     * Task 3
     * Return true if this linked list is equal to the list argument, false otherwise.
     * Two lists are equal if they have the same size, and the same
     * elements in the same order.
     * ex:  list: 1 -> 4 -> 2
     *      list2: 1 -> 4 -> 2
     *      return: true
     *
     *      list: 1 -> 5
     *      list2: 2 -> 5
     *      return false;
     *
     * @param list2 - the list to compare with the current list
     * @return true if the lists have the same elements in the same order, false otherwise
     */
    public boolean isEqual(LinkedList list2) {
        // TODO
        if(this._size == list2._size && list2 != null){
            Node a = _head;
            Node b = list2._head;
            while (b != null){
                if (a.getValue() != b.getValue()){
                    return false;
                }
                a = a.getNext();
                b = b.getNext();
            }
            return true;
        }
        return false;    // Change this statement as required
    }

    /**
     * Task 4
     * Given a sorted linked list, remove the duplicate values from the list
     * ex: list: 5 -> 6 -> 7 -> 7 -> 7 -> 8 -> 8 -> 9
     *     list after removeRepeats: 5 -> 6 -> 7 -> 8 -> 9
     *
     */
    // just remove the repeated numbers so it'll be just single numbers
    public void removeRepeats() {
        // TODO
        Node cur = _head;
        //loops through the whole thing
        while (cur != null && cur.getNext() != null){
            //If they're the same, then have to remove the repeat,
            if (cur.getValue() == cur.getNext().getValue()){
                if(cur.getNext() == _tail){
                    _tail = cur; // so the tail is now the current one
                }
                // remove the repeat and point to new object
                cur.setNext(cur.getNext().getNext());
                _size--;
            }
            //since this means that the values ajacent isn't equal
            else {
                cur = cur.getNext(); // goes through the whole list e
            }

        }
    }

    /**
     * Task 5
     * Reverse the list.
     * eg list:  10 -> 9 -> 8 -> 7
     * list after reverse: 7 -> 8 -> 9 -> 10
     */
    public void reverse() {
        // TODO
        Node prev = null;
        Node cur = _head; // starting from the beginning to reverse the order
        _tail = _head; // since the tail will now have the starting value
        while(cur != null){
            Node newNode = cur.getNext(); // getting the 9
            cur.setNext(prev); // setting the current to the old / should be next since it's a poitner
            // reverse changes the pointing/ where it's referring to, not the value inside
            prev = cur;
            cur = newNode;
        }
        _head = prev; // the last node

    }

    /**
     * Task 6
     * Merge the given linked list2 into the current list. The 2 lists will always be
     * either the same size, or the current list will be longer than list2.
     * The examples below show how to handle each case.
     * After merging, list2 should be empty.
     *
     * Note: Do NOT create and return a new list, merge the second list into the first one.
     *
     * ex: list: 1 -> 2 -> 3
     *     list2: 4 -> 5 -> 6
     *     list after merge: 4 -> 1 -> 5 -> 2 -> 6 -> 3
     *
     *     list: 1 -> 2 -> 3 -> 4
     *     list2: 5 -> 6
     *     list after merge: 5 -> 1 -> 6 -> 2 -> 3 -> 4
     *
     * @param list2 - list to interleave into the current list
     */
    public void merge(LinkedList list2) {
        // TODO
        // cycle through by making while loop
        if (list2.isEmpty()){
            return;
        }
        if(this.isEmpty()){
            _head = list2._head;
            _tail = list2._tail;
            _size = list2._size;
            list2.clear();
            return;
        }

        Node a = _head;
        Node b = list2._head;
        _head = b;

        int list2S = list2._size;
        // looping through the list2 since it'll be shorter
        while(a != null && b != null){
            // alternates so it's a again

            Node newA = a.getNext();
            Node newB = b.getNext();
            b.setNext(a); // merging the two lists together
            //then alternate so that it's b next
            if(newB != null){
                a.setNext(newB);
            }
            // when nextB reached null/tail, so just adding the rest of a
            //increment the a's and b's
            a = newA;
            b = newB;

        }
        _size += list2S;

        if(a == null){
            _tail = list2._tail;
        }
        list2.clear(); //removes all the content
    }


    /* Implementations below are being given to you. Do not modify below this line. */

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public void clear() {
        _head = null;
        _tail = null;
        _size = 0;
    }

    public boolean contains(int element) {
        Node current = _head;
        while(current != null) {
            if(current.getValue() == element) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int[] toArray() {
        int[] arr =   new int[size()];
        Node current = _head;
        int i = 0;
        if(isEmpty()) {
            return arr;
        }
        while(current != null){
            arr[i] = current.getValue();
            current = current.getNext();
            i++;
        }
        return arr;
    }

    public void add(int element) {
        Node newNode = new NodeImpl(element, null);
        if(isEmpty()) {
            _head = newNode;
            _tail = newNode;
            _size++;
        } else {
            _tail.setNext(newNode);
            _tail = newNode;
            _size++;
        }

    }

    public boolean remove(int element) {
        Node current = _head;
        if(isEmpty()) {
            return false;
        }
        if(current.getValue() == element){
            _head = _head.getNext();
            if(_head == null) {
                _tail = null;
            }
            _size--;
            return true;
        }
        while(current.getNext() != null && current.getNext().getValue() != element) {
            current = current.getNext();
        }
        if(current.getNext() == null) {
            return false;
        }
        if(current.getNext().getNext() == null) {
            _tail = current;
        }
        current.setNext(current.getNext().getNext());
        _size--;
        return true;
    }

    public int get(int index) {
        validIndex(index);
        Node current = _head;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    public int set(int index, int element) {
        validIndex(index);
        Node current = _head;
        int prevValue = 0;
        int i = 0;
        if(index == 0) {
            prevValue = _head.getValue();
            _head.setValue( element);
        } else {
            while(current != null) {
                if(i == index) {
                    prevValue = current.getValue();
                    current.setValue( element);
                    return prevValue;
                }
                current = current.getNext();
                i++;
            }
        }

        return prevValue;
    }

    public void add(int index, int element) {
        if(index < 0 || index > _size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = _head;
        int i = 0;
        if(index == 0) {
            if(isEmpty()) {
                add(element);
                return;
            } else {
                Node newNode = new NodeImpl( element, _head);
                _head = newNode;
                _size++;
                return;
            }

        }  else if(index == _size) {
            add(element);
            return;
        }
        while(current != null) {
            if(i == (index - 1)) {
                Node temp = current.getNext();
                Node newNode = new NodeImpl( element, temp);
                current.setNext(newNode);
                _size++;
                return;
            } else {
                current = current.getNext();
                i++;
            }
        }
    }

    public int indexOf(int element) {
        Node current = _head;
        int index = 0;
        while(current != null) {
            if(current.getValue() == element) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    public int lastIndexOf(int element) {
        Node current = _head;
        int index = -1;
        int i = 0;
        while(current != null) {
            if(current.getValue() == element) {
                index = i;
            }
            i++;
            current = current.getNext();
        }
        return index;
    }

    public void validIndex(int i) {
        if(i < 0 || i >= _size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
    public Node gethead() {
        return _head;
    }

    @Override
    public String toString() {
        String list = "";
        Node current = _head;
        while(current != null) {
            if(current.getNext() == null)
                list+= current.getValue();
            else
                list += current.getValue() + " -> ";
            current = current.getNext();
        }
        return list;
    }
}