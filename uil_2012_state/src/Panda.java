class Panda{
    public String name;
    int i;
    public Panda(){
        this.name = "Jerry";
        i = 212;
    }
    public String toString(){
        return name;
    }
}
class RedPanda extends Panda{
    public String name;
    public String color;
    int i;
    public RedPanda(String name, String color){
        this.name = name;
        this.color = color;
        this.i = 3;
    }
    public String toString(){
        return name + " " + color;
    }
}