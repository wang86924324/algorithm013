package Week_08.everyday;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            dfs(nums,0,path,res);
        }

        return res;
    }

    private void dfs(int[] nums,int start,List<Integer> path,List<List<Integer>> res){
        res.add(new ArrayList<>(path));

        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1,path,res);
            path.remove(path.size()-1);
        }
    }
}
