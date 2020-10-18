package com.company.graph.TopologicalSort;

import java.util.Stack;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];

        int counter = 0;

        for(int i = 0; i < prerequisites.length; i++){
            courses[prerequisites[i][0]]+=1;
        }

        Stack<Integer> visited = new Stack<>();

        for(int i = 0; i < numCourses; i++){
            if(courses[i] == 0){
                visited.add(i);
            }
        }

        while(!visited.isEmpty()){
            int curr = visited.pop();
            counter++;

            for(int i = 0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == curr){
                    courses[prerequisites[i][0]] -= 1;
                    if(courses[prerequisites[i][0]] == 0){
                        visited.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return counter == numCourses;

    }
    public static void main(String[] args) {
        //int[][] inp = {{1,0}, {0,2}};
        int[][] inp = {{1,0},{1,2},{2,3}};
        CourseSchedule s = new CourseSchedule();
        System.out.println(s.canFinish(4, inp));
        // write your code here

    }
}
