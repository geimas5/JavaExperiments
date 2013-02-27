/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import airportsimulator.Queue;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marius Geitle
 */
public class QueueTests {
    
    @Test
    public void Dequeue_item_threeItems() {
        Queue<String> queue = new Queue<>();
        String item1 = "item1";
        String item2 = "item2";
        String item3 = "item3";
        queue.enqueue(item1);
        queue.enqueue(item2);
        queue.enqueue(item3);
        
        Assert.assertEquals(item1, queue.dequeue());
        Assert.assertEquals(item2, queue.dequeue());
        Assert.assertEquals(item3, queue.dequeue());
    }
}
