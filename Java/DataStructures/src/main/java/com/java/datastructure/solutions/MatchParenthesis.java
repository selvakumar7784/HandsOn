package com.java.datastructure.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.java.datastructures.StackImpl;
import com.java.datastructures.StackImpl.StackOverFlowException;
import com.java.datastructures.StackImpl.StackUnderFlowException;

public class MatchParenthesis {

	private static final Set<Character> openParenthesisSet = new HashSet<>();
	private static final Map<Character, Character> parenthesisMap = new HashMap<>();

	private StackImpl<Character> stack = new StackImpl<>();

	static {
		parenthesisMap.put(')', '(');
		parenthesisMap.put('}', '{');
		parenthesisMap.put(']', '[');

		openParenthesisSet.addAll(parenthesisMap.values());
	}

	public boolean hasMatchingParenthesis(String input) throws StackOverFlowException, StackUnderFlowException {

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if(openParenthesisSet.contains(c)){
				stack.push(c);
			}
			
			if(parenthesisMap.containsKey(c)){
				if(! stack.pop().equals(parenthesisMap.get(c)))
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) throws StackOverFlowException, StackUnderFlowException {
		MatchParenthesis matchParenthesis = new MatchParenthesis();
		
		System.out.println("(ABC){C(DE)}[HFG] : "+matchParenthesis.hasMatchingParenthesis("(ABC){C(DE)}[HFG]"));
		System.out.println("(A(BC){C(DE)}[HFG] : "+matchParenthesis.hasMatchingParenthesis("((ABC){C(DE)}[HFG]"));
		System.out.println("(ABC){C(D}E)}[HFG] : "+matchParenthesis.hasMatchingParenthesis("(ABC){C(D}E)}[HFG]"));

	}

}
