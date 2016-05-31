package Module_EE_01;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Andrey on 31.05.2016.
 */
public class SetTest {

    private Set collection = null;

    public SetTest(Set collection) {
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

    public double populateWithElapsedTime(int countObj){
        long beginMark = System.nanoTime();
        for (int i = 0; i < countObj; i++) {
            collection.add(i);
        }
        long endMark = System.nanoTime();
        double elapsedTime = (endMark - beginMark)/1000.;
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

    public Map<String, Double> testClass(int countObj){
        Map<String, Double> result = new TreeMap<String, Double>();
        result.put("populate", populateWithElapsedTime(countObj));
        result.put("remove", removeWithElapsedTime());
        result.put("add", addWithElapsedTime());
        result.put("contains", containsWithElapsedTime());
        return result;
    }

}
