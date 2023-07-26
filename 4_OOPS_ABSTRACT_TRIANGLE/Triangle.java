class Triangle extends Shape{
  
  private int base;
  private int height;


  public Triangle(int base,int height,String color){
    super(color);
    this.base = base;
    this.height = height;
  }

  public int getBase(){
    return base;

  }

  // // public void setHeight(int height){
  // //   this.height = height;
  // // }

  public int getHeight(){
    return height;
  }

  @Override
  public int getArea(){
    return ((base + height)/2);
  }
}

