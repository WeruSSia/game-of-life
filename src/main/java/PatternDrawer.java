public class PatternDrawer {

    private boolean[][] gameboard;
    private int positionX;
    private int positionY;

    public PatternDrawer(boolean[][] gameboard, int positionX, int positionY) {
        this.gameboard = gameboard;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    private void drawBlinker() {
        for (int i = positionY; i < positionY + 1; i++) {
            for (int j = positionX; j < positionX + 3; j++) {
                gameboard[i][j]=true;
            }
        }
    }

    private void drawToad(){
        for(int i=positionY;i<positionY+1;i++){
            for(int j=positionX+1; j<positionX+4;j++){
                gameboard[i][j]=true;
            }
        }
        for(int i=positionY+1;i<positionY+2;i++){
            for(int j=positionX;j<positionX+3;j++){
                gameboard[i][j]=true;
            }
        }
    }

    private void drawBeacon(){
        for(int i=positionY;i<positionY+2;i++){
            for(int j=positionX; j<positionX+2;j++){
                gameboard[i][j]=true;
            }
        }
        for(int i=positionY+2; i<positionY+4;i++){
            for(int j=positionX+2;j<positionX+4; j++){
                gameboard[i][j]=true;
            }
        }
    }

}
