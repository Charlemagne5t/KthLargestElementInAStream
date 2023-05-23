import org.example.KthLargest;
import org.junit.Assert;
import org.junit.Test;

public class KthLargestTest {
    @Test
    public void KthLargestConstructorTest(){
        KthLargest kthLargestObject = new KthLargest(3, new int[]{7,1,3,-5,-88,15,15});
        int[] result = {15,15,7};
        Assert.assertArrayEquals(result, kthLargestObject.kLargest);
    }

    @Test
    public void KthLargestAddTest(){
        KthLargest kthLargestObject = new KthLargest(3, new int[]{4, 5, 8, 2});
        //[[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
        kthLargestObject.add(5);

        Assert.assertEquals(5, kthLargestObject.add(10));
    }
    //[[3,[5,-1]],[2],[1],[-1],[3],[4]]
    @Test
    public void KthLargestAddTest2(){
        KthLargest kthLargestObject = new KthLargest(3, new int[]{5, -1});

        Assert.assertEquals(-1, kthLargestObject.add(2));
        Assert.assertEquals(1, kthLargestObject.add(1));
        Assert.assertEquals(1, kthLargestObject.add(-1));
        Assert.assertEquals(2, kthLargestObject.add(3));
        Assert.assertEquals(3, kthLargestObject.add(4));
    }

}

