import simulator.control.Simulator;
import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.gates.sequential.flipflops.FlipFlop;
import simulator.network.Link;

import java.util.ArrayList;

public class Register{
    //private Clock clock;
    private ArrayList<DFlipFlop> flipFlops = new ArrayList<>();
    private Link write = Simulator.falseLogic;
    private Link read = Simulator.falseLogic;

    public Link getRead() {
        return read;
    }

    public void setRead(Link read) {
        this.read = read;
    }

    public Link getWrite() {
        return write;
    }

    public void setWrite(Link write) {
        this.write = write;
    }

    public void setFlipFlops(ArrayList<DFlipFlop> flipFlops) {
        this.flipFlops = flipFlops;
    }

    public ArrayList<DFlipFlop> getFlipFlops() {
        return flipFlops;
    }


    public void setFlipFlopsByIndex(int startIndex, int endIndex, int[] data, Clock clock){
            for (int i = startIndex; i < endIndex; i++) {
                if (data[i] == 0) {
                    getFlipFlops().set(i, new DFlipFlop("d" + i, clock.getOutput(0), Simulator.falseLogic));
                } else if (data[i] == 1) {
                    getFlipFlops().set(i, new DFlipFlop("d" + i, clock.getOutput(0), Simulator.trueLogic));
                }
            }

    }


    public void write(ArrayList<Link> links,Link clock){
        if(write == Simulator.trueLogic){
            int i = 0;
            for (Link link : links) {
                getFlipFlops().set(i, new DFlipFlop("d" + i, clock, link));
            }
        }
    }


    public ArrayList<Link> dataToLogic(){
        ArrayList<Link> logicalData = new ArrayList<>();
        for (int i = 0 ; i < 32 ; i++){
            logicalData.add(getFlipFlops().get(i).getData());
        }
        return logicalData;
    }

    public static void main(String[] args) {
        Register register = new Register();
        Clock c = new Clock("c", 1000);
        for (int j = 0; j < 32; j++) {
            assert false;
            DFlipFlop d = new DFlipFlop("d"+ j, c.getOutput(0));

            register.getFlipFlops().add(d);
        }
        register.dataToLogic();
    }

}