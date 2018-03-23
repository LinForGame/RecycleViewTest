package a20180323.recycleviewtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WHY on 2018/3/23.
 */

public class DataProvider {
    private static ArrayList<Map<String ,Object>> list=null;

    DataProvider(){
        if(list==null)
            list=new ArrayList<>();
    }
    public ArrayList<Map<String,Object>> getData(){
        return list;
    }
    public void initData(int count){
        Map<String,Object> map;
        for(int i=0;i<count;i++){
            map = new HashMap<>();
            map.put("String","String_"+i);
            map.put("Object","Object_"+i);
            list.add(map);
        }
    }
    public Map<String,Object> getDataByPosition(int position){
        if(list==null){
            return null;
        }
        return list.get(position);
    }
    public void clearDataProvider(){
        if(list==null)
            return;
        list.clear();
        list=null;
    }
    public int size(){
        if(list==null)
            return 0;
        return list.size();
    }
}
