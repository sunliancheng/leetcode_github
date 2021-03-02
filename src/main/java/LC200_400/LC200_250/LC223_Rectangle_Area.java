package LC200_400.LC200_250;

public class LC223_Rectangle_Area {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap = 0;
        // two window does not overlaps if ones start is greater thatn the others end
        if(!(C < E || A > G || D < F || B > H)){
            int h = Math.min(D, H) -Math.max(B,F);
            int l = Math.min(C, G) -Math.max(A,E);
            overlap = h*l;
        }
        // area 1 + area2 - common area
        return (C-A) *(D -B) + (G -E)*(H -F) - overlap;
    }

}
