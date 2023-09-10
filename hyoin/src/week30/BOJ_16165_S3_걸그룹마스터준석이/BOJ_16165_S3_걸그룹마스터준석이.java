import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_16165_S3_걸그룹마스터준석이 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, ArrayList<String>> teamMember = new HashMap<>();
		HashMap<String, String> memberTeam = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			String team = st.nextToken();
			st = new StringTokenizer(in.readLine());
			int memberCo = Integer.parseInt(st.nextToken());
			teamMember.put(team, new ArrayList<>());
			for(int j=0; j<memberCo; j++) {
				st = new StringTokenizer(in.readLine());
				String member = st.nextToken();
				teamMember.get(team).add(member);
				memberTeam.put(member, team);
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			st = new StringTokenizer(in.readLine());
			int no = Integer.parseInt(st.nextToken());
			
			if(no==0) { // 그룹 -> 멤버모두 출력
				ArrayList<String> members = teamMember.get(name);
				Collections.sort(members);
				for(int j=0; j<members.size(); j++) {
					sb.append(members.get(j)).append("\n");
				}
			}
			else {
				String team = memberTeam.get(name);
				sb.append(team).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
}
