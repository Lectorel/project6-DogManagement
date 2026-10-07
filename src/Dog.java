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

  public void getID(int numberID){
    return numberID;
  }

  public void setName(String name){
    if(!n.startsWith(" ")){
      this.name = name;
    }
  }

  public void getName(String name){
    return name;
  }

  public void setWeight(double weight){
    this.weight = weight;
  }

  public void getWeight(double weight){
    return weight;
  }

  public void setAge(int age){
    if(a < 33){
      this.age = age;
    }
  }

  public void getAge(int age) {
    return age;
  }

}

