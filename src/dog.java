public class Dog {
  private int ID;
  private String name;
  private double weight;
  private int age;

  public void setID(int i){
    ID = i;
  }

  public void getID(){
    return ID;
  }

  public void setName(String n){
    if(!n.startsWith(" ")){
      name = n;
    }
  }

  public void getName(){
    return name;
  }

  public void setWeight(double w){
    weight = w;
  }

  public void getWeight(){
    return weight;
  }

  public void setAge(int a){
    if(a < 33){
      age = a;
    }
  }

  public void getAge() {
    return age;
  }

}

public class 
