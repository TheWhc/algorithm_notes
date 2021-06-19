package 回溯.其它;

import java.util.*;

/**
 * @ClassName: _332_重新安排行程
 * @Author: whc
 * @Date: 2021/06/19/13:55
 */
public class _332_重新安排行程 {

	/**
	 * 思路: 回溯
	 * 1. 递归函数的返回值和参数
	 *   返回值是boolean类型, 只需要找到一个行程，就是在树形结构中唯一的一条通向叶子节点的路线
	 *   boolean backtrack(int ticketNum)
	 *   参数为机票数,表示有多少个航班
	 *
	 * 2. 递归终止条件
	 *   航班数 + 1 = 结果数(遇到的机场个数)
	 *
	 * 3. 单层搜索的逻辑
	 *
	 *   以出发机场所到达的所有机场,进行遍历到达机场
	 *
	 *   Map<String, Map<String, Integer>> map 作为机场之间映射关系
	 *   key:出发机场,  value: key为到达机场, value为航班次数
	 *   其中 Map<String, Integer> 类型应该为TreeMap,按照key即到达机场的字母进行排序
	 *
	 * 输入: ["JFK","KUL"], ["JFK", "NRT"], ["NRT", "JFK"]
	 *
	 *                JFK 飞 {KUL, NRT}
	 *                  /\
	 *          KUL   /   \ NRT
	 *              /      \
	 *         KUL飞{}     NRT飞{JFK}
	 *   行程:JFK->KUL       \
	 *     3+1 != 2          \    行程:JFK->NRT
	 *                       \
	 *                    JFK飞{KUL, NRT}
	 *                     / \
	 *              飞KUL /   \  飞NRT(×),次数已用完
	 *                   /     \
	 *             KUL飞{}
	 *             行程: JFK->NRT->JFK->KUL
	 *               3 + 1 = 4
	 *            机票数 + 1 = 结果集
	 *
	 */
	List<String> res = new ArrayList<>();
	// key:出发机场,  value: key为到达机场, value为航班次数
	Map<String, Map<String, Integer>> map = new HashMap<>();
	public List<String> findItinerary(List<List<String>> tickets) {
		if(tickets == null || tickets.size() == 0) {
			return new ArrayList<>();
		}

		// 例子: ["JFK", "KUL"], ["JFK","NRT"], ["NRT", "JFK"]
		for (List<String> ticket : tickets) {

			// 第二次ticket
			// ticket = ["JFK", "NRT"]
			if(map.containsKey(ticket.get(0))) {
				// 获取到temp,此时内容为{["KUL", 1]}
				Map<String, Integer> temp = map.get(ticket.get(0));
				// 存放"NRT"后, 此时temp内容为{["KUL", 1], ["NRT", 1]}
				temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
				// 重新放入map中
				map.put(ticket.get(0), temp);
			} else {
				// 第一次ticket
				// ticket = ["JFK", "KUL"]
				// 不存在出发机场key时,新创建key, value为TreeMap,按照value的key字母排序
				// "KUL":1
				Map<String, Integer> temp = new TreeMap<>();
				temp.put(ticket.get(1), 1);
				map.put(ticket.get(0), temp);
			}
		}

		// 第一个出发地
		res.add("JFK");
		backtrack(tickets.size());

		return res;
	}

	// ticketNum参数表示有多少个航班(终止条件会用到)
	// 注意终止条件返回boolean,和其它回溯法的返回值不一样
	private boolean backtrack(int ticketNum) {
		// 递归终止条件
		if(ticketNum + 1 == res.size()) {
			return true;
		}

		// 结果集中的最后一个元素作为下一次的 出发机场
		String last = res.get(res.size()-1);
		// map集合中存在出发机场的key才进入选择
		if(map.containsKey(last)) {
			// 循环遍历key出发机场对应的所有的到达机场
			for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
				// 获取当前到达机场的航班次数
				int count = target.getValue();
				// 去重
				// 比如JFK -> NRT -> JFK  -> (KUL, NRT(不能飞,次数用完了))
				if(count > 0) {
					// 到达机场添加到结果集中
					res.add(target.getKey());
					// 对应航班次数减1
					target.setValue(count-1);
					if(backtrack(ticketNum)) {
						return true;
					}
					// 回溯
					// 撤销到达机场
					// 撤销到达机场对应的航班次数+1
					res.remove(res.size()-1);
					target.setValue(count);
				}
			}
		}

		// 比如JFK -> KUL 无法再继续飞下去了, 因为KUL没有作为任何的航班的出发机场,所以返回false
		return false;
	}

}
