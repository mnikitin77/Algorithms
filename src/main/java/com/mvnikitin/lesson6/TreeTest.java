package com.mvnikitin.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeTest {

    private static final int MAX_TREE_INDEX = 100;
    private static final int NUMBER_OF_TREES = 20;
    private static final int TREE_DEPTH = 6;

    private List<MyTreeMap> trees;

    public TreeTest(int depth, int arraysCount) {
        trees = new ArrayList<>(arraysCount);
        int numberOfNotBalanced = 0;

        // Create and initialize trees
        for (int i = 0; i < arraysCount; i++) {
            MyTreeMap<Integer, Integer> tree = createTree(depth);
            trees.add(tree);
            if (!tree.isBalanced()) {
                numberOfNotBalanced++;
            }
        }

        System.out.printf("Of %d binary trees with the height of %d " +
                        "unbalanced are %.2f%%", arraysCount, depth,
                (numberOfNotBalanced / trees.size()) * 100f);
        System.out.println();
        System.out.println();
        System.out.println("Data listing:");

        for(MyTreeMap tree: trees) {
            System.out.println(tree);
        }
    }

    public static void main(String[] args) {
        TreeTest treeTest = new TreeTest(TREE_DEPTH, NUMBER_OF_TREES);
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
//    Size: 11, Height: 6, Is balanced: false, Root Key: -56, Tree: [ {-93}:-93  {-85}:-85  {-77}:-77  {-70}:-70  {-56}:-56  {-39}:-39  {-29}:-29  {-22}:-22  {16}:16  {40}:40  {94}:94 ]
//    Size: 8, Height: 6, Is balanced: false, Root Key: -83, Tree: [ {-83}:-83  {-60}:-60  {-48}:-48  {-10}:-10  {65}:65  {74}:74  {80}:80  {97}:97 ]
//    Size: 14, Height: 6, Is balanced: false, Root Key: -90, Tree: [ {-94}:-94  {-90}:-90  {-56}:-56  {2}:2  {19}:19  {22}:22  {26}:26  {36}:36  {66}:66  {78}:78  {90}:90  {91}:91  {97}:97  {100}:100 ]
//    Size: 17, Height: 6, Is balanced: false, Root Key: 42, Tree: [ {-98}:-98  {-81}:-81  {-75}:-75  {-62}:-62  {-61}:-61  {-19}:-19  {-17}:-17  {-4}:-4  {-3}:-3  {3}:3  {29}:29  {42}:42  {47}:47  {72}:72  {75}:75  {84}:84  {98}:98 ]
//    Size: 15, Height: 6, Is balanced: false, Root Key: 23, Tree: [ {-64}:-64  {-53}:-53  {-48}:-48  {-36}:-36  {-29}:-29  {-9}:-9  {1}:1  {22}:22  {23}:23  {45}:45  {52}:52  {67}:67  {69}:69  {73}:73  {79}:79 ]
//    Size: 17, Height: 6, Is balanced: false, Root Key: -58, Tree: [ {-99}:-99  {-86}:-86  {-76}:-76  {-58}:-58  {-57}:-57  {-56}:-56  {-49}:-49  {-47}:-47  {-19}:-19  {-12}:-12  {5}:5  {16}:16  {30}:30  {36}:36  {47}:47  {62}:62  {96}:96 ]
//    Size: 11, Height: 6, Is balanced: false, Root Key: 75, Tree: [ {-89}:-89  {-51}:-51  {-46}:-46  {-43}:-43  {-25}:-25  {-13}:-13  {-3}:-3  {18}:18  {25}:25  {75}:75  {76}:76 ]
//    Size: 17, Height: 6, Is balanced: false, Root Key: -41, Tree: [ {-78}:-78  {-59}:-59  {-46}:-46  {-41}:-41  {-40}:-40  {-22}:-22  {-16}:-16  {-14}:-14  {-6}:-6  {-3}:-3  {27}:27  {47}:47  {48}:48  {55}:55  {66}:66  {70}:70  {94}:94 ]
//    Size: 10, Height: 6, Is balanced: false, Root Key: -90, Tree: [ {-90}:-90  {-48}:-48  {-21}:-21  {-4}:-4  {-2}:-2  {0}:0  {12}:12  {13}:13  {36}:36  {63}:63 ]
//    Size: 9, Height: 6, Is balanced: false, Root Key: -97, Tree: [ {-97}:-97  {-80}:-80  {-65}:-65  {-28}:-28  {-14}:-14  {-3}:-3  {16}:16  {31}:31  {88}:88 ]
//    Size: 21, Height: 6, Is balanced: false, Root Key: -35, Tree: [ {-68}:-68  {-45}:-45  {-41}:-41  {-37}:-37  {-36}:-36  {-35}:-35  {-31}:-31  {-21}:-21  {-19}:-19  {-1}:-1  {21}:21  {27}:27  {33}:33  {39}:39  {47}:47  {48}:48  {51}:51  {54}:54  {60}:60  {65}:65  {95}:95 ]
//    Size: 13, Height: 6, Is balanced: false, Root Key: 72, Tree: [ {-72}:-72  {-52}:-52  {-43}:-43  {-38}:-38  {-15}:-15  {24}:24  {28}:28  {64}:64  {66}:66  {72}:72  {79}:79  {94}:94  {99}:99 ]
//    Size: 8, Height: 6, Is balanced: false, Root Key: 62, Tree: [ {10}:10  {23}:23  {43}:43  {44}:44  {55}:55  {58}:58  {62}:62  {91}:91 ]
//    Size: 12, Height: 6, Is balanced: false, Root Key: -96, Tree: [ {-97}:-97  {-96}:-96  {-75}:-75  {-62}:-62  {-56}:-56  {-12}:-12  {11}:11  {13}:13  {47}:47  {60}:60  {76}:76  {80}:80 ]
//    Size: 17, Height: 6, Is balanced: false, Root Key: 54, Tree: [ {-95}:-95  {-92}:-92  {-87}:-87  {-71}:-71  {-59}:-59  {-26}:-26  {-24}:-24  {-21}:-21  {-20}:-20  {-9}:-9  {-8}:-8  {12}:12  {51}:51  {54}:54  {70}:70  {75}:75  {80}:80 ]
//    Size: 14, Height: 6, Is balanced: false, Root Key: -59, Tree: [ {-92}:-92  {-72}:-72  {-59}:-59  {-46}:-46  {-33}:-33  {-5}:-5  {30}:30  {31}:31  {34}:34  {35}:35  {62}:62  {88}:88  {90}:90  {91}:91 ]
//    Size: 18, Height: 6, Is balanced: false, Root Key: 45, Tree: [ {-96}:-96  {-91}:-91  {-79}:-79  {-72}:-72  {-62}:-62  {-55}:-55  {-32}:-32  {-29}:-29  {-21}:-21  {-6}:-6  {-3}:-3  {0}:0  {24}:24  {34}:34  {45}:45  {47}:47  {58}:58  {85}:85 ]
//    Size: 15, Height: 6, Is balanced: false, Root Key: 96, Tree: [ {-77}:-77  {-48}:-48  {-43}:-43  {-1}:-1  {20}:20  {30}:30  {31}:31  {33}:33  {47}:47  {51}:51  {78}:78  {85}:85  {89}:89  {96}:96  {99}:99 ]
//    Size: 11, Height: 6, Is balanced: false, Root Key: 86, Tree: [ {-85}:-85  {-76}:-76  {-71}:-71  {-68}:-68  {-57}:-57  {-38}:-38  {-29}:-29  {5}:5  {75}:75  {86}:86  {92}:92 ]
//    Size: 10, Height: 6, Is balanced: false, Root Key: -67, Tree: [ {-72}:-72  {-67}:-67  {-24}:-24  {-8}:-8  {0}:0  {15}:15  {43}:43  {46}:46  {85}:85  {94}:94 ]