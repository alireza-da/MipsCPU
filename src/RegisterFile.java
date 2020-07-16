import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import java.util.HashMap;

public class RegisterFile extends Wrapper {
    private HashMap<Integer,Register> rf = new HashMap<>();
    //regWrite signal , register read 1 , 2 ; register write , write data
    public RegisterFile(String label, String stream, Link... links){
        super(label,stream,links);
        for (int i = 0 ; i < 32 ; i++){
            Register r = new Register();

            for (int j = 0; j < 32; j++) {
                assert false;
                DFlipFlop d = new DFlipFlop("d"+ j, getInput(0), Simulator.falseLogic);

                r.getFlipFlops().add(d);
            }
            System.out.println(r.getFlipFlops());

            rf.put(i,r);
        }

    }

    @Override
    public void initialize() {


    }



    public void setRf(HashMap<Integer, Register> rf) {
        this.rf = rf;
    }

    public HashMap<Integer, Register> getRf() {
        return rf;
    }
}
