package _06_LLD._2022_11_25.solid.bird_design.concrete_classes;

import _06_LLD._2022_11_25.solid.bird_design.Bird;
import _06_LLD._2022_11_25.solid.bird_design.Flyable;
import _06_LLD._2022_11_25.solid.bird_design.FlyingBehaviour;

public class Crow extends Bird implements Flyable {

    FlyingBehaviour flyingBehaviour;

    @Override
    public void fly() {
        flyingBehaviour = new COFB();
        flyingBehaviour.makeFly();
    }
}
