import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int maxLength = 0;
        List<Integer> resultList = new ArrayList<>();

        // 1. 두 번째 수를 N부터 0까지 시도 (완전 탐색)
        for (int i = n; i >= 0; i--) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(n);
            currentList.add(i);
            
            // 2. 수열 생성 (재귀 대신 반복문으로 구현하면 스택 오버플로우 걱정이 없습니다)
            generateSequence(currentList);
            
            // 3. 최대 길이 갱신 및 결과 저장
            if (currentList.size() > maxLength) {
                maxLength = currentList.size();
                resultList = currentList;
            }
        }

        // 4. 결과 출력
        System.out.println(maxLength);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i) + (i == resultList.size() - 1 ? "" : " "));
        }
    }

    // 앞의 두 수의 차를 구하여 리스트에 추가하는 메서드
    public static void generateSequence(List<Integer> list) {
        while (true) {
            int nextNum = list.get(list.size() - 2) - list.get(list.size() - 1);
            if (nextNum < 0) break;
            list.add(nextNum);
        }
    }
}