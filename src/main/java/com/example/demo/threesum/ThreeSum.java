package com.example.demo.threesum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {

    public List<List<Integer>> threeSum3(int[] nums) {


        Set<Integer> numberSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        if (numberSet.size() == 1 && numberSet.contains(0)) {
            return List.of(List.of(0, 0, 0));
        }
        if (numberSet.size() == 2 && numberSet.stream().reduce(0, Integer::sum) == 0) {
            return Collections.emptyList();
        }
        if (numberSet.size() == 3 && numberSet.stream().reduce(0, Integer::sum) == 0) {

            if (numberSet.contains(0) && existsMoreThan(nums, 3)) {
                return List.of(numberSet.stream().toList(), List.of(0, 0, 0));
            }
            return List.of(numberSet.stream().toList());
        }

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

        Set<Integer> alreadyInTriplet = new HashSet<>();

        for (int i = 0; i < reducedNumbers.size(); i++) {
            int t1 = reducedNumbers.get(i);

            if (alreadyInTriplet.contains(t1)) {
                continue;
            }

            for (int j = i + 1; j < reducedNumbers.size(); j++) {
                int t2 = reducedNumbers.get(j);
                int t3 = -t1 - t2;

                List<Integer> possibleTriplet = Stream.of(t1, t2, t3).sorted().toList();

                if (j + 1 < reducedNumbers.size() &&
                        !triplets.contains(possibleTriplet) &&
                        existsT3(t3, t1, t2, uniqueNumbers)) {

                    triplets.add(possibleTriplet);

                    alreadyInTriplet.add(t1);
                }

            }
        }
        return new ArrayList<>(triplets);
    }

    private static boolean existsT3(int t3, int t1, int t2, Map<Integer, Integer> uniqueNumbers) {
        if (t3 == t1 && t3 == t2) {
            return uniqueNumbers.get(t3) > 2;
        }

        if (t3 == t1 || t3 == t2) {
            return uniqueNumbers.get(t3) > 1;
        }

        return uniqueNumbers.containsKey(t3);
    }

    private static boolean existsMoreThan(int[] nums, int times) {
        return Arrays.stream(nums).reduce(0, (a, x) -> {
            if (x == 0) {
                return a + 1;
            }
            return a;
        }) >= times;
    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<Integer> numbers = Arrays.stream(nums).sorted().boxed().toList();
        Set<List<Integer>> triplets = new HashSet<>();
        Set<Integer> alreadyProcessed = new HashSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            int j = i + 1;
            int k = numbers.size() - 1;

            if (alreadyProcessed.contains(numbers.get(i))) {
                continue;
            }

            while (j < numbers.size() && j < k) {

                int total = numbers.get(i) + numbers.get(j) + numbers.get(k);

                if (total == 0) {

                    triplets.add(List.of(numbers.get(i), numbers.get(j), numbers.get(k)));
                    j++;
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            alreadyProcessed.add(numbers.get(i));
        }

        return triplets.stream().toList();
    }
}
