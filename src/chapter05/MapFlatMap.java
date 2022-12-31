package chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatMap {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Helllo", "word");

        List<String[]> map = words.stream()
                .map(word-> word.split(""))
                .distinct()
                .collect(Collectors.toList());

        for (String[] s: map) {
            for(String str : s){
                System.out.print(str+" ");
            }
            System.out.println();
        }

        List<Stream<String>> mapMap = words.stream()
                .map(word-> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("===============");
        for (Stream<String> s: mapMap) {
            s.forEach(x-> System.out.print(x+" "));
        }
        System.out.println();

        /**
         *  flatMap은 하나의 평면화된 스트림을 반환한다.
         *
         *  스트림의 각 값을 다른 스트림으로 만든 다음에
         *  모든 스트림을 하나의 스트림으로 연결함
         */
        List<String> flatMap = words.stream()
                .map(word-> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("===============");
        for (String s: flatMap) {
            System.out.print(s+" ");
        }

        /**
         *  [1,2,3], [3,4]
         *  [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
         * */
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);

        System.out.println("===============");
        List<int[]> pairs = numbers1.stream().flatMap(
                num1-> numbers2.stream().map(num2-> new int[]{num1,num2})
        ).collect(Collectors.toList());
        for (int[] s: pairs) {
            System.out.println(s[0] + "," + s[1]);
        }
        /**
         *  [1,2,3], [3,4]
         *  [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
         *  에서 합이 3으로 나누어 떨어지는 애들만 구하기
         *  [(2,4), (3,3)]
         * */

        List<int[]> pairsBy3 = numbers1.stream().flatMap(
                num1-> numbers2.stream()
                        .filter(num2-> (num1+num2)%3 == 0)
                        .map(num2-> new int[]{num1,num2})
        ).collect(Collectors.toList());
        System.out.println("===============");
        for (int[] s: pairsBy3) {
            System.out.println(s[0] + "," + s[1]);
        }

    }
}
