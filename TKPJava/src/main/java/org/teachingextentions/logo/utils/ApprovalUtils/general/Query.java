package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;


import java.util.ArrayList;
import java.util.List;

public class Query {

    public static <In> List<In> where(In[] list, Function1<In, Boolean> predicate) {
        ArrayList<In> out = new ArrayList<>();
        for (In i : list) {
            if (predicate.call(i)) {
                out.add(i);
            }
        }
        return out;
    }

}
