package trying.domain;


public class Pokemon {
    int id;
    String name;
    String type;
    int strength;

    public Pokemon(int id, String name, String type, int strength){
        this.id = id;
        this.name = name;
        this.type = type;
        this.strength = strength;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString(){
        return String.format(
                "Pokemon[id=%d, name='%s', type='%s', strength='%d']",
                id, name, type, strength);
    }
}
