package com.company.arrays.array;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieRottenOrange {
    public int orangesRotting(int[][] grid) {
        Queue<Orange> rottenOranges = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;
        int mins = 0;

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    rottenOranges.add(new Orange(0, i, j));
                }
            }
        }

        while(!rottenOranges.isEmpty()){
            Orange o = rottenOranges.poll();
            int r = o.x;
            int c = o.y;
            boolean found = false;

            if(r-1  >= 0 && r-1 < rows && grid[r-1][c] == 1){
                rottenOranges.add(new Orange(o.turnAffected + 1, r-1, c));
                grid[r-1][c] = 2;
                found = true;
            }
            else if(r+1  < rows && grid[r+1][c] == 1){
                rottenOranges.add(new Orange(o.turnAffected + 1, r+1, c));
                grid[r+1][c] = 2;
                found = true;
            }
            else if(c-1  >= 0 && c-1 < cols && grid[r][c-1] == 1){
                rottenOranges.add(new Orange(o.turnAffected + 1, r, c-1));
                grid[r][c-1] = 2;
                found = true;
            }
            else if(c+1 < cols && grid[r][c+1] == 1){
                rottenOranges.add(new Orange(o.turnAffected + 1, r, c+1));
                grid[r][c+1] = 2;
                found = true;
            }

            if(found)
                mins = o.turnAffected + 1;
        }

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return mins;


    }


    class Orange{
        public int turnAffected;
        public int x;
        public int y;

        public Orange(int turnAffected, int x, int y){
            this.turnAffected = turnAffected;
            this.x = x;
            this.y = y;
        }
    }
}
