package com.mvnikitin.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeTest {

    private static final int MAX_TREE_INDEX = 100;
    private static final int NUMBER_OF_TREES = 20;
    private static final int TREE_DEPTH = 6;

    private List<MyTreeMap> trees;
    private float numberOfNotBalanced;

    public TreeTest(int depth, int arraysCount) {
        trees = new ArrayList<>(arraysCount);
        numberOfNotBalanced = 0;

        // Create and initialize trees
        for (int i = 0; i < arraysCount; i++) {
            MyTreeMap<Integer, Integer> tree = createTree(depth);
            trees.add(tree);
            if (!tree.isBalanced()) {
                numberOfNotBalanced++;
            }
        }
    }

    public static void main(String[] args) {
        TreeTest treeTest = new TreeTest(TREE_DEPTH, NUMBER_OF_TREES);
        treeTest.unbalancedInfo();
        treeTest.treesDetailedInfo();
    }

    public void unbalancedInfo() {
        System.out.printf("Of %d binary trees with the height of %d " +
                        "unbalanced are %.2f%%", trees.size(), TREE_DEPTH,
                (numberOfNotBalanced / trees.size()) * 100f);
        System.out.println();
        System.out.println();
        System.out.println("Data listing:");
    }

    public void treesDetailedInfo() {
        for(MyTreeMap tree: trees) {
            System.out.println(tree);
        }
    }

    private MyTreeMap createTree(int depth) {
        MyTreeMap<Integer, Integer> tree = new MyTreeMap<>();

        Random rnd = new Random();
        int key = Integer.MIN_VALUE;

        do {
            key = rnd.nextInt(MAX_TREE_INDEX + 1);
            if (rnd.nextBoolean()) {
                key = -key;
            }
            tree.put(key, key);
        } while (tree.height() < depth);

        return tree;
    }
}


//    Of 20 binary trees with the height of 6 unbalanced are 100,00%
//
//    Data listing:
//    Size: 14, Height: 6, Is balanced: false, Root Key: -82, Tree: [ {-90}:-90  {-82}:-82  {-72}:-72  {-39}:-39  {-34}:-34  {3}:3  {31}:31  {32}:32  {39}:39  {59}:59  {66}:66  {77}:77  {82}:82  {97}:97 ]
//    Size: 17, Height: 6, Is balanced: false, Root Key: 63, Tree: [ {-97}:-97  {-84}:-84  {-66}:-66  {-59}:-59  {-50}:-50  {-39}:-39  {-35}:-35  {-30}:-30  {-1}:-1  {28}:28  {29}:29  {37}:37  {63}:63  {74}:74  {78}:78  {82}:82  {100}:100 ]
//    Size: 14, Height: 6, Is balanced: false, Root Key: -20, Tree: [ {-69}:-69  {-58}:-58  {-55}:-55  {-34}:-34  {-20}:-20  {-16}:-16  {-11}:-11  {-9}:-9  {4}:4  {10}:10  {12}:12  {61}:61  {65}:65  {67}:67 ]
//    Size: 16, Height: 6, Is balanced: false, Root Key: 86, Tree: [ {-88}:-88  {-70}:-70  {-67}:-67  {-51}:-51  {-10}:-10  {9}:9  {18}:18  {27}:27  {39}:39  {41}:41  {54}:54  {65}:65  {77}:77  {86}:86  {90}:90  {94}:94 ]
//    Size: 11, Height: 6, Is balanced: false, Root Key: -44, Tree: [ {-93}:-93  {-83}:-83  {-44}:-44  {-38}:-38  {21}:21  {24}:24  {34}:34  {60}:60  {64}:64  {67}:67  {94}:94 ]
//    Size: 19, Height: 6, Is balanced: false, Root Key: -80, Tree: [ {-100}:-100  {-89}:-89  {-82}:-82  {-80}:-80  {-65}:-65  {-56}:-56  {-41}:-41  {-38}:-38  {-37}:-37  {-30}:-30  {-13}:-13  {11}:11  {43}:43  {59}:59  {62}:62  {69}:69  {71}:71  {79}:79  {96}:96 ]
//    Size: 15, Height: 6, Is balanced: false, Root Key: 9, Tree: [ {-83}:-83  {-72}:-72  {-58}:-58  {-54}:-54  {-44}:-44  {-36}:-36  {9}:9  {14}:14  {25}:25  {39}:39  {42}:42  {50}:50  {84}:84  {91}:91  {96}:96 ]
//    Size: 16, Height: 6, Is balanced: false, Root Key: -46, Tree: [ {-75}:-75  {-72}:-72  {-52}:-52  {-51}:-51  {-46}:-46  {-38}:-38  {-37}:-37  {-34}:-34  {-22}:-22  {2}:2  {7}:7  {36}:36  {38}:38  {39}:39  {47}:47  {95}:95 ]
//    Size: 16, Height: 6, Is balanced: false, Root Key: -38, Tree: [ {-93}:-93  {-88}:-88  {-84}:-84  {-70}:-70  {-66}:-66  {-56}:-56  {-38}:-38  {0}:0  {6}:6  {56}:56  {62}:62  {69}:69  {74}:74  {75}:75  {93}:93  {100}:100 ]
//    Size: 11, Height: 6, Is balanced: false, Root Key: -45, Tree: [ {-97}:-97  {-89}:-89  {-69}:-69  {-45}:-45  {-26}:-26  {1}:1  {8}:8  {9}:9  {30}:30  {31}:31  {68}:68 ]
//    Size: 14, Height: 6, Is balanced: false, Root Key: -20, Tree: [ {-81}:-81  {-42}:-42  {-20}:-20  {10}:10  {11}:11  {15}:15  {20}:20  {35}:35  {39}:39  {40}:40  {45}:45  {71}:71  {82}:82  {85}:85 ]
//    Size: 21, Height: 6, Is balanced: false, Root Key: 5, Tree: [ {-97}:-97  {-65}:-65  {-62}:-62  {-54}:-54  {-48}:-48  {-45}:-45  {-44}:-44  {-43}:-43  {-40}:-40  {-28}:-28  {-24}:-24  {-9}:-9  {5}:5  {22}:22  {26}:26  {48}:48  {54}:54  {55}:55  {62}:62  {63}:63  {75}:75 ]
//    Size: 15, Height: 6, Is balanced: false, Root Key: 77, Tree: [ {-94}:-94  {-85}:-85  {-77}:-77  {-72}:-72  {-60}:-60  {-7}:-7  {1}:1  {16}:16  {31}:31  {34}:34  {54}:54  {63}:63  {77}:77  {89}:89  {96}:96 ]
//    Size: 15, Height: 6, Is balanced: false, Root Key: -20, Tree: [ {-81}:-81  {-78}:-78  {-44}:-44  {-27}:-27  {-20}:-20  {-15}:-15  {24}:24  {29}:29  {31}:31  {35}:35  {63}:63  {76}:76  {82}:82  {93}:93  {97}:97 ]
//    Size: 12, Height: 6, Is balanced: false, Root Key: 11, Tree: [ {-96}:-96  {-91}:-91  {-70}:-70  {-64}:-64  {-53}:-53  {-8}:-8  {-7}:-7  {-3}:-3  {6}:6  {11}:11  {32}:32  {64}:64 ]
//    Size: 12, Height: 6, Is balanced: false, Root Key: 80, Tree: [ {-60}:-60  {-41}:-41  {0}:0  {6}:6  {7}:7  {14}:14  {39}:39  {50}:50  {57}:57  {79}:79  {80}:80  {95}:95 ]
//    Size: 14, Height: 6, Is balanced: false, Root Key: -2, Tree: [ {-92}:-92  {-90}:-90  {-68}:-68  {-56}:-56  {-55}:-55  {-47}:-47  {-21}:-21  {-19}:-19  {-17}:-17  {-3}:-3  {-2}:-2  {10}:10  {85}:85  {90}:90 ]
//    Size: 19, Height: 6, Is balanced: false, Root Key: -70, Tree: [ {-98}:-98  {-94}:-94  {-85}:-85  {-70}:-70  {-60}:-60  {-43}:-43  {-41}:-41  {-31}:-31  {-4}:-4  {-1}:-1  {0}:0  {3}:3  {32}:32  {39}:39  {60}:60  {66}:66  {71}:71  {80}:80  {84}:84 ]