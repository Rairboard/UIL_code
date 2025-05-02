public interface Plan{
    public int cost(int used);
    public int baseCost();
}
class CallingPlan implements Plan{
    private int cpm;
    private int base;
    public CallingPlan(){
        this(2,10);
    }
    public CallingPlan(int c, int b){
        cpm = c;
        base = b;
    }
    public int cost(int used){
        return base + cpm * used;
    }
    public int baseCost(){
        return base;
    }
    public void priceIncrease(){
        cpm++;
    }
}
class WithBaseMin extends CallingPlan{
    private int baseMin;
    public WithBaseMin(int c, int b, int m){
        super(c,b);
        baseMin = m;
    }
    public int cost(int used){
        int result = 0;
        if(used<=baseMin){
            result = baseCost();
        }
        else
            result= super.cost(used - baseMin);
        return result;
    }
}
class A{
    private int x, y;

}
class B extends A{

}