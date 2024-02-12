import org.json.JSONObject;

/**
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть
 * WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены
 * ниже в виде json строки. Если значение null, то параметр не должен попадать в
 * запрос. Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
 * "city":"Moscow", "age":"null"}
 */
public class Home1 {
    public static void main(String[] args) {
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        JSONObject data = new JSONObject(json);

        StringBuilder whereClause = new StringBuilder();
        boolean first = true;
        for (String key : data.keySet()) {
            String value = data.getString(key);
            if (!value.equals("null")) {
                if (!first)
                    whereClause.append(" AND ");
                whereClause.append(key).append(" = '").append(value).append("'");
                first = false;
            }
        }

        String sql = "SELECT * FROM students WHERE " + whereClause.toString();
        System.out.println(sql);
    }
}
