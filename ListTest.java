package Module_EE_01;

import java.util.*;

/**
 * Created by Andrey on 31.05.2016.
 */
public class ListTest {

    private List collection = null;

    public ListTest(List collection) {
        this.collection = collection;
    }

    public double addWithElapsedTime() {
        double elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            long beginMark = System.nanoTime();
            collection.add(i);
            long endMark = System.nanoTime();
            elapsedTime += (endMark - beginMark)/1000.;
        }
        elapsedTime = elapsedTime / 100;
        return elapsedTime;
    }

    public double getWithElapsedTime() {
        double elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            long beginMark = System.nanoTime();
            collection.get(i);
            long endMark = System.nanoTime();
            elapsedTime += (endMark - beginMark) / 1000.;
        }
        elapsedTime = elapsedTime / 100;
        return elapsedTime;
    }

    public double removeWithElapsedTime(){
        double elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            long beginMark = System.nanoTime();
            collection.remove(i);
            long endMark = System.nanoTime();
            elapsedTime += (endMark - beginMark) / 1000.;
        }
        elapsedTime = elapsedTime / 100;
        return elapsedTime;
    }

    public double containsWithElapsedTime(){
        double elapsedTime = 0;
        for (int i = 0; i < 100; i++) {
            long beginMark = System.nanoTime();
            collection.contains(i);
            long endMark = System.nanoTime();
            elapsedTime += (endMark - beginMark) / 1000.;
        }
        elapsedTime = elapsedTime / 100;
        return elapsedTime;
    }


    public double listIteratorAddWithElapsedTime(){
        double elapsedTime = 0;
        ListIterator<Integer> iterator = collection.listIterator();
        for (int i = 0; i < 100; i++) {
            long beginMark = System.nanoTime();
            iterator.add(i*2);
            long endMark = System.nanoTime();
            elapsedTime += (endMark - beginMark) / 1000.;
        }
        elapsedTime = elapsedTime / 100;
        return elapsedTime;
    }


    public double listIteratorRemoveWithElapsedTime(){
        double elapsedTime = 0;
        ListIterator<String> iterator = collection.listIterator();
        for (int i = 0; i < 100; i++) {
            long beginMark = System.nanoTime();
            iterator.next();
            iterator.remove();
            long endMark = System.nanoTime();
            elapsedTime += (endMark - beginMark) / 1000.;
        }
        return elapsedTime;
    }

    public double populateWithElapsedTime(int countObj){
        long beginMark = System.nanoTime();
        for (int i = 0; i < countObj; i++) {
            collection.add(i);
        }
        long endMark = System.nanoTime();
        double elapsedTime = (endMark - beginMark)/1000.;
        return elapsedTime;
    }



    public Map<String, Double> testClass(int countObj){
        Map<String, Double> result = new TreeMap<String, Double>();
        result.put("populate", populateWithElapsedTime(countObj));
        result.put("remove", removeWithElapsedTime());
        result.put("add", addWithElapsedTime());
        result.put("get", getWithElapsedTime());
        result.put("contains", containsWithElapsedTime());
        result.put("iterator.add", listIteratorAddWithElapsedTime());
        result.put("iterator.remove", listIteratorRemoveWithElapsedTime());
        return result;
    }


}
