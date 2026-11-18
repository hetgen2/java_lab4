import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task1 {
    public static int lowerBound(int[] a, int x) {
        int left = 0;
        int right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            out.append(lowerBound(a, x)).append("\n");
        }
        System.out.print(out);
    }
}
