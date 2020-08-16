package test;

public class TestEnum {

    public static void main(String[] args) {
        Color c = Color.BLANK;
        for (Color color :
                Color.values()) {
            System.out.println(color.name());
        }
    }

    public enum Color {
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        Color(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (Color c : Color.values()) {
                if (c.index == index) {
                    return c.name;
                }
            }
            return null;
        }
    }
}
