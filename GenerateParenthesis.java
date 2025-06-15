import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(1));
    }

    // 如果剩的左括号数和右括号相等，必须先放左括号
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        generate(n, n);
        return res;
    }

    private void generate(int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        // 只有右括号时，只能放右括号
        if (left == 0) {
            sb.append(')');
            generate(left, right - 1);
        }
        // 左右括号都有剩余，且相等时，只能放左括号
        else if (left == right) {
            sb.append('(');
            generate(left - 1, right);
        }
        // 左右括号都有剩余，且不相等时，左右括号都可以放
        else {
            sb.append('(');
            generate(left - 1, right);
            // 先放一种括号，递归结束后删除最后一个字符，再放另一个括号
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            generate(left, right - 1);
        }
        // 递归结束后删除最后一个字符
        sb.deleteCharAt(sb.length() - 1);
    }
}

