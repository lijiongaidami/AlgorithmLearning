package org.justyoung.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 二叉树重建
 * 
 * @author justyoung
 *
 */
public class RebuildBinaryTree {

	static class TreeNode {
		char value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(char value) {
			this.value = value;
		}
	}

	public static TreeNode constructTree(String preOrder, String inOrder) {
		if (preOrder.equals(inOrder) && preOrder.length() == 1)
			return new TreeNode(preOrder.charAt(0));
		else {
			char rootValue = preOrder.charAt(0);
			int rootIndexAtInOrder = inOrder.indexOf(rootValue);
			int leftLength = rootIndexAtInOrder;
			int rightLength = preOrder.length() - leftLength - 1;
			TreeNode root = new TreeNode(rootValue);
			if (leftLength > 0)
				root.left = constructTree(preOrder.substring(1, 1 + leftLength), inOrder.substring(0, leftLength));
			if (rightLength > 0)
				root.right = constructTree(preOrder.substring(1 + leftLength),
						inOrder.substring(rootIndexAtInOrder + 1));
			return root;
		}
	}

	public static void postOrderTree(TreeNode tr) {
		if (tr.left != null) {
			postOrderTree(tr.left);
		}
		if (tr.right != null) {
			postOrderTree(tr.right);
		}
		System.out.print(tr.value);
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader r = new BufferedReader(isr);
		String input = null;
		String preOrderString = null;
		String inOrderString = null;
		String[] inputs = null;
		while ((input = r.readLine()) != null) {
			inputs = input.split(" ");
			preOrderString = inputs[0];
			inOrderString = inputs[1];
			TreeNode tr = constructTree(preOrderString, inOrderString);
			postOrderTree(tr);
			System.out.println();
		}
	}
}
