abstract class Fighter {

    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a " + this.getClass().getSimpleName();
    }

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int damagePoints(Fighter wizard) {
        if (wizard.isVulnerable()) {
            return 10;
        } else {
            return 6;
        }
    }
}

class Wizard extends Fighter {
    private boolean preparedSpell = false;

    @Override
    boolean isVulnerable() {
        return !this.preparedSpell;
    }

    @Override
    int damagePoints(Fighter warrior) {
        return this.preparedSpell ? 12 : 3;
    }

    void prepareSpell() {
        this.preparedSpell = true;
    }

    @Override
    public String toString() {
        return "Fighter is a " + this.getClass().getSimpleName();
    }
}
