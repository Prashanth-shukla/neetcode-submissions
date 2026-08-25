class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[m + n];

        int i = 0, j = 0;
        int idx = 0;

        int tempIdx = 0;
        int size = m + n;

        int idx1 = (size - 1) / 2;
        int idx2 = size / 2;

        int first = -1, second = -1;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                if (tempIdx == idx1) {
                    first = nums1[i];

                }

                else if (tempIdx == idx2) {
                    second = nums1[i];
                }

                i++;

            } else {
                if (tempIdx == idx1) {
                    first = nums2[j];

                }

                else if (tempIdx == idx2) {
                    second = nums2[j];
                }
                j++;
            }

            tempIdx++;
        }

        while (i < n) {
            if (tempIdx == idx1) {
                first = nums1[i];

            }

            else if (tempIdx == idx2) {
                second = nums1[i];
            }
            i++;
            tempIdx++;
        }

        while (j < m) {
            if (tempIdx == idx1) {
                first = nums2[j];

            }

            else if (tempIdx == idx2) {
                second = nums2[j];
            }
            j++;
            tempIdx++;
        }

        if (size % 2 != 0)
            return first / 1.0;
        else
            return (first + second) / 2.0;
    }
}