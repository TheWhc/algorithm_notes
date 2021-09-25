package 模拟;

/**
 * @ClassName: _657_机器人能否返回原点
 * @Author: whc
 * @Date: 2021/09/25/16:33
 */
public class _657_机器人能否返回原点 {

	public boolean judgeCircle(String moves) {
		char[] chars = moves.toCharArray();
		int x = 0, y = 0;
		for (char c : chars) {
			if(c == 'R') {
				y++;
			} else if(c == 'L') {
				y--;
			} else if(c == 'U') {
				x--;
			} else {
				x++;
			}
		}

		return x == 0 && y == 0;
	}

}
