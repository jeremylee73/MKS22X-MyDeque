import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 10;
    start = 0;
    end = 0;
  }

  public MyDeque(int initialCapacity){
    size = initialCapacity;
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size];
    data = d;
    start = 0;
    end = 0;
  }

  public int size(){
    if (end >= start){
      return end - start;
    }
    return (size - end) + start;
  }

  public String toString(){
    String ans = "{";
    if (start == end){
      return "{}";
    }
    if (end > start){
      for (int i=start; i<end; i++){
        ans += data[i] + " ";
      }
    } else {
      for (int i=start; i<size; i++){
        ans += data[i] + " ";
      }
      for (int i=0; i<end; i++){
        ans += data[i] + " ";
      }
    }
    ans += "}";
    return ans;
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] newData = (E[])new Object[size*2];
    int count = 0;
    if (end >= start){
      for (int i=start; i<end; i++){
        newData[count] = data[i];
        count++;
      }
    } else {
      for (int i=start; i<size; i++){
        newData[count] = data[i];
        count++;
      }
      for (int i=0; i<end; i++){
        newData[count] = data[i];
        count++;
      }
    }
    start = 0;
    end = size;
    size = size * 2;
    data = newData;
  }

  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException();
    }
    if (end == size || end == start){
      resize();
    }
    if (start == 0){
      for (int i=end; i>=1; i--){
        data[i] = data[i-1];
      }
      data[0] = null;
      start++;
      end++;
    }
    start--;
    data[start] = element;
  }

  public void addLast(E element){
    if (element == null){
      throw new NullPointerException();
    }
    if (size() == 0){
      end++;
      data[end-1] = element;
    } else {
      if (end == size || end == start){
        resize();
      }
      end++;
      data[end-1] = element;
    }
  }

  public E removeFirst(){
    if (start == end){
      throw new NoSuchElementException();
    }
    E temp = data[start];
    data[start] = null;
    if (start < size - 1){
      start++;
    } else {
      start = 0;
    }
    return temp;
  }

  public E removeLast(){
    if (size() == 0){
      throw new NoSuchElementException();
    }
    E temp = data[end-1];
    data[end-1] = null;
    end--;
    return temp;
  }

  public E getFirst(){
    if (start == end){
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast(){
    if (start == end){
      throw new NoSuchElementException();
    }
    return data[end-1];
  }

  public static void main(String[] args){
    MyDeque<Integer> test = new MyDeque<Integer>();
    System.out.println(test);
    test.addFirst(2);
    for (int i=0; i<10; i++){
      test.addLast(3);
    }
    System.out.println("Start:"+test.start+" End:"+test.end);
    System.out.println(test);
  }
}
