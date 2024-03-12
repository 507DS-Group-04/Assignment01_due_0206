import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// if the tree is not a binary tree
public class TreeCity {
    String name;
    List<TreeCity> towns;

    public TreeCity(String cityName){
        this.name = cityName;
        this.towns = new ArrayList<>();
    }

    public void addTown(TreeCity town){
        towns.add(town);
    }

    public static void main(String[] args) {

        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        // generate 10 cities
        TreeCity capital = new TreeCity("Capital");
        TreeCity cityM = new TreeCity("M");
        TreeCity StackMaster = new TreeCity("Stack Master");
        TreeCity van = new TreeCity("Vancouver");
        TreeCity burnaby = new TreeCity("Burnaby");
        TreeCity BC = new TreeCity("British Columbia");
        TreeCity downtown = new TreeCity("Down Town");
        TreeCity west_van = new TreeCity("West Vancouver");
        TreeCity north_van = new TreeCity("North Vancouver");
        TreeCity surrey = new TreeCity("Surrey");

        capital.addTown(StackMaster);
        capital.addTown(cityM);
        capital.addTown(BC);

        cityM.addTown(van);
        cityM.addTown(burnaby);
        cityM.addTown(surrey);

        van.addTown(downtown);
        van.addTown(west_van);
        van.addTown(north_van);

        //select a city
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a city name: ");
        String inputCity = scanner.nextLine();

        TreeCity printCity = findCity(capital, inputCity);
        int depth = calculateDepth(capital, printCity);
        int height = calculateHeight(printCity);

        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long endTime = System.nanoTime ();

        System.out.println("Input City is " + inputCity + " Depth is " + depth + " Height is " + height);
        System.out.println("time is->" +  (endTime - startTime)/1000000 + "ms mem is=->" + (afterUsedMem - beforeUsedMem) + "bytes");


    }

    //find city
    static TreeCity findCity(TreeCity cur, String userInput){
        if (cur.name.equals(userInput)){
            return cur;
        }

        for (TreeCity town : cur.towns){
            TreeCity find = findCity(town, userInput);
            if (find != null){
                return find;
            }
        }
        return null;
    }
    //find parent
    static TreeCity findParent(TreeCity cur, TreeCity child){
        for (TreeCity town : cur.towns){

            if (town == child){
                return cur;
            }
            TreeCity parent = findParent(town, child);
            if (parent != null){
                return parent;
            }
        }

        return null;
    }
    //calculateDepth
    static int calculateDepth(TreeCity root, TreeCity inputCity){
        if (root == inputCity){
            return 0;
        }
        return 1 + calculateDepth(root, findParent(root, inputCity));
    }

    //calculateHeight
    static int calculateHeight(TreeCity inputCity){
        if ( inputCity.towns.isEmpty()){
            return 0;
        }
        int maxHeight = 0;
        for (TreeCity town : inputCity.towns){
            int height = calculateHeight(town);
            maxHeight = Math.max(maxHeight, height);
        }
        return 1 + maxHeight;
    }





}
