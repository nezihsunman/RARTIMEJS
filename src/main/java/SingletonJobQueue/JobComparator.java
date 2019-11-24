package SingletonJobQueue;

import java.util.Comparator;

public class JobComparator implements Comparator<AbstractJob> {
    public int compare(AbstractJob j1, AbstractJob j2) {
        if (j1.priority < j2.priority) {
            return 1;
        }

        else if (j1.priority < j2.priority) {
            return -1;
        }

        return 0;

    }
}
