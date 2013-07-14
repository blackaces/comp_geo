package DataStructures;

//TODO: write javaDoc comments for each method as well as the class

/**
 * Created with IntelliJ IDEA.
 * User: ben
 * Date: 7/14/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Heap implements Cloneable {
  private static Point[] heap;
  private static int heapSize;
  private final static int maxHeapSize = 100000;

  public Heap(Point[] points) {
    heapSize = 0;
    heap = new Point[maxHeapSize];
    buildHeap(points);
  }

  public static void buildHeap(Point[] points) {
    for (Point pt : points) {
      insert(pt);
    }
  }

  public static boolean insert(Point pnt) {
    if (heapSize == maxHeapSize) {
      return false;
    }

    heap[heapSize] = pnt;
    siftUp(heapSize++);
    return true;
  }

  private static void siftUp(int idx) {
    int parent = parent(idx);
    Point bottom = heap[idx];


    while (idx > 0 && heap[parent].getPolarAngle() < bottom.getPolarAngle()) {
      heap[idx] = heap[parent];
      parent = (parent - 1) / 2;
    }
    heap[idx] = bottom;
  }

  private Point remove() {
    Point root = heap[0];
    heap[0] = heap[--heapSize];
    siftDown(0);
    return root;
  }

  private void siftDown(int idx) {
    int largerChild;
    Point top = heap[idx];
    while (idx < heapSize / 2) {
      int l = left(idx);
      int r = right(idx);

      if (r < heapSize && heap[l].getPolarAngle() < heap[r].getPolarAngle()) {
        largerChild = r;
      } else
        largerChild = l;

      if (top.getPolarAngle() >= heap[largerChild].getPolarAngle()) {
        break;
      }

      heap[idx] = heap[largerChild];
      idx = largerChild;
    }
    heap[idx] = top;
  }

  private static int left(int idx) {

    return 2 * idx;
  }

  private static int right(int i) {

    return 2 * i + 1;
  }

  private static int parent(int i) {
    return (int) Math.floor(i / 2);
  }

  public Point[] toArray() {
    Point[] tempHeap = new Point[maxHeapSize];
    for (int idx = 0; idx < maxHeapSize; idx++) {
      tempHeap[idx] = heap[idx];
    }
    return tempHeap;
  }

  public Heap clone() throws CloneNotSupportedException {
    Heap temp = new Heap(this.toArray());
    return temp;
  }
}
