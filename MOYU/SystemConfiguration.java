package MOYU;

import java.util.Map;
import java.util.Map.Entry;

public class SystemConfiguration {
     public static void main(String[] args) {
        // 获取所有系统属性
        Map<Object, Object> properties = System.getProperties();

        System.out.println("系统配置:");

        // 遍历系统属性并按类型输出
        for (Entry<Object, Object> entry : properties.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();

            if (isSystemProperty(key)) {
                System.out.println(key + ": " + value);
            }
        }
    }

    // 根据键名判断是否为系统属性
    private static boolean isSystemProperty(String key) {
        return key.startsWith("os.") || key.startsWith("java.") || key.startsWith("user.") || key.startsWith("file.");
    }
}
