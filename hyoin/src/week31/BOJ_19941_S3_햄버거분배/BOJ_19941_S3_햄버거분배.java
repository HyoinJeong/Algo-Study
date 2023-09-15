import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19941_S3_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();
        int result=0;
        for(int i=0; i<N; i++){
            if(input[i]=='P'){
                boolean isFind = false;
                // 왼쪽 탐색
                for(int j=K; j>=1; j--){
                    if(i-j>=0){
                        if (input[i-j]=='H'){
                            input[i-j] = 'X';
                            result++;
                            isFind=true;
                            break;
                        }
                    }
                }

                if(!isFind) {
                    // 오른쪽 탐색
                    for (int j = 1; j <= K; j++) {
                        if (i + j < N) {
                            if (input[i + j] == 'H') {
                                input[i + j] = 'X';
                                result++;
                                break;
                            }
                        }
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(input));
        System.out.println(result);
    }
    }
