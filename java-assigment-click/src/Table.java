public class Table {
  public static String getTable(int num){
      StringBuilder builder = new StringBuilder();
      for(int i=1;i<num;i++){
          builder.append(num).append("X").append(i).append("=").append(i*num);
          if(i!= 10){
              builder.append("\n");

          }
      }
      return builder.toString();
  }
}
