package lab1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

  public static void main(String[] args) throws Exception {
    String filePath = "C:\\Users\\mo chen\\workspace\\Lab4\\Data.txt";

    String filePathTo = "C:\\Users\\mo chen\\workspace\\Lab4\\To.txt";

    EdgeWeightedDigraph.init(filePath, filePathTo);
    System.out.println("==================init accomplished=====");
    EdgeWeightedDigraph  ewd = new EdgeWeightedDigraph(new Scanner(new BufferedInputStream(
        new FileInputStream(new File(filePathTo)))));

    System.out.println("Reversed Map:");
    HashMap<Integer, String> map = EdgeWeightedDigraph.getReversedMap();
    Set<Integer> set = map.keySet();
    for (Integer key : set) {
      System.out.println(key + "-->" + map.get(key));

    }
    System.out.println("======================================");
    System.out.println(ewd);
    System.out.println("============Dijkstra Test begins===========");
    EdgeWeightedDigraph.getDijkstraSP(ewd, "To");
    System.out.println("============Dijkstra Test ends===========");
    System.out.println("============Dijkstra between Two Nodes Test begins===========");
    EdgeWeightedDigraph.getDijkstraBetweenTwoNodes(ewd, "To", "civilizations");

    System.out.println("============Dijkstra between Two Nodes Test ends===========");


    System.out.println("============RandomWalk Test begins===========");
    EdgeWeightedDigraph.randomWalk(ewd);
    System.out.println("============RandomWalk Test ends===========");

    System.out.println("============GUI TEST begins=============");
    EdgeWeightedDigraph.getGUI4Graph(ewd);
    System.out.println("============GUI TEST ends=============");

    System.out.println("======================================");
    System.out.println(EdgeWeightedDigraph.queryBridgeWords(ewd, "To", "strange"));
    //        System.out.println("======================================");
    //        System.out.println(EdgeWeightedDigraph.queryBridgeWords_new(EWD, "To", "strange"));
    System.out.println("======================================");
    System.out.println(EdgeWeightedDigraph.generateNewText(ewd, EdgeWeightedDigraph.getInput()));
    System.out.println("======================================");
  }

}
