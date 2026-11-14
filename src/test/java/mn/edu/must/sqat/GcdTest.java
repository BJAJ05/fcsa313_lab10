package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GcdTest {
    @Test
    @DisplayName("G1 gcd(7,0)=7, 0 iter: x 13->20, y 13->15(F)")
    void gcd_7_0_zeroIter_returns7() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("G2 gcd(0,5)=5, 1 iter: x 13->16, x 17->20, y 13->15(T), y 13->16, y 13->17, y 18->15(F), tmp 16->18")
    void gcd_0_5_oneIter_returns5() {
        assertEquals(5, DataFlowTargets.gcd(0, 5));
    }

    @Test
    @DisplayName("G3 gcd(12,8)=4, 2 iter: x 13->16, x 17->16, x 17->20, y 13->15(T), y 13->16, y 13->17, "
            + "y 18->15(T,F), y 18->16, y 18->17, tmp 16->18")
    void gcd_12_8_twoIter_returns4() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }
}
