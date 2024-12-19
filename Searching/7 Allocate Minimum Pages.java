/*You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
[12] and [34, 67, 90] Maximum Pages = 191
[12, 34] and [67, 90] Maximum Pages = 157
[12, 34, 67] and [90] Maximum Pages = 113.
Therefore, the minimum of these cases is 113, which is selected as the output. */

class Solution {
    public static int isPossible(int[] arr, int pages) {
        int countStudents = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > pages) {
                countStudents++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return countStudents;
    }

    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;

        int low = arr[0], high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int requiredStudents = isPossible(arr, mid);
            if (requiredStudents <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}