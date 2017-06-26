package jz.lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        List[] courses = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        
        // 建立领接表，存的是每个课程的前置课程 
        //这里情况特殊，大多数我们存的是邻居。
        for (int i = 0;i < numCourses; i++)
            courses[i] = new ArrayList<Integer>();
            
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]] ++ ; //入度加1
            courses[prerequisites[i][1]].add(prerequisites[i][0]); //加入前置课程
        }

        //入度为0的课程加入队列
        Queue queue = new LinkedList();
        for(int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int course = (int)queue.poll();
            count ++;
            //更新
            int n = courses[course].size();
            for(int i = 0; i < n; i++){
                int pointer = (int)courses[course].get(i);
                indegree[pointer]--;
                if (indegree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        
        return count == numCourses;
    }
}
