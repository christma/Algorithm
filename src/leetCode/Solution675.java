package com.spring.leetCode;

public class Solution675 {

    public boolean judgeCircle(String moves) {
        // R（右），L（左），U（上）和 D（下）
        int x = 0, y = 0;

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case 'U':
                    y--;
                    break;
                case 'D':
                    y++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                default:
                    throw new IllegalArgumentException("error !!");
            }
        }

        return x == 0 && y == 0;
    }
}
