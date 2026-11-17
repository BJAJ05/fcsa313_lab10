package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    // ---- All-defs: 2 tests. score@49 needs 50(F), score@51 needs 50(T) - one run cannot do both.

    @Test
    @DisplayName("T1 bonus([1,0,1],5)=0: attendance 31->32, 31->38; threshold 31->32, 31->50; "
            + "present 35->40, 40->40, 40->50; streak 36->41, 41->42, 41->43, 46->41; "
            + "best 37->42, 43->42, 43->53; a 38->39; score 49->56")
    void t1_mixed101_thr5_returns0() {
        assertEquals(0, DataFlowTargets.bonus(new int[] { 1, 0, 1 }, 5));
    }

    @Test
    @DisplayName("T2 bonus([1,1,1,1,1],5)=8: attendance 31->32, 31->38; threshold 31->32, 31->50; "
            + "present 35->40, 40->40, 40->50; streak 36->41, 41->41, 41->42, 41->43; "
            + "best 37->42, 43->42, 43->53; a 38->39; score 51->54, 54->56")
    void t2_run5_thr5_returns8() {
        assertEquals(8, DataFlowTargets.bonus(new int[] { 1, 1, 1, 1, 1 }, 5));
    }
}
