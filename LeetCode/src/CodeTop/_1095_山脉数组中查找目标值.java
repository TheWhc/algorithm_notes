package CodeTop;

/**
 * @ClassName: _1095_山脉数组中查找目标值
 * @Author: whc
 * @Date: 2021/07/21/15:32
 */

interface MountainArray {
	public int get(int index);

	public int length();
}


class MountainArrayImpl implements MountainArray {
	private int[] arr;
	private int size;

	public MountainArrayImpl(int[] arr) {
		this.arr = arr;
		this.size = this.arr.length;
	}

	@Override
	public int get(int index) {
		return this.arr[index];
	}

	@Override
	public int length() {
		return this.size;
	}

}

public class _1095_山脉数组中查找目标值 {

	// 特别注意：3 个辅助方法的分支出奇地一样，因此选中位数均选左中位数，才不会发生死循环
	public int findInMountainArray(int target, MountainArray mountainArr) {
		// 1. 先找到山顶元素所在的索引
		int mountainTop = findMountainTop(mountainArr, 0, mountainArr.length() - 1);
		// 2. 在前序数组找到target所在的索引
		int res = findFromSortedArr(mountainArr, 0, mountainTop, target);
		if(res != -1) {
			return res;
		}
		// 3. 如果第2步找不到,就在后序且降序数组中找target所在的索引
		return findFromInverseAddr(mountainArr, mountainTop+1, mountainArr.length() - 1, target);
	}

	private int findFromInverseAddr(MountainArray mountainArr, int l, int r, int target) {
		while(l < r) {
			int mid = l + (r - l) / 2;
			if(mountainArr.get(mid) > target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}

		// 因为不确定区间收缩成一个数以后,这个数是不是要找的数,因此单独做一次判断
		if(mountainArr.get(l) == target) {
			return l;
		}

		return -1;
	}

	private int findFromSortedArr(MountainArray mountainArr, int l, int r, int target) {
		while(l < r) {
			int mid = l + (r - l) / 2;
			if(mountainArr.get(mid) < target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}

		// 因为不确定区间收缩成一个数以后,这个数是不是要找的数,因此单独做一次判断
		if(mountainArr.get(l) == target) {
			return l;
		}

		return -1;
	}

	// 返回山顶元素下标
	private int findMountainTop(MountainArray mountainArr, int l, int r) {
		while(l < r) {
			int mid = l + (r - l) / 2;

			if(mountainArr.get(mid) < mountainArr.get(mid + 1)) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}

		return l;
	}
}

