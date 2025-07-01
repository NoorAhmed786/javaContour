//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main  extends  Thread{
    public static void main(String[] args) {

            for( int i = 0 ; i < 5 ; i++) {
                int b=i;
                Runnable runnable = new Runnable() {

                    @Override
                    public void run() {
                        System.out.println("haider"+b);

                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }

    }

}