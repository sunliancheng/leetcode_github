package LC0_200.LC150_200;

public class LC165_Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");

        int i = 0;
        for (; i < (vers1.length < vers2.length ? vers1.length : vers2.length); ++i) {
            if (Integer.valueOf(vers1[i]) > Integer.valueOf(vers2[i])) {
                return 1;
            } else if (Integer.valueOf(vers1[i]) < Integer.valueOf(vers2[i]))
                return -1;
        }

        if (i >= vers1.length) {
            for (int j = i; j < vers2.length; ++j)
                if (Integer.valueOf(vers2[j]) > 0)
                    return -1;
        } else
            for (int j = i; j < vers1.length; ++j)
                if (Integer.valueOf(vers1[j]) > 0)
                    return 1;
        return 0;
    }
}
