/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airportsimulator;

/**
 *
 * @author Marius Geitle
 */
public class Queue<T> {
    
    private QueueItem<T> firstItem = null;
    private QueueItem<T> lastItem = null;
    private int _size = 0;
    
    public void enqueue(T item){
        QueueItem<T> queueItem = new QueueItem<>();
        queueItem.item = item;
        if(lastItem != null)
            lastItem.nextItem = queueItem;
        
        lastItem = queueItem;
        
        if(firstItem == null)
            firstItem = lastItem;
        
        this._size++;
    }
    
    public T dequeue() {
        if(firstItem == null) {
            return null;
        }
        
        QueueItem<T> queueItem = firstItem;
        firstItem = queueItem.nextItem;
        
        if(firstItem == null)
            lastItem = null;
        
        this._size--;
        return queueItem.item;
    }
    
    public T peek() {
        return lastItem == null ? null : lastItem.item;
    }
    
    public int size() {
        return this._size;
    }
    
    private class QueueItem<T> {
        public QueueItem<T> nextItem;
        public T item;
    }
}
