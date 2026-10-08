public class Dog {
  private int numberID;
  private String name;
  private double weight;
  private int age;

  public Dog (int nu, String na, double we, int ag){
    nu = numberID;
    na = name;
    we = weight;
    ag = age;
  }
  
  public void setID(int numberID){
    this.numberID = numberID;
  }

  public int getID(){
    return numberID;
  }

  public void setName(String name){
    if(!name.startsWith(" ")){
      this.name = name;
    }
  }

  public String getName(){
    return name;
  }

  public void setWeight(double weight){
    this.weight = weight;
  }

  public double getWeight(){
    return weight;
  }

  public void setAge(int age){
    if(age < 33){
      this.age = age;
    }
  }

  public int getAge() {
    return age;
  }

}

