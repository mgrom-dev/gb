import org.json.JSONObject;

/**
 * ���� ������ sql-������� "select * from students where ". ����������� �����
 * WHERE ����� �������, ��������� StringBuilder. ������ ��� ���������� ���������
 * ���� � ���� json ������. ���� �������� null, �� �������� �� ������ �������� �
 * ������. ��������� ��� ����������: {"name":"Ivanov", "country":"Russia",
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
