package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B12789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = 1;
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (x == k)
				x++;
			else {
				while (!stack.isEmpty() && stack.peek() == x) {
					stack.pop();
					x++;
				}
				stack.push(k);
			}
		}

		while (!stack.isEmpty() && stack.peek() == x) {
			stack.pop();
			x++;
		}

		System.out.println(stack.isEmpty() ? "Nice" : "Sad");
	}
}
