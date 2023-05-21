import java.util.*;
import java.io.*;
//AllCrafts filters an array of the entire database to fit what results the user wants. It then outputs the results. 
public class AllCrafts {
    // instance variable
    private ArrayList<Craft> list;
    private String instr;
    private int counter;
    // constructor
    public AllCrafts() {
        list = new ArrayList<Craft>();
        instr = "";
        counter = 0;
        try{
            String s = "Data.txt";
            Scanner file = new Scanner(new File(s));
            while(file.hasNextLine()) {
                String line = file.nextLine();
                process(line);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void process(String s) {
            Scanner input = new Scanner(s);
            String name = input.next();
            String diff = input.next();
            int num = input.nextInt();
            ArrayList<Material> list1 = new ArrayList<Material>();
            String mat;
            int q;
            while(num != 0) {
                mat = input.next();
                q = input.nextInt();
                list1.add(new Material(mat, q));
                num--;
            }
            String cat = input.next();            
            String subcat = input.next();
            String instr = input.next();
            Craft c = new Craft(name, diff, list1, cat, subcat, instr);
            list.add(c);
            input.close();
            
        }
    
    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.print("Pick a difficulty level(B for Beginner, I for Intermediate, A for Advanced , or BIA for All)\nDifficulty: ");
        String level = input.nextLine();
        String level2 = "";
        if (!level.equalsIgnoreCase("BIA"))
        {
            System.out.print("Would you like to choose another level (Y/N)?: ");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                 System.out.print("Pick a difficulty level(B for Beginner, I for Intermediate, A for Advanced\nDifficulty: ");
                 level2 = input.nextLine();
            }
        }
        removeDiff(level, level2);

        System.out.print("Would you like to search crafts by a keyword?(Y/N): ");
        String s2 = input.nextLine();
        if(s2.equals("Y")) {
            System.out.print("Enter keyword:");
            String key = input.nextLine();
            String ans = searchKey(key);
            System.out.println(ans);
            if (!(ans.contains("Sorry"))) {
            System.out.println("\nNice choices! We have compiled some crafts that we think you'll love! Pick one of these to see what you'll need");
            String c = input.nextLine();
                ArrayList<Material> mList = new ArrayList<Material>();
                for(int i = 0; i < list.size(); i++) {
                    if(list.get(i).getName().equals(c)) {
                        int num = list.get(i).getMaterial().size();
                        int j = 0;
                        while(num != 0) { 
                            System.out.println("How much " + list.get(i).getMaterial().get(j).getName() + " do you have?");
                            int q = input.nextInt();
                            mList.add(new Material(list.get(i).getMaterial().get(j).getName(), q));
                            j++;
                            num--;
                        }
                        printList(list.get(i), mList);
                    }
                }
                }

        } else {
        System.out.println("Out of these categories, which one do you like?");
        System.out.print("1. Seasonal Crafts\n2. Origami\n3. Yarn Crafts\n4. Jewelry\n5. Pottery \n6. Painting\nChoose a number that corresponds with the category: ");
        int category = input.nextInt();

        if (category == 1) {
            System.out.println("Seasonal Crafts: \nValentines Day \nChristmas\nEaster\nHalloween\nAll");
            input.nextLine();
            String ans = input.nextLine();
            for(int i  = 0; i < list.size(); i++)
            {
                if(list.get(i).getCategories().equals(ans))
                    System.out.print(list.get(i).getName() + ", ");
            }
            System.out.println("\nNice choices! We have compiled some crafts that we think you'll love! Pick one of these to see what you'll need");
            String choice = input.nextLine();
            ArrayList<Material> mList = new ArrayList<Material>();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getName().equalsIgnoreCase(choice)) {
                    int num = list.get(i).getMaterial().size();
                    int j = 0;
                    while(num != 0) { 
                        System.out.println("How much " + list.get(i).getMaterial().get(j).getName() + " do you have?");
                        int q = input.nextInt();
                        mList.add(new Material(list.get(i).getMaterial().get(j).getName(), q));
                        j++;
                        num--;
                    }
                    printList(list.get(i), mList);
                }
            }
            
        }
        if (category == 2) {
            System.out.println("Origami:\nAnimals \nMisc.\nAll");
            input.nextLine();
            String ans = input.nextLine();
            for(int i  = 0; i < list.size(); i++)
            {
                if(list.get(i).getCategories().equalsIgnoreCase(ans))
                    System.out.print(list.get(i).getName() + ", ");
            }
            System.out.println("\nNice choices! We have compiled some crafts that we think you'll love! Pick one of these to see what you'll need");
            String choice = input.nextLine();
            ArrayList<Material> mList = new ArrayList<Material>();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getName().equals(choice)) {
                    int num = list.get(i).getMaterial().size();
                    int j = 0;
                    while(num != 0) { 
                        System.out.println("How much " + list.get(i).getMaterial().get(j).getName() + " do you have?");
                        int q = input.nextInt();
                        mList.add(new Material(list.get(i).getMaterial().get(j).getName(), q));
                        j++;
                        num--;
                    }
                    printList(list.get(i), mList);
                }
            }
            
            
        }
        if (category == 3) {
            System.out.println("Yarn Crafts:\nCrochet\nKnitting\nMisc.\nAll");
            input.nextLine();
            String ans = input.nextLine();
            for(int i  = 0; i < list.size(); i++)
            {
                if(list.get(i).getCategories().equalsIgnoreCase(ans))
                    System.out.print(list.get(i).getName() + ", ");
            }
            System.out.println("\nNice choices! We have compiled some crafts that we think you'll love! Pick one of these to see what you'll need");
            String choice = input.nextLine();
            ArrayList<Material> mList = new ArrayList<Material>();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getName().equalsIgnoreCase(choice)) {
                    int num = list.get(i).getMaterial().size();
                    int j = 0;
                    while(num != 0) { 
                        System.out.println("How much " + list.get(i).getMaterial().get(j).getName() + " do you have?");
                        int q = input.nextInt();
                        mList.add(new Material(list.get(i).getMaterial().get(j).getName(), q));
                        j++;
                        num--;
                    }
                    printList(list.get(i), mList);
                }
            }
            
        }
        if (category == 4) {
            System.out.println("Jewlery:\nBracelet\nNecklace\nAll");
            input.nextLine();
            String ans = input.nextLine();
            for(int i  = 0; i < list.size(); i++)
            {
                if(list.get(i).getCategories().equalsIgnoreCase(ans))
                    System.out.print(list.get(i).getName() + ", ");
            }
            System.out.println("\nNice choices! We have compiled some crafts that we think you'll love! Pick one of these to see what you'll need: ");
            String choice = input.nextLine();
            ArrayList<Material> mList = new ArrayList<Material>();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getName().equalsIgnoreCase(choice)) {
                    int num = list.get(i).getMaterial().size();
                    int j = 0;
                    while(num != 0) { 
                        System.out.println("How much " + list.get(i).getMaterial().get(j).getName() + " do you have?");
                        int q = input.nextInt();
                        mList.add(new Material(list.get(i).getMaterial().get(j).getName(), q));
                        j++;
                        num--;
                    }
                    printList(list.get(i), mList);
                }
            }
        }
        if (category == 5) {
            System.out.println("Pottery:\nHolder\nMisc.");
            input.nextLine();
            String ans = input.nextLine();
            for(int i  = 0; i < list.size(); i++)
            {
                if(list.get(i).getCategories().equalsIgnoreCase(ans))
                    System.out.print(list.get(i).getName() + ", ");
            }
            System.out.println("\nNice choices! We have compiled some crafts that we think you'll love! Pick one of these to see what you'll need: ");
            String choice = input.nextLine();
            ArrayList<Material> mList = new ArrayList<Material>();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getName().equalsIgnoreCase(choice)) {
                    int num = list.get(i).getMaterial().size();
                    int j = 0;
                    while(num != 0) { 
                        System.out.println("How much " + list.get(i).getMaterial().get(j).getName() + " do you have?");
                        int q = input.nextInt();
                        mList.add(new Material(list.get(i).getMaterial().get(j).getName(), q));
                        j++;
                        num--;
                    }
                    printList(list.get(i), mList);
                }
            }
        }
        if (category == 6) {
            System.out.println("Painting:\nAcrylic\nWatercolor\n");
            input.nextLine();
            String ans = input.nextLine();
            for(int i  = 0; i < list.size(); i++)
            {
                if(list.get(i).getCategories().equalsIgnoreCase(ans))
                    System.out.print(list.get(i).getName() + ", ");
            }
            System.out.println("\nNice choices! We have compiled some crafts that we think you'll love! Pick one of these to see what you'll need: ");
            String choice = input.nextLine();
            ArrayList<Material> mList = new ArrayList<Material>();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getName().equalsIgnoreCase(choice)) {
                    int num = list.get(i).getMaterial().size();
                    int j = 0;
                    while(num != 0) { 
                        System.out.println("How much " + list.get(i).getMaterial().get(j).getName() + " do you have?");
                        int q = input.nextInt();
                        mList.add(new Material(list.get(i).getMaterial().get(j).getName(), q));
                        j++;
                        num--;
                    }
                    printList(list.get(i), mList);
                }
            }
        }
        if (category == 7) {
            System.out.println("Seasonal Crafts:\nValentinesDay\nChristmas\nHalloween");
            input.nextLine();
            String ans = input.nextLine();
            for(int i  = 0; i < list.size(); i++)
            {
                if(list.get(i).getCategories().equalsIgnoreCase(ans))
                    System.out.print(list.get(i).getName() + ", ");
            }
            System.out.println("\nNice choices! We have compiled some crafts that we think you'll love! Pick one of these to see what you'll need: ");
            String choice = input.nextLine();
            ArrayList<Material> mList = new ArrayList<Material>();
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getName().equalsIgnoreCase(choice)) {
                    int num = list.get(i).getMaterial().size();
                    int j = 0;
                    while(num != 0) { 
                        System.out.println("How much " + list.get(i).getMaterial().get(j).getName() + " do you have?");
                        int q = input.nextInt();
                        mList.add(new Material(list.get(i).getMaterial().get(j).getName(), q));
                        j++;
                        num--;
                    }
                    printList(list.get(i), mList);
                }
            }
        }
    }
    }
    public void printList(Craft c, ArrayList<Material> m) {
        String result = "You need:\n";
        for(int i = 0; i < m.size(); i++) {
            if(!(c.getMaterial().get(i).getAmount() - m.get(i).getAmount() <= 0)) {
                result +=  "You need -> " + Math.abs(c.getMaterial().get(i).getAmount() - m.get(i).getAmount()) + " " + m.get(i).getName();
                result += "\n";
            } else {
                result += "You don't need anymore " + m.get(i).getName() + "!" + "\n";
            }
    
        }
        System.out.println(result);
        System.out.println("To make this craft, check out " + c.getLink());
    }
    public void removeDiff(String one, String two) {
        for (int i = list.size() - 1; i >= 0; i--)
        {   
            
            if(!(one.equalsIgnoreCase("BIA")) && (!(list.get(i).getDiffLevel().equalsIgnoreCase(one) || list.get(i).getDiffLevel().equalsIgnoreCase(two))))
            {
                list.remove(i);
            }
        }

    }
    public String searchKey(String key) {
        String result = "";
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().contains(key)) {
                result += list.get(i).getName() + ",";
            }
        }
        if (result.length() == 0) {
            return "Sorry! There are no crafts in our database that correspond to that keyword.";
        }
        return result;
    }
}
