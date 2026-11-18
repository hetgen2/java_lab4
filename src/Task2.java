import java.util.Arrays;

public class SortedArray {
    private int[] data;
    private int size;

    public SortedArray(int[] initial) {
        int[] copy = Arrays.copyOf(initial, initial.length);
        Arrays.sort(copy);

        this.data = new int[Math.max(16, copy.length * 2)];
        this.size = 0;

        for (int val : copy) {
            if (this.size == 0 || this.data[this.size - 1] != val) {
                this.data[this.size++] = val;
            }
        }
    }

    private int lowerBound(int x) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int upperBound(int x) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (data[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    public void add(int x) {
        int pos = lowerBound(x);
        if (pos < size && data[pos] == x) {
            return;
        }
        ensureCapacity();
        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = x;
        size++;
    }

    public boolean contains(int x) {
        int pos = lowerBound(x);
        return pos < size && data[pos] == x;
    }

    public void remove(int x) {
        int pos = lowerBound(x);
        if (pos == size || data[pos] != x) {
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public int countRange(int l, int r) {
        if (l > r) {
            return 0;
        }
        return upperBound(r) - lowerBound(l);
    }

    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }
}
