public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] vals = s.split(" ", -1);
      MyDeque<Double> deque = new MyDeque<Double>();
      for (int i=0; i<vals.length; i++){
        if (!(vals[i].equals("*")) && !(vals[i].equals("/")) && !(vals[i].equals("+")) && !(vals[i].equals("-")) && !(vals[i].equals("%"))){
          deque.addLast(Double.parseDouble(vals[i]));
        } else {
          Double newVal;
          Double v2 = deque.removeLast();
          Double v1 = deque.removeLast();
          if (vals[i].equals("*")){
            newVal = v1 * v2;
          } else if (vals[i].equals("/")){
            newVal = v1 / v2;
          } else if (vals[i].equals("-")){
            newVal = v1 - v2;
          } else if (vals[i].equals("%")){
            newVal = v1 % v2;
          } else{
            newVal = v1 + v2;
          }
          deque.addLast(newVal);
        }
      }
      return deque.removeLast();
    }

    public static void main(String[] args){
      System.out.println(eval("10 2.0 /")); // 5.0
      System.out.println(eval("10 2.0 +")); // 12.0
      System.out.println(eval("11 3 - 4 + 2.5 *")); // 30.0
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); // 893.0
      System.out.println(eval("1 2 3 4 5 + * - -")); // 26.0
    }
}
