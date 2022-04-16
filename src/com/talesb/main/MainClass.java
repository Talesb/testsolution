package com.talesb.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {

		Solution sol = new Solution();
		//6
		System.out.println(sol.solution("ccaaffddecee")); 
		//0
		System.out.println(sol.solution("aaaaaaaaa"));
	}

}

class Solution {
	public int solution(String s) {

		List<String> stringList = Arrays.asList(s.split(""));
		Set<String> uniqueStrings = new HashSet<>();
		List<Integer> timesRepeted = new ArrayList<>();
		List<Integer> timesRepetedAux = new ArrayList<>();
		AtomicInteger   smallestNumber = new AtomicInteger(0); 
		AtomicInteger   reps = new AtomicInteger(0); 
		
		uniqueStrings.addAll(stringList);
		uniqueStrings.forEach(unqStrg -> {
		int timesRepeated =	stringList.stream().filter(stringOccurrence -> stringOccurrence.equals(unqStrg)).collect(Collectors.toList()).size();
			
		if	(smallestNumber.get()==0) {
			smallestNumber.set(timesRepeated);
		}else {
			if(smallestNumber.get()>timesRepeated) {
				smallestNumber.set(timesRepeated);
			}
		}
		timesRepeted.add(timesRepeated);
		});
		
		timesRepeted.remove(timesRepeted.stream().findFirst().get());

		if(timesRepeted.size()>1) {
			for(int i = smallestNumber.get();i>1;i--) {
				reps.set(reps.get()+1);
			}
			timesRepeted.forEach(repeated ->{
				if(timesRepetedAux.isEmpty()) {
					timesRepetedAux.add(repeated);
				}else {
					if(timesRepetedAux.contains(repeated)) {
						reps.set(reps.get()+repeated);
					}else {
						timesRepetedAux.add(repeated);
					}
				}
			});
		}
		
		return reps.get();
	}

}
