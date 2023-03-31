// Представьте, что вы пишете класс Reder, который отвечает за вывод на экран текущего уровня жизней и усталости какого-то объекта.
// (Подразумеваем, что вывод на экран - это просто печать в консоль)
// У класса есть 1 метод, который принимает тип Object и делает следующее:
// 1. Если object типа HasHealthPoint, то выводим его уровень жизни
// 2. Если object типа Tiredness, то выводим его уровень усталости
// При этом текст значения должен иметь цвет в соответствии с правилом: BLACK(0, 24), RED(25, 50), GREEN(51-100)
// Вычислить % сколько текущий уровень занимает от максимального и покрасить
// 3. Создать несколько классов:
// 3.1 Здание. Имеет только жизни.
// 3.2 Персноаж. Имеет и жизни, и усталость



public class game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        Building building = new Building(100, 80);
        Render render = new Render(20,10,8,4);
        Reder.render(render);
        Reder.render(building);

        //System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        
    }
    
    static class Reder {

        public static void render (Object object){
            if (object instanceof HasHealthPoint HasHealthPoint && object instanceof Tiredness Tiredness) {
                Double del_H = (double) HasHealthPoint.getCurrentHasHealthPoint()/HasHealthPoint.getMaxHasHealthPoint();
                Double del_T = (double) Tiredness.getCurrentEnergy()/Tiredness.getMaxEnergy();
                if (del_H>0.5) {
                    System.out.println(ANSI_RED + HasHealthPoint.getCurrentHasHealthPoint() + ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN + HasHealthPoint.getCurrentHasHealthPoint() + ANSI_RESET);
                }
                if (del_T>0.5) {
                    System.out.println(ANSI_RED + Tiredness.getCurrentEnergy() + ANSI_RESET);
                } else {
                    System.out.println(ANSI_GREEN + Tiredness.getCurrentEnergy() + ANSI_RESET);
                }
            }

        }
    }

    interface HasHealthPoint {
        int getMaxHasHealthPoint();
        int getCurrentHasHealthPoint();
    }

    interface Tiredness {
        int getMaxEnergy(); // максимальное значение уровня бодрости объекта
        int getCurrentEnergy(); // текущее значение уровня бодрости объекта
    }

    static class Building implements HasHealthPoint{
        private final int MaxHasHealthPoint;
        public int CurrentHasHealthPoint;

        public Building (int MaxHasHealthPoint, int CurrentHasHealthPoint){
            this.MaxHasHealthPoint = MaxHasHealthPoint;
            this.CurrentHasHealthPoint = CurrentHasHealthPoint;
        }

        @Override
        public int getMaxHasHealthPoint(){
            return MaxHasHealthPoint;
        }
        
        @Override
        public int getCurrentHasHealthPoint(){
            return CurrentHasHealthPoint;
        }

        public void render(game.Building building) {
        }
    }

    static class Render implements HasHealthPoint, Tiredness{
        private final int MaxHasHealthPoint;
        public int CurrentHasHealthPoint;
        private final int MaxEnergy;
        public int CurrentEnergy;

        public Render (int MaxHasHealthPoint, int CurrentHasHealthPoint, int MaxEnergy, int CurrentEnergy){
            this.MaxHasHealthPoint = MaxHasHealthPoint;
            this.CurrentHasHealthPoint = CurrentHasHealthPoint;
            this.CurrentEnergy = CurrentEnergy;
            this.MaxEnergy = MaxEnergy;
        }

        public void render(game.Render render) {
        }

        @Override
        public int getMaxHasHealthPoint(){
            return MaxHasHealthPoint;
        }
        
        @Override
        public int getCurrentHasHealthPoint(){
            return CurrentHasHealthPoint;
        }

        @Override
        public int getMaxEnergy() {
            return MaxEnergy;
        }

        @Override
        public int getCurrentEnergy() {
            return CurrentEnergy;
        }
    }



}