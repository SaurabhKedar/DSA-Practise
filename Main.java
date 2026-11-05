public class Main {
    public static void main() {
        CustomHashMap<Integer, Integer> map = new CustomHashMap<>();
        map.put(10, 15);
        map.put(20, 25);
        System.out.println(map.get(10)); //15
        System.out.println("Size : " + map.getSize());

        map.put(10, 76);
        System.out.println(map.get(10)); //76

        map.remove(10);
        System.out.println(map.get(10));
        System.out.println("Size : " + map.getSize());

        CustomHashMap<String, Integer> map2  = new CustomHashMap<>();
        map2.put("abc", 37);
        map2.put("xyz", 87);

        System.out.println(map2.get("abc"));
    }
}
