package com.peilw.child.algorithm.recursion;

public class MazeProblem {
    public static void main(String[] args) {
        int[][] a = new int[8][7];
        for (int i = 0; i < 7; i++) {
            a[0][i] = 1;
            a[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            a[i][0] = 1;
            a[i][6] = 1;
        }
        a[3][1] = 1;
        a[3][2] = 1;
        setWay(a, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }


    }

    /* map表示地图
     i，j表示从地图的那个位置出发(1,1)
     如果小球能到达map[6] [5]位置，则说明通路找到
     约定：当map[i] [j]为0表示该点没有走过、1表示墙、2表示通路、3表示该点已经走过，但是走不通
     走迷宫时需要确定策略，例如：下—>右—>上—>左，如果该点走不通则回溯*/
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }

        }
    }
}
