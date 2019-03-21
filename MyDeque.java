public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
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
    String ans = "";
    for (int i=0; i<size-1; i++){
      ans += data[i] + ",";
    }
    ans += data[size-1];
    return ans;
  }

  public void addFirst(E element){

  }

  public void addLast(E element){

  }

  public E removeFirst(){
    return data[0];
  }

  public E removeLast(){
    return data[0];
  }

  public E getFirst(){
    return data[0];
  }

  public E getLast(){
    return data[0];
  }
}
