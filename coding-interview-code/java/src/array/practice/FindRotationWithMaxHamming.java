package array.practice;

class FindRotationWithMaxHamming {
  private static int maxHamming(int arr[], int n) {
    // arr[] to brr[] two times so that
    // we can traverse through all rotations.
    int brr[] = new int[2 * n + 1];
    for (int i = 0; i < n; i++)
      brr[i] = arr[i];
    for (int i = 0; i < n; i++)
      brr[n + i] = arr[i];

    // We know hamming distance with
    // 0 rotation would be 0.
    int maxHam = 0;

    // We try other rotations one by one
    // and compute Hamming distance
    // of every rotation
    for (int i = 1; i < n; i++) {
      int currHam = 0;
      for (int j = i, k = 0; j < (i + n); j++,
          k++)
        if (brr[j] != arr[k])
          currHam++;

      // We can never get more than n.
      if (currHam == n)
        return n;

      maxHam = Math.max(maxHam, currHam);
    }

    return maxHam;
  }

  public static int findHamming(int array[]) {
    int copy[] = new int[2 * array.length];
    for (int i = 0; i < copy.length; i++) {
      if (i < array.length)
        copy[i] = array[i];
      else copy[i] = array[i - array.length];
    }

    int distinctFreq[] = new int[copy.length];
    distinctFreq[0] = 1;

    for (int i = 1; i < copy.length; i++) {
      distinctFreq[i] = distinctFreq[i - 1];
      if (copy[i] != copy[i - 1])
        distinctFreq[i]++;
    }
    int i = 0, j = array.length;
    int max = Integer.MIN_VALUE;
    while (j < copy.length) {
      if (max < (distinctFreq[j] - distinctFreq[i]))
        max = distinctFreq[j] - distinctFreq[i];
      j++;
      i++;
    }
    return max;
  }

  public static void main(String[] args) {
    int[] array = {0, 1, 2, 3, 1, 2, 3};
    System.out.println(findHamming(array));
    System.out.print(maxHamming(array, array.length));
  }
}
