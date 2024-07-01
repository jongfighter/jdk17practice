package com.jongui.jdk17sample.site.product;

import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        Queue<Integer> workDay = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<len;i++) {
            int e = (100-progresses[i])/speeds[i];
            int k = (100-progresses[i])%speeds[i];
            int intermediate = k==0?e:e+1;
            if(workDay.isEmpty()) {
                workDay.offer(intermediate);
            } else {
                int prev = workDay.peek();
                if(prev>=intermediate) {
                    workDay.offer(intermediate);
                } else {
                    int dateWork = workDay.size();
                    workDay.clear();
                    result.add(dateWork);
                    workDay.offer(intermediate);
                }
            }
        }
        if(!workDay.isEmpty()) {
            result.add(workDay.size());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }
}