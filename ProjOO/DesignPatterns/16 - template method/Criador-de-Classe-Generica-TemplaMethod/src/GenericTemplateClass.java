public abstract class GenericTemplateClass {
  String name;
  int value1;
  int value2;
  
  public void printInfo() {};
  
  public void setInfo(String name, int value1, int value2) {
    this.name = name;
    this.value1 = value1;
    this.value2 = value2;
  }
  
}