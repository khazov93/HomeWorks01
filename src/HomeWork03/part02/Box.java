package HomeWork03.part02;

import java.util.ArrayList;

public class Box <U extends Fruit> {

    ArrayList <U> fruitList;

    public Box (ArrayList <U> fruitList)
    {
        this.fruitList = fruitList;
    }

    public Float getWeightFruit(){
        Float result = 0.0f;
        for(U u: getFruitList()){
            if(u!=null) {
                Float value = u.getWeight();
                result = result + value;
            }
        }
        return result;
    }

    public Boolean compare(Box <U> box){
        if(this.getWeightFruit().floatValue() - box.getWeightFruit().floatValue() <= 0.0001) return true;
        return false;
    }


    public void toEmptyList(Box <U> box){
        System.out.println("В первом ящике до пересыпания: " + this.getWeightFruit().floatValue());
        System.out.println("В во втором ящике: " + box.getWeightFruit());
        for(U u: box.getFruitList()){
            this.getFruitList().add(u);
        }
        box.getFruitList().clear();
        System.out.println("В первом ящике после пересыпания: " + this.getWeightFruit());
        System.out.println("Во втором ящике: " + box.getWeightFruit());
    }

    public ArrayList <U> getFruitList() {
        return fruitList;
    }

}
