package LC0_200.LC50_100;

import java.util.ArrayList;
import java.util.List;

public class LC93_Restore_IP_Addresses {

    private List<String> result = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {


        return null;
    }

    /**
     *
     *  @param hasUsed   in the current part of IP segment, how many Characters has been used
     *  @param s   the IP string
     *  @param index   there are 4 parts of IP segments, index represents which part is currently used
     */
    public void backTrace(String s, int index, int hasUsed) {

        // the max left length is larger, so it cannot be restored to a IP address
        if ((4 - index) * 3 + 3 - hasUsed < s.length())
            return;

    }

}
