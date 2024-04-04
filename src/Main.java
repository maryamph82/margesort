public class Main {

    public static int[] mergeSort(int[] arr, int firstIndx, int LastIndx) {

        if (firstIndx == LastIndx) {
            int[] res = new int[1];
            res[0] = arr[firstIndx];
            return res;
        }

        int mid = (firstIndx + LastIndx) / 2;

        int[] ls = mergeSort(arr, firstIndx, mid);

        int[] rs = mergeSort(arr, mid + 1, LastIndx);

        int[] ans = mergeSorted(ls, rs);
        return ans;

    }


    public static int[] mergeSorted(int[] arr1, int[] arr2) {

        int p1 = 0, p2 = 0, p3 = 0;

        int[] arr3 = new int[arr1.length + arr2.length];

        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                arr3[p3] = arr1[p1];
                p1++;
                p3++;
            } else {
                arr3[p3] = arr2[p2];
                p2++;
                p3++;
            }
        }


        while (p1 < arr1.length) {
            arr3[p3] = arr1[p1];
            p3++;
            p1++;
        }

        while (p2 < arr2.length) {
            arr3[p3] = arr2[p2];
            p3++;
            p2++;
        }

        return arr3;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {115, 83 ,200 , 0 , 3 , 50 , 7 , 44};
        int[] sa = mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted numbers : \n");
        print(sa);
    }

}