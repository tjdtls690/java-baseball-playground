package com.jun_hyeok.base_ball;

public class BaseballGameCom {
    public static final int baseballCount = 3;

    private final int[] ranNumBox;

    public BaseballGameCom () {
        ranNumBox = new int[baseballCount];
    }



    int[] getRanNumBox () {
        for(int i = 0; i < ranNumBox.length; i++){
            ranNumBox[i] = getRanNum();
        }
        return ranNumBox;
    }

    private int getRanNum () {
        int ranNum = 0;
        boolean isUnique = false;
        while(!isUnique){
            ranNum = (int)((Math.random() * 9) + 1);
            isUnique = isUniqueCheck(ranNum);
        }
        return ranNum;
    }

    private boolean isUniqueCheck (int ranNum) {
        return ranNumBox[0] != ranNum && ranNumBox[1] != ranNum;
    }
}
