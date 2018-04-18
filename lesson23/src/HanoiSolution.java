public class HanoiSolution {

    public static int solution(TowerOfHanoi tower){
        while(!tower.isFinished()){
            try{
                tower.moveDisc(0 , 1);
            } catch (Exception ex){
                try{
                    tower.moveDisc(1, 0);
                } catch (Exception x){
                }
            }
            try{
                tower.moveDisc(0 , 2);
            } catch (Exception ex){
                try{
                    tower.moveDisc(2, 0);
                } catch (Exception x){
                }
            }
            try{
                tower.moveDisc(1 , 2);
            } catch (Exception ex){
                try{
                    tower.moveDisc(2, 1);
                } catch (Exception x){
                }
            }
        }
        System.out.println(tower);
        return tower.getNumMoves();
    }
    public static void main(String[] args){
        TowerOfHanoi tower = new TowerOfHanoi(20);
        System.out.println(solution(tower));
    }
}
