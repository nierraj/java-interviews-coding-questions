package com.neeraj.codingproblems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepChar {

	public static char findFirstNonRepChar(String string) {
		Map<Integer, Long> characters = string.chars().boxed()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		return (char) (int) characters.entrySet().stream().filter(e -> e.getValue() == 1L).findFirst()
				.map(Map.Entry::getKey).orElseThrow(() -> new RuntimeException("No unrepeated character"));
	}

	public static char findFirstNonRepChar1(String string) {
		Map<Character, AtomicInteger> characters = new LinkedHashMap<>(); // preserves order of insertion.
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			AtomicInteger n = characters.get(c);
			if (n == null) {
				n = new AtomicInteger(0);
				characters.put(c, n);
			}
			n.incrementAndGet();
		}
		for (Map.Entry<Character, AtomicInteger> entry : characters.entrySet()) {
			if (entry.getValue().get() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("No unrepeated character");
	}

	public static char findFirstNonRepChar2(String input) {
		char out = 0;
		int length = input.length();
		for (int i = 0; i < length; i++) {
			String sub1 = input.substring(0, i);
			String sub2 = input.substring(i + 1);
			if (!(sub1.contains(input.charAt(i) + "") || sub2.contains(input.charAt(i) + ""))) {
				out = input.charAt(i);
				break;
			}
		}
		return out;
	}

	public static char findFirstNonRepChar3(String s) throws Exception {
		if (s.length() == 0) {
			System.out.println("Fail");
			System.exit(0);
		} else {
			Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();

			for (int i = 0; i < s.length(); i++) {
				if (m.containsKey(s.charAt(i))) {
					m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
				} else {
					m.put(s.charAt(i), 1);
				}
			}
			for (Map.Entry<Character, Integer> hm : m.entrySet()) {
				if (hm.getValue() == 1) {
					return hm.getKey();
				}
			}
		}
		return 0;
	}

	public static char findFirstNonRepChar4(String s) {
		for (Character ch : s.toCharArray()) {
			if (s.indexOf(ch) == s.lastIndexOf(ch)) {
				System.out.println("First non repeat character = " + ch);
				return ch;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(findFirstNonRepChar("java java Technology"));
		System.out.println(findFirstNonRepChar1("java java Technology"));
		
	}

}
