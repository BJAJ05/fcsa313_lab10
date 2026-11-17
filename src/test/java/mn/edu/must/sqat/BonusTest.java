package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
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

    @Test
    @DisplayName("T3 bonus(null,0) throws: attendance 31->32(T)")
    void t3_nullArray_throws() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 0));
    }

    @Test
    @DisplayName("T4 bonus([1],-1) throws: attendance 31->32(F); threshold 31->32(T)")
    void t4_negativeThreshold_throws() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[] { 1 }, -1));
    }

    @Test
    @DisplayName("T5 bonus([],0)=5: attendance 31->32, 31->38(F); threshold 31->32, 31->50(T); "
            + "present 35->50(T); best 37->53(F); score 51->56")
    void t5_empty_thr0_returns5() {
        assertEquals(5, DataFlowTargets.bonus(new int[] {}, 0));
    }

    @Test
    @DisplayName("T6 bonus([0,0],1)=0: attendance 31->32, 31->38; threshold 31->32, 31->50(F); "
            + "present 35->50(F); best 37->53(F); a 38->39(F); score 49->56")
    void t6_allAbsent_thr1_returns0() {
        assertEquals(0, DataFlowTargets.bonus(new int[] { 0, 0 }, 1));
    }

    @Test
    @DisplayName("T7 bonus([1,1,1,1,1],6)=3: attendance 31->32, 31->38; threshold 31->32, 31->50(F); "
            + "present 35->40, 40->40, 40->50(F); streak 36->41, 41->41, 41->42, 41->43; "
            + "best 37->42, 43->42, 43->53(T); a 38->39; score 49->54, 54->56")
    void t7_run5_thr6_returns3() {
        assertEquals(3, DataFlowTargets.bonus(new int[] { 1, 1, 1, 1, 1 }, 6));
    }
}
