interface I {
    public String helloworlD();
}
class A implements I {
    int ss = 1;
    public String helloworlD(){
        return ss + "";
    }
    public String howl(){
        return "A";
    }

}
class B extends A {
    int ss = 2;
}
class C extends B{
    int ss = 3;
}
class D extends C{
    int ss = 4;
}

