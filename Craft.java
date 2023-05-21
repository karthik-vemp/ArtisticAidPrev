//object class
import java.util.*;
public class Craft
{
    //instance variables
    private String name;
    private String diffLevel;
    private ArrayList<Material> materials;
    private String subcategory;
    private String category;
    private String link;

    //constructor
    public Craft(String n, String d, ArrayList<Material> m, String s, String sc, String l)
    {
        name = n;
        diffLevel = d;
        materials = m;
        category = s;
        subcategory = sc;
        this.link = l;
    }

    public String getName() {
        return name;
    }
    public String getDiffLevel()
    {
        return diffLevel;
    }
    public ArrayList<Material> getMaterial() {
        return materials;
    }
    public String getCategories()
    {
        return subcategory;
    }
     public String getLink() {
        return link;
    }
    public void setLink(String l) {
        this.link = link;
    }
   

}
