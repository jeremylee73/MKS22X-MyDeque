public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] vals = s.split(" ", -1);
      MyDeque<Double> deque = new MyDeque<Double>();
      for (int i=0; i<vals.length; i++){
        if (vals[i] != "*" && vals[i] != "/" && vals[i] != "+" && vals[i] != "-"){
          deque.addLast(Double.parseDouble(vals[i]));
        } else {
          if (vals[i] == "*"){

          }
        }
      }
      return 0;
    }
}
