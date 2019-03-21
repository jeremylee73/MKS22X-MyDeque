public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 10;
    start = 0;
    end = size-1;
  }

  public MyDeque(int initialCapacity){
    size = initialCapacity;
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size];
    data = d;
    start = 0;
    end = size - 1;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "{";
    for (int i=0; i<size-1; i++){
      ans += data[i] + " ";
    }
    ans += data[size-1] + "}";
    return ans;
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] newData = (E[])new Object[size*2];
    int count = 0;
    if (end >= start){
      for (int i=start; i<=end; i++){
        newData[count] = data[i];
        count++;
      }
    } else {
      for (int i=start; i<size; i++){
        newData[count] = data[i];
        count++;
      }
      for (int i=0; i<=end; i++){
        newData[count] = data[i];
        count++;
      }
    }
    size = size * 2;
    data = newData;
  }

  public void addFirst(E element){
    data[start] = null;
    start++;
  }

  public void addLast(E element){

  }

  public E removeFirst(){
    E temp = data[start];
    data[start] = null;
    if (start <= size - 1){
      start++;
    } else {
      start = 0;
    }
    return temp;
  }

  public E removeLast(){
    E temp = data[end];
    data[end] = null;
    if (end != 0){
      end--;
    } else {
      end = size - 1;
    }
    return temp;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

  public static void main(String[] args){
    MyDeque<Integer> test = new MyDeque<Integer>();
    System.out.println(test);
    test.resize();
    System.out.println(test);
  }
}
