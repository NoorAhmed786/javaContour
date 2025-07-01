public class GradeCalculator {
    public static String finalGrade(int exam){
        if(exam >= 80 && exam >= 90 && exam <= 100){
            return "A"+"you are passing";
        }else if(exam >= 70){
            return "B"+"you are passing";
        } else if (exam >= 60) {
            return "B"+"you are passing";
            
        }else if(exam >= 50) {
            return "C"+"you are passing";
        }else {
            return "fail";
        }
    }

}
