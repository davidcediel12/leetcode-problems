package com.example.demo.threesum;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<Integer> numbers = Arrays.stream(nums).boxed().toList();
        List<Integer> reducedNumbers = new ArrayList<>();

        Map<Integer, Integer> uniqueNumbers = new HashMap<>();

        for (Integer n : numbers) {
            if (uniqueNumbers.containsKey(n)) {
                int numberAmount = uniqueNumbers.get(n) + 1;
                uniqueNumbers.put(n, numberAmount);

                if (numberAmount <= 3) {
                    reducedNumbers.add(n);
                }

            } else {
                uniqueNumbers.put(n, 1);
                reducedNumbers.add(n);
            }
        }

        Set<List<Integer>> triplets = new HashSet<>();
        Set<List<Integer>> orderedTriplets = new HashSet<>();

        for (int i = 0; i < reducedNumbers.size(); i++) {
            int t1 = reducedNumbers.get(i);
            for (int j = i + 1; j < reducedNumbers.size(); j++) {
                int t2 = reducedNumbers.get(j);
                int t3 = -t1 - t2;

                List<Integer> possibleTriplet = List.of(t1, t2, t3);
                List<Integer> orderedPossibleTriplet = possibleTriplet.stream().sorted().toList();


                if (j + 1 < reducedNumbers.size() &&
                        !orderedTriplets.contains(orderedPossibleTriplet) &&
                        existsT3(t3, t1, t2, uniqueNumbers)) {

                    triplets.add(possibleTriplet);
                    orderedTriplets.add(orderedPossibleTriplet);
                }

            }
        }
        return new ArrayList<>(triplets);
    }

    private static boolean existsT3(int t3, int t1, int t2, Map<Integer, Integer> uniqueNumbers) {
        boolean existsT3;
        if (t3 == t1 && t3 == t2) {
            existsT3 = uniqueNumbers.get(t3) > 2;
        } else if (t3 == t1 || t3 == t2) {
            existsT3 = uniqueNumbers.get(t3) > 1;
        } else {
            existsT3 = uniqueNumbers.containsKey(t3);
        }
        return existsT3;
    }
}
