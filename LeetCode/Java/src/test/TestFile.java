package test;

import java.io.File;

/**
 * @program: LeetCode
 * @description:
 * @author: Yukun Lee
 * @create: 2019-10-17 17:40
 */

public class TestFile {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//		System.out.println(Find(16,arr));
        TestFile tf = new TestFile();
        tf.testCreatePath();
    }

    public void testCreatePath(){
        File files = new File("/Users/liyukun/abcdfg/");
        if(!files.exists()){
            files.mkdirs();
            System.out.println("success");
        }
    }

}
