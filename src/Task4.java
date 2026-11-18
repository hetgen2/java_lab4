import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Queue<Integer> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        long swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            int current = queue.poll();

            for (int j = 0; j < n - 1; j++) {
                int next = queue.poll();
                if (j < n - 1 - i && current > next) {
                    queue.add(next);
                    swaps++;
                    swapped = true;
                } else {
                    queue.add(current);
                    current = next;
                }
            }
            queue.add(current);

            if (!swapped) {
                break;
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) out.append(" ");
            out.append(queue.poll());
        }
        out.append("\n").append(swaps).append("\n");

        System.out.print(out);
    }
}
