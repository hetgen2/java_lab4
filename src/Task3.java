import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long comparisons = 0;
        long shifts = 0;
        long insertions = 0;

        for (int i = 1; i < n; i++) {
            int key = a[i];
            insertions++;
            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = key;
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) out.append(" ");
            out.append(a[i]);
        }
        out.append("\n");
        out.append("Comparisons: ").append(comparisons).append("\n");
        out.append("Shifts: ").append(shifts).append("\n");
        out.append("Insertions: ").append(insertions).append("\n");

        System.out.print(out);
    }
}
