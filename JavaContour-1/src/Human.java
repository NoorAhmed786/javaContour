public class Human {
    private String name;
    private int age;

    public Human(){
        this.name="";
        this.age=0;
    }
    public Human(String name, int age){
        this.name=name;
        if(age>0){
            this.age=age;

        }else {
            this.age=0;
        }
    }
    public Human (String name){
        this.name=name;
    }

    public String getName(){
        return this.name;

    }
    public int getAge(){
        return this.age;
    }
    public void setName(String name){
        this.name=name;

    }

    public void setAge(int age) {
        this.age = age;
    }

}
