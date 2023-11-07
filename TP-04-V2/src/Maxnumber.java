 class MaxNumberFinder {

    public int findMaxNumber(int[] numbers) {
        int maxNumber = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        return maxNumber;
    }
}