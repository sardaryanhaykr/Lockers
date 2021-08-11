package UnisexBathroom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 09.08.2021.
 */
public class TastUnisexBathroom {
    public static void main(String[] args) {
        Bathroom bathroom=new Bathroom();

        List<Thread> peoples=new ArrayList<>();
        peoples.add(new Male(bathroom,"Hayk"));
        peoples.add(new Male(bathroom,"Gevorg"));
        peoples.add(new Female(bathroom,"Anna"));
        peoples.add(new Female(bathroom,"Ani"));
        peoples.add(new Male(bathroom,"Karen"));
        peoples.add(new Male(bathroom,"Armen"));
        peoples.add(new Female(bathroom,"Gohar"));
        peoples.add(new Female(bathroom,"Tatev"));
        peoples.add(new Male(bathroom,"Vardan"));
        peoples.add(new Female(bathroom,"Lusi"));
        peoples.add(new Female(bathroom,"Hasmik"));
        for (Thread thread:peoples) {
            thread.start();
        }
    }
}
