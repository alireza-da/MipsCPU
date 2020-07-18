import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.HashMap;

public class RegisterFile extends Wrapper {
    private HashMap<Integer,Register> rf = new HashMap<>();
    //clock cycle , regWrite signal , register read 1 , 2 ; register write , write data ( ordination of inputs )
    public RegisterFile(String label, String stream, Link... links){
        super(label,stream,links);
        for (int i = 0 ; i < 32 ; i++){
            Register r = new Register();

            for (int j = 0; j < 32; j++) {

                DFlipFlop d = new DFlipFlop("d"+ j, getInput(0), Simulator.falseLogic);

                r.getFlipFlops().add(d);
            }
            System.out.println(r.getFlipFlops());

            rf.put(i,r);
        }

    }

    @Override
    public void initialize() {
        // write

        And a1 = new And("and1",getInput(1));
        And a2 = new And("and2",getInput(1));
        And a3 = new And("and3",getInput(1));
        And a4 = new And("and4",getInput(1));
        And a5 = new And("and5",getInput(1));
        And a6 = new And("and6",getInput(1));
        And a7 = new And("and7",getInput(1));
        And a8 = new And("and8",getInput(1));
        And a9 = new And("and9",getInput(1));
        And a10 = new And("and10",getInput(1));
        And a11 = new And("and11",getInput(1));
        And a12 = new And("and12",getInput(1));
        And a13 = new And("and13",getInput(1));
        And a14 = new And("and14",getInput(1));
        And a15 = new And("and15",getInput(1));
        And a16 = new And("and16",getInput(1));
        And a17 = new And("and17",getInput(1));
        And a18 = new And("and18",getInput(1));
        And a19 = new And("and19",getInput(1));
        And a20 = new And("and20",getInput(1));
        And a21 = new And("and21",getInput(1));
        And a22 = new And("and22",getInput(1));
        And a23 = new And("and23",getInput(1));
        And a24 = new And("and24",getInput(1));
        And a25 = new And("and25",getInput(1));
        And a26 = new And("and26",getInput(1));
        And a27 = new And("and27",getInput(1));
        And a28 = new And("and28",getInput(1));
        And a29 = new And("and29",getInput(1));
        And a30 = new And("and30",getInput(1));
        And a31 = new And("and31",getInput(1));
        And a32 = new And("and32",getInput(1));

    }



    public void setRf(HashMap<Integer, Register> rf) {
        this.rf = rf;
    }

    public HashMap<Integer, Register> getRf() {
        return rf;
    }
}
