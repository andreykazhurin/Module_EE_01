package Module_EE_01;

import java.io.*;
import java.util.*;

/**
 * Created by Andrey on 31.05.2016.
 */
public class TestClass {
    public static void main(String[] args) {

        ListTest arrayList10000 = new ListTest(new ArrayList<Integer>());
        ListTest arrayList100000 = new ListTest(new ArrayList<Integer>());
        ListTest arrayList1000000 = new ListTest(new ArrayList<Integer>());

        ListTest linkedList10000 = new ListTest(new LinkedList<Integer>());
        ListTest linkedList100000 = new ListTest(new LinkedList<Integer>());
        ListTest linkedList1000000 = new ListTest(new LinkedList<Integer>());

        SetTest hashSet10000 = new SetTest(new HashSet<Integer>());
        SetTest hashSet100000 = new SetTest(new HashSet<Integer>());
        SetTest hashSet1000000 = new SetTest(new HashSet<Integer>());

        SetTest treeSet10000 = new SetTest(new TreeSet<Integer>());
        SetTest treeSet100000 = new SetTest(new TreeSet<Integer>());
        SetTest treeSet1000000 = new SetTest(new TreeSet<Integer>());

        Map<String, Map<String, Double>> result = new TreeMap<String, Map<String, Double>>();

        result.put("ArrayList: 10000 elements",arrayList10000.testClass(10000));
        result.put("ArrayList: 100000 elements",arrayList100000.testClass(100000));
        result.put("ArrayList: 1000000 elements",arrayList1000000.testClass(1000000));

        result.put("LinkedList: 10000 elements",linkedList10000.testClass(10000));
        result.put("LinkedList: 100000 elements",linkedList100000.testClass(100000));
        result.put("LinkedList: 1000000 elements",linkedList1000000.testClass(1000000));

        result.put("HashSet: 10000 elements",hashSet10000.testClass(10000));
        result.put("HashSet: 100000 elements",hashSet100000.testClass(100000));
        result.put("HashSet: 1000000 elements",hashSet1000000.testClass(1000000));

        result.put("TreeSet: 10000 elements",treeSet10000.testClass(10000));
        result.put("TreeSet: 100000 elements",treeSet100000.testClass(100000));
        result.put("TreeSet: 1000000 elements",treeSet1000000.testClass(1000000));

        try {
            outputResult(result);
        }catch (IOException e){
            System.out.print("Smth wrong " + e.getMessage());
            //NOP
        }


    }

    public static void outputResult(Map<String, Map<String, Double>> result) throws IOException {

        File file = new File("result.txt");

        try {


            BufferedWriter out = new BufferedWriter(new FileWriter(file));

            try {


                for(Map.Entry<String, Map<String, Double>> entry : result.entrySet()){

                    out.write(entry.getKey()+"\n");

                    for(Map.Entry<String, Double> nextEntry : entry.getValue().entrySet()){

                        out.write(nextEntry.getKey() + ": " + nextEntry.getValue() + " ms.\n");

                    }

                    out.write("-----------------------------------------------------\n");

                }

            } finally {
                out.flush();
                out.close();
            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        }


    }

}
