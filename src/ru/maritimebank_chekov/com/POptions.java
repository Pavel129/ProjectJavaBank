package ru.maritimebank_chekov.com;
import ru.inversion.bicomp.pref.OdbActionBundle;

public class POptions extends OdbActionBundle {

    public POptions(){}

    enum Actions{
        VIEW_MTB(-20),
        REPROCESSING(-21);
        private final int act_id;
        Actions(int i){
            act_id=i;
        }
        public int id(){
            return act_id;
        }
    }

    @Override
    public int[] getActionList() {
        return new int[] {
                Actions.VIEW_MTB.act_id// -20 view MTB
                ,Actions.REPROCESSING.act_id// -21 Send reprocessing document
        };
    }

}
