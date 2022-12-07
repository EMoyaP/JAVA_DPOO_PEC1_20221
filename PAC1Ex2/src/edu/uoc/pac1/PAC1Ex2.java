package edu.uoc.pac1;

public class PAC1Ex2 {

    public static int stepForward(int position, int speed, int length){
        //TODO

        int stepForward;
        stepForward = position + speed;

        if (position < 0 || speed < 0 || length < 0 || position >= length) {
            return -1;
        } else if (stepForward < length) {
            return stepForward;
        } else {
            return stepForward - length;
        }
    }

    public static int[] stepForward(int position1, int speed1, int position2, int speed2, int length){
        //TODO
        int monk1 = stepForward(position1,speed1,length);
        int monk2 = stepForward(position2,speed2,length);

        return new int[]{monk1,monk2};
    }

    public static int[] whenTheyMeet(int position1, int speed1, int position2, int speed2, int length){
        //TODO

        int day = 1;
        int[] monk = stepForward(position1, speed1, position2, speed2, length);

        if (monk[0] == -1 || monk[1] == -1){
            return new int[]{-1, -1};
        } else {
            while (monk[0] != monk[1]) {
                monk = stepForward(monk[0], speed1, monk[1], speed2, length);
                day++;
            }
            return new int[]{day, monk[0]};
        }

    }

}
