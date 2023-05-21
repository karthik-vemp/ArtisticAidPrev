public class Material
{
    private String matName;
    private int amount;
    public Material(String m, int amt)
    {
        matName = m;
        amount = amt;
    }

    public int getAmount() {
        return amount;
    }
    public String getName() {
        return matName;
    }
    public boolean hasEnough(int amt) {
        if(amount > amt) {
            return true;
        }
        return false;
    } 
    public int computeDiff(int q) {
        return Math.abs(q-amount);
    }
}
