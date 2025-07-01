//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
          Table table=new Table();
          int num = 2;
        String table1 = table.getTable(num);
        System.out.println(table1);

//        DrinkTable
        int num2 = 17;
        DrinkTime drinkTime = new DrinkTime();
        String intake=drinkTime.drinkTimeTable(num2);
        System.out.println(intake);

//        GradeCalculator
        int num3 = 80;
        GradeCalculator gradeCalculator = new GradeCalculator();
        String grade=gradeCalculator.finalGrade(num3);
        System.out.println(grade);

//        simple calculator
        int calc1= 4;
        int calc2= 5;
        String operator="+";
        SimpleCAlculator simpleCAlculator = new SimpleCAlculator();
        String calculate = simpleCAlculator.calculate(calc1, calc2, operator);
        System.out.println(calculate);


    }
}