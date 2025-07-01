public class DrinkTime {
    public static String drinkTimeTable(int age){
        if(age<=14){
            return "toddy";
        } else if (age<=18) {
            return "coke";

        }else if (age<=21) {
            return "drink beer";
        }else {
            return "drink wiskey";
        }
    }
}
